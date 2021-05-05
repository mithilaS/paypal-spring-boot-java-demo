
package com.mithi.paypaldemo.data;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class SellerReceivableBreakdown {

    private GrossAmount grossAmount;
    private PaypalFee paypalFee;
    private NetAmount netAmount;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public GrossAmount getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(GrossAmount grossAmount) {
        this.grossAmount = grossAmount;
    }

    public PaypalFee getPaypalFee() {
        return paypalFee;
    }

    public void setPaypalFee(PaypalFee paypalFee) {
        this.paypalFee = paypalFee;
    }

    public NetAmount getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(NetAmount netAmount) {
        this.netAmount = netAmount;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
