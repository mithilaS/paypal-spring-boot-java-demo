package com.mithi.paypaldemo.service;

import com.mithi.paypaldemo.client.PayPalRestClient;
import com.mithi.paypaldemo.data.*;
import com.mithi.paypaldemo.data.authorization.AuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
public class PayPalService {
    @Value("${demo.order.test1.total.order.amount}")
    private String test1Amount;

    @Value("${demo.order.test1.total.count}")
    private String test1Count;

    @Value("${demo.order.test2.total.order.amount}")
    private String test2Amount;

    @Value("${demo.order.test.delay.time.milliseconds}")
    private String orderDelayTimeMs;

    @Value("${demo.authorization.test2.amount}")
    private String authAmt;

    private static final Logger log = LoggerFactory.getLogger(PayPalService.class);


    @Autowired
    private PayPalRestClient payPalRestClient;

    Integer invoiceNumber = 001;

    private  PayPalOauth oauthToken;

    @Autowired
    private HashMap cacheMap;

    public HashMap getCacheMap() {
        return cacheMap;
    }

    public void setCacheMap(HashMap cacheMap) {
        this.cacheMap = cacheMap;
    }

    public PayPalOauth getOauthToken(){
        PayPalOauth oauthToken = payPalRestClient.getOauthToken();
        if(oauthToken !=null )
            cacheMap.put("ACCESS_TOKEN" , oauthToken);
    return oauthToken;
    }

    @Async
    public Future<List<OrderResponse>> createOrders() throws InterruptedException {
        PayPalOauth access_token = cacheMap.get("ACCESS_TOKEN") ==  null ? null: (PayPalOauth) cacheMap.get("ACCESS_TOKEN");
        if(access_token == null){
            oauthToken = payPalRestClient.getOauthToken();
            cacheMap.put("ACCESS_TOKEN" , oauthToken);
        }else {
            oauthToken = access_token;
        }
         if(oauthToken !=null && oauthToken.getAccess_token() !=null){
            String token = oauthToken.getAccess_token();
            List<OrderResponse> orderResponseList = new ArrayList<>();

            for(int i =1;i<=Integer.parseInt(test1Count);i++){
                log.info("Order count: " + i);
                OrderResponse orderTest1 = createOrder(test1Amount);
                orderResponseList.add(orderTest1);
                log.info(orderTest1.toString());
                Thread.sleep(Long.parseLong(orderDelayTimeMs));
                log.info("----------------------------------------------------------");
            }

            return new CompletableFuture<List<OrderResponse>>();

        }
         return new CompletableFuture<>();

    }

    public OrderResponse createTest2Order(){
        log.info("Test 2 Create order test amount : " +  test2Amount);
        OrderResponse order = createOrder(test2Amount);
        return order;
    }
    public OrderResponse createOrder(String amount){

        log.info("In create order");

        PayPalOauth access_token = cacheMap ==null || cacheMap.get("ACCESS_TOKEN") == null ? null: (PayPalOauth) cacheMap.get("ACCESS_TOKEN");
        if(access_token == null){
            oauthToken = payPalRestClient.getOauthToken();
        }else {
            oauthToken = access_token;
        }
        Orders orders = new Orders();
        orders.setIntent("AUTHORIZE");
        orders.setProcessingInstruction("ORDER_SAVED_EXPLICITLY");

        ApplicationContext context = new ApplicationContext();
        context.setBrandName("Qalara");
        context.setUserAction("PAY_NOW");
        context.setShippingPreference("NO_SHIPPING");
        context.setReturnUrl("https://www.example.com/return");
        context.setCancelUrl("https://www.example.com/cancel");

        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setPayerSelected("PAYPAL");
        paymentMethod.setPayeePreferred("IMMEDIATE_PAYMENT_REQUIRED");
        context.setPaymentMethod(paymentMethod);
        orders.setApplicationContext(context);

        Payer payer = new Payer();
        Name name= new Name();
        name.setGivenName("Mithila");
        name.setSurname("S");
        payer.setName(name);
        payer.setEmailAddress("us_buyer1@gmail.com");
        Address address = new Address();
        address.setAddressLine1("2211 N");
        address.setAddressLine2("1st STREET");
        address.setAdminArea2("Sydney");
        address.setAdminArea1("New South Wales");
        address.setPostalCode("2009");
        address.setCountryCode("AU");
        payer.setAddress(address);
        orders.setPayer(payer);

        PurchaseUnit purchaseUnit = new PurchaseUnit();
        purchaseUnit.setDescription("Test Sports goods");
        purchaseUnit.setCustomId("GB-TEST-0001");
        purchaseUnit.setSoftDescriptor("Qalara");
        Random rand = new Random(); //instance of random class
        int upperbound = 50000;
        Integer int_random = rand.nextInt(upperbound);
        purchaseUnit.setInvoiceId("INV-GB-TEST-"+ int_random.toString());

        Amount amount1 = new Amount();
        amount1.setCurrencyCode("USD");
        amount1.setValue(amount);
        Breakdown breakdown = new Breakdown();
        ItemTotal itemTotal= new ItemTotal();
        itemTotal.setCurrencyCode("USD");
        itemTotal.setValue(amount);
        breakdown.setItemTotal(itemTotal);
        amount1.setBreakdown(breakdown);
        purchaseUnit.setAmount(amount1);

        Item item = new Item();
        item.setName("Teak Wood Chair");
        item.setDescription("Teak Wood Chair");
        UnitAmount unitAmount = new UnitAmount();
        unitAmount.setCurrencyCode("USD");
        unitAmount.setValue(amount);
        item.setUnitAmount(unitAmount);
        item.setQuantity("1");
        item.setCategory("PHYSICAL_GOODS");
        List itemList = new ArrayList<>();
        itemList.add(item);
        purchaseUnit.setItems(itemList);
        List<PurchaseUnit> purchaseUnitList = new ArrayList<>();
        purchaseUnitList.add(purchaseUnit);
        orders.setPurchaseUnits(purchaseUnitList);

        OrderResponse order = payPalRestClient.createOrder(oauthToken.getAccess_token(), orders);
        return order;
    }

    @Async(value="taskExecutor")
    public void createBulkAuthCapture(String orderId,  String delayTime, Integer totalCount, Boolean saveorder) throws InterruptedException {
        log.info("In create Bulk Auth Capture");

        PayPalOauth access_token = cacheMap ==null || cacheMap.get("ACCESS_TOKEN") == null ? null: (PayPalOauth) cacheMap.get("ACCESS_TOKEN");
        if(access_token == null){
            oauthToken = payPalRestClient.getOauthToken();
        }else {
            oauthToken = access_token;
        }
        if(oauthToken==null )
            return;
        StringBuilder orderUrl = new StringBuilder();
        orderUrl.append("v2/checkout/orders/").append(orderId).append("/save");
        boolean ordersaved =true;
        if(saveorder) {
            try{
                String s = payPalRestClient.saveOrder(oauthToken.getAccess_token(), orderUrl.toString());
            }catch (Exception e){
                ordersaved=false;
                return;
            }

        }
        for(int i=1;i<=totalCount; i++ ){
            log.info("---------------------------------------------------------------------------");
            Thread.sleep(Long.parseLong(delayTime));
            AuthorizeRequest authorizeRequest = new AuthorizeRequest();
            Amount amount = new Amount();
            log.info(" authAmt : " +  authAmt);
            amount.setValue(authAmt);
            amount.setCurrencyCode("USD");
            authorizeRequest.setAmount(amount);
            StringBuilder url = new StringBuilder();
            url.append("v2/checkout/orders/").append(orderId).append("/authorize");
            AuthResponse authorization = payPalRestClient.createAuthorization(authorizeRequest, url.toString(), oauthToken.getAccess_token());
            if(authorization != null && authorization.getPurchaseUnits() !=null ){
                if(!authorization.getPurchaseUnits().isEmpty() && authorization.getPurchaseUnits().get(0).getPayments() !=null){
                    List<com.mithi.paypaldemo.data.authorization.Authorization> authorizations = authorization.getPurchaseUnits().get(0)
                            .getPayments().getAuthorizations();
                    Optional<com.mithi.paypaldemo.data.authorization.Authorization> authcreated = authorizations.stream().filter(e -> e.getStatus().equals("CREATED")).findFirst();

                    if(authcreated.isPresent()){
                        com.mithi.paypaldemo.data.authorization.Authorization authorization1 = authcreated.get();
                        CaptureRequest captureRequest = new CaptureRequest();
                        captureRequest.setAmount(amount);
                        captureRequest.setFinalCapture(false);
                        Random rand = new Random(); //instance of random class
                        int upperbound = 50000;
                        Integer int_random = rand.nextInt(upperbound);

                        captureRequest.setInvoiceId("INV-GB-TEST2-"+ int_random.toString());
                        StringBuilder captureurl = new StringBuilder();
                        captureurl.append("v2/payments/authorizations/").append(authorization1.getId()).append("/capture");
                        try{
                            CaptureResponse captureResponse = payPalRestClient.capturePayment(
                                    captureRequest, captureurl.toString(), oauthToken.getAccess_token());
                        }catch (RestClientException ex){
                            log.info("In order capture catch block");
                            ex.getCause().printStackTrace();
                        }
                    }

                }

            }
        }

    }
}
