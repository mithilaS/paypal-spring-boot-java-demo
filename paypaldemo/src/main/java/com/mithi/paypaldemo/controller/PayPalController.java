package com.mithi.paypaldemo.controller;

import com.mithi.paypaldemo.client.PayPalRestClient;
import com.mithi.paypaldemo.data.OrderResponse;
import com.mithi.paypaldemo.data.Orders;
import com.mithi.paypaldemo.data.PayPalOauth;
import com.mithi.paypaldemo.service.PayPalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PayPalController {

    @Autowired
    private PayPalRestClient payPalRestClient;

    @Value("${demo.authorization.test2.total.count}")
    private String totalAuthCount;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private PayPalService payPalService;

    private static final Logger log = LoggerFactory.getLogger(PayPalController.class);

    @RequestMapping(value = "/paypaldemo/generatetoken", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public PayPalOauth getPayPalToken() {
        PayPalOauth payPalOauth = payPalService.getOauthToken();
        log.info("Auth token received : " + payPalOauth.toString());
        return payPalOauth;
    }

    @RequestMapping(value = "/paypaldemo/createorder", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String createbulkorder() {
        List<OrderResponse> orders= null;
        try {
            payPalService.createOrders();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Order creation in process. Please check logs";
    }

    @RequestMapping(value = "/paypaldemo/createorder/test2", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public OrderResponse createTest2Order(){
        OrderResponse test2Order = payPalService.createTest2Order();
        if(test2Order !=null)
            test2Order.setMessage("Please approve the order using the link under rel:approve");
        return test2Order;
    }

    @RequestMapping(value = "/paypaldemo/createAuthCapture/test2", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String createBulkAuthCapture(@RequestParam(value = "orderId") String orderId,
                                        @RequestParam(value = "delaytime") String delayTime,
                                        @RequestParam(value = "totalcount") Integer totalCount,
                                        @RequestParam(value = "saveorder") Boolean saveOrder){
        try {
            payPalService.createBulkAuthCapture( orderId,   delayTime,  totalCount, saveOrder);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Bulk Authorization started successfully.";
    }
}
