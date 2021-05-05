
package com.mithi.paypaldemo.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class SellerProtection {

    private String status;
    private List<String> disputeCategories = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getDisputeCategories() {
        return disputeCategories;
    }

    public void setDisputeCategories(List<String> disputeCategories) {
        this.disputeCategories = disputeCategories;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
