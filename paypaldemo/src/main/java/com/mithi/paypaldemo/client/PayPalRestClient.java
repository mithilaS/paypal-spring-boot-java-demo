package com.mithi.paypaldemo.client;

import com.mithi.paypaldemo.data.*;
import com.mithi.paypaldemo.data.authorization.AuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.retry.support.RetryTemplate;

import javax.annotation.Resource;

@Service
public class PayPalRestClient {
    private static final Logger log = LoggerFactory.getLogger(PayPalRestClient.class);

    @Value("${demo.baseurl}")
    private String payPalBaseUrl;

    @Value("${demo.client.id}")
    private String clientid;

    @Value("${demo.client.secret}")
    private String clientsecret;


    @Resource(name = "payPalRestTemplate")
    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PayPalOauth getOauthToken(){
        HttpHeaders headers = new HttpHeaders();
      //  headers.setContentType(MediaType.APPLICATION_JSON);
        String token =null;
        headers.setBasicAuth(clientid, clientsecret);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Accept-Language", "en_US");
        headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);

        // set entity to send
        HttpEntity<String> entity =
                new HttpEntity<String>("grant_type=client_credentials", headers);
        PayPalOauth response = null;
        String url = String.format("%s%s", payPalBaseUrl, "v1/oauth2/token");
        log.info("url : " + url);
        try {
            response = restPostObjectWithRetry(url, entity, PayPalOauth.class);
        }catch(HttpClientErrorException he) {
            log.error("Status : " + he.getStatusCode() + " Message : " + he.getMessage());
            log.error("Headers: " +  he.getResponseHeaders());
            log.error("Response body : " +  he.getResponseBodyAsString());
        }
        catch (RestClientException ex) {
            log.error("Rest exception on calling PayPal oauth: ", ex);

        }catch(Exception e){
            log.error("Other exception thrown: " , e);

        }
        return response;
    }

    public OrderResponse createOrder(String token, Orders orders) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
      //  headers.setBasicAuth(clientid, clientsecret);
        headers.setBearerAuth(token);

        headers.set("Accept-Language", "en_US");
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Orders> entity =
                new HttpEntity<Orders>(orders, headers);
        OrderResponse response = null;
        String url = String.format("%s%s", payPalBaseUrl, "v2/checkout/orders");
        log.info("url : " + url);
        try {
            response = restPostObjectWithRetry(url, entity, OrderResponse.class);
        }catch(HttpClientErrorException he) {
            log.error("Status : " + he.getStatusCode() + " Message : " + he.getMessage());
            log.error("Headers: " +  he.getResponseHeaders());
            log.error("Response body : " +  he.getResponseBodyAsString());
        }
        catch (RestClientException ex) {
            log.error("Rest exception on calling PayPal oauth: ", ex);
            ex.printStackTrace();

        }catch(Exception e){
            log.error("Other exception thrown: " , e);
            e.printStackTrace();
        }
        return response;
    }

    public AuthResponse createAuthorization(AuthorizeRequest authorizeRequest, String url, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //  headers.setBasicAuth(clientid, clientsecret);
        headers.setBearerAuth(token);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<AuthorizeRequest> entity =
                new HttpEntity<AuthorizeRequest>(authorizeRequest, headers);

        AuthResponse response = new AuthResponse();
        String fullurl = String.format("%s%s", payPalBaseUrl, url);

        log.info("url : " + fullurl);

        try {
            response = restPostObjectWithRetry(fullurl, entity, AuthResponse.class);
        }catch(HttpClientErrorException he) {
            log.error("Status : " + he.getStatusCode() + " Message : " + he.getMessage());
            log.error("Headers: " +  he.getResponseHeaders());
            log.error("Response body : " +  he.getResponseBodyAsString());
        }
        catch (RestClientException ex) {
            log.error("Rest exception on calling PayPal oauth: ", ex);
            ex.printStackTrace();

        }catch(Exception e){
            log.error("Other exception thrown: " , e);
            e.printStackTrace();
        }
        return response;
    }

    @Autowired
    private RetryTemplate payPalRetryTemplate;


    /**
     * Retry logic to call Dion rest apis.
     * @param entity
     * @param url
     * @param clazz
     * @param <E>
     * @return
     */
    private <E> E restPostObjectWithRetry(String url, HttpEntity entity, Class<E> clazz) {
        E response =null ;

        try{
            response = this.payPalRetryTemplate.execute(arg0 -> {
                return this.restTemplate.postForObject(url, entity, clazz, new Object[] {});
            });
        }catch (RestClientException e) {
            log.warn("Retry call failed for url: " + url);
            throw e;
        }
        return response;
    }


    public String saveOrder(String token , String endUrl) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //  headers.setBasicAuth(clientid, clientsecret);
        headers.setBearerAuth(token);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity entity =
                new HttpEntity<AuthorizeRequest>(null, headers);

       String response = null;
        String fullurl = String.format("%s%s", payPalBaseUrl, endUrl);

        log.info("url : " + fullurl);

        try {
            response = restPostObjectWithRetry(fullurl, entity, String.class);
            log.info("Response received : " + response);

        }catch(HttpClientErrorException he) {
            log.error("Status : " + he.getStatusCode() + " Message : " + he.getMessage());
            log.error("Headers: " +  he.getResponseHeaders());
            log.error("Response body : " +  he.getResponseBodyAsString());
            throw he;
        }
        catch (RestClientException ex) {
            log.error("Rest exception on calling PayPal oauth: ", ex);
            ex.printStackTrace();
            throw ex;

        }catch(Exception e){
            log.error("Other exception thrown: " , e);
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public CaptureResponse capturePayment(CaptureRequest captureRequest,  String endUrl, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //  headers.setBasicAuth(clientid, clientsecret);
        headers.setBearerAuth(token);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<CaptureRequest> entity =
                new HttpEntity<CaptureRequest>(captureRequest, headers);

        CaptureResponse response = null;
        String fullurl = String.format("%s%s", payPalBaseUrl, endUrl);

        log.info("url : " + fullurl);

        try {
            response = restPostObjectWithRetry(fullurl, entity, CaptureResponse.class);
            log.info("Response received : " + response);

        }catch(HttpClientErrorException he) {
            log.error("Status : " + he.getStatusCode() + " Message : " + he.getMessage());
            log.error("Headers: " +  he.getResponseHeaders());
            log.error("Response body : " +  he.getResponseBodyAsString());
        }
        catch (RestClientException ex) {
            log.error("Rest exception on calling PayPal oauth: ", ex);
            ex.printStackTrace();

            ex.getCause().printStackTrace();
            throw ex;

        }catch(Exception e){
            log.error("Other exception thrown: " , e);
            e.printStackTrace();
        }
        return response;
    }
}
