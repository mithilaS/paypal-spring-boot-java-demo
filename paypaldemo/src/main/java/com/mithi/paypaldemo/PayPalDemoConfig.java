package com.mithi.paypaldemo;

import com.mithi.paypaldemo.data.Orders;
import com.mithi.paypaldemo.data.PayPalOauth;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.nio.charset.Charset;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;


@Configuration
public class PayPalDemoConfig {

    @Value("${demo.baseurl}")
    private String baseurl;

    @Value("${demo.client.id}")
    private String clientid;

    @Value("${demo.client.secret}")
    private String clientsecret;

    @Value("${demo.baseurl}")
    private String environment;

    @Value("${rest.client.connectionTimeoutMillis}")
    private int restClientConnectionTimeoutMillis;

    @Value("${rest.client.readTimeoutMillis}")
    private int restClientReadTimeoutMillis;

    @Value("${rest.client.maxConnectionsPerHost}")
    private int restClientMaxConnectionsPerHost;

    @Value("${rest.client.maxTotalConnections}")
    private int restClientMaxTotalConnections;


    private static final Logger log = LoggerFactory.getLogger(PayPalDemoConfig.class);
   /* @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        DefaultHttpClient httpClient = new DefaultHttpClient();
        // We're going to try and load and enable TLS version 1.2 standard communication context from JSSE Providers
        // This is enabled only for download media Mirakl as some merchants don't accept communication with TLS versions prior to 1.1
        try {
            SSLContext context;
            context = SSLContext.getInstance("TLSv1.2");
            context.init(null, null, null);

            SSLSocketFactory ssf = new SSLSocketFactory(context);
            ClientConnectionManager ccm = httpClient.getConnectionManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            sr.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
            sr.register(new Scheme("https", 443, ssf));

        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            LOGGER.warn("Could not load the TLS version 1.2 due to => ", e);
        }

        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
        return restTemplate;
    }*/
 /*  @Bean
   public RestTemplate restTemplate(RestTemplateBuilder builder) {
       return builder.setConnectTimeout(Duration.of(10000, ChronoUnit.MILLIS))
               .setReadTimeout(Duration.of(10000, ChronoUnit.MILLIS))
                .build();
   }*/

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        return executor;
    }

    @Bean
    public HashMap<String , ? > cacheMap(){
       return new HashMap<>();
    }
    @Bean(name="payPalRestTemplate" )
    public RestTemplate payPalRestTemplate() {
        RestTemplate template = new RestTemplate();

        // Set pooling config
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(restClientMaxTotalConnections);
        connectionManager.setDefaultMaxPerRoute(restClientMaxConnectionsPerHost);

        // Set connection and read timeout
        HttpComponentsClientHttpRequestFactory httpClientFatory = new HttpComponentsClientHttpRequestFactory(
                HttpClients.custom().setConnectionManager(connectionManager).build());
        httpClientFatory.setConnectionRequestTimeout(restClientConnectionTimeoutMillis);
        httpClientFatory.setReadTimeout(restClientReadTimeoutMillis);

        // Configure rest template per above
        BufferingClientHttpRequestFactory bufferingHttpClientFatory = new BufferingClientHttpRequestFactory(httpClientFatory);
        template.setRequestFactory(bufferingHttpClientFatory);

        return template;
    }

   /* public CommandLineRunner run() throws Exception {
        return args -> {
            String oauthToken = this.payPalRestClient.getOauthToken();
            log.info("AuthToken: " ,oauthToken );
        };
    }*/

}
