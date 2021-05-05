
package com.mithi.paypaldemo.data;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "brand_name",
    "user_action",
    "shipping_preference",
    "return_url",
    "cancel_url",
    "payment_method"
})
@Generated("jsonschema2pojo")
public class ApplicationContext {

    @JsonProperty("brand_name")
    private String brandName;
    @JsonProperty("user_action")
    private String userAction;
    @JsonProperty("shipping_preference")
    private String shippingPreference;
    @JsonProperty("return_url")
    private String returnUrl;
    @JsonProperty("cancel_url")
    private String cancelUrl;
    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("brand_name")
    public String getBrandName() {
        return brandName;
    }

    @JsonProperty("brand_name")
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @JsonProperty("user_action")
    public String getUserAction() {
        return userAction;
    }

    @JsonProperty("user_action")
    public void setUserAction(String userAction) {
        this.userAction = userAction;
    }

    @JsonProperty("shipping_preference")
    public String getShippingPreference() {
        return shippingPreference;
    }

    @JsonProperty("shipping_preference")
    public void setShippingPreference(String shippingPreference) {
        this.shippingPreference = shippingPreference;
    }

    @JsonProperty("return_url")
    public String getReturnUrl() {
        return returnUrl;
    }

    @JsonProperty("return_url")
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    @JsonProperty("cancel_url")
    public String getCancelUrl() {
        return cancelUrl;
    }

    @JsonProperty("cancel_url")
    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    @JsonProperty("payment_method")
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    @JsonProperty("payment_method")
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
