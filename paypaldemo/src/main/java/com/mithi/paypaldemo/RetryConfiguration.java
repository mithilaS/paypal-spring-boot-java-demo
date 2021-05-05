package com.mithi.paypaldemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
@PropertySource("${spring.config.location}/application.properties")
public class RetryConfiguration {
	
	@Value("${retry.pp.max.attempts}")
	private int maxAttempts;
	
	@Value("${retry.pp.backoff.period}")
	private long backOffPeriod;
	
	@Value("${retry.pp.backoff.policy.start.interval}")
	long retryInitInterval;
	
	@Value("${retry.pp.backoff.policy.max.interval}")
	long retryMaxInterval;
	
	@Value("${retry.pp.backoff.policy.multiplier}")
	double retryMultiplier;
	
	@Bean
    public RetryTemplate payPalRetryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
     
        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(backOffPeriod);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
        
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(maxAttempts);
        retryTemplate.setRetryPolicy(retryPolicy);
        
        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
    	backOffPolicy.setInitialInterval(retryInitInterval);
    	backOffPolicy.setMultiplier(retryMultiplier);
    	backOffPolicy.setMaxInterval(retryMaxInterval);
    	retryTemplate.setBackOffPolicy(backOffPolicy);
         
        return retryTemplate;
    }

}
