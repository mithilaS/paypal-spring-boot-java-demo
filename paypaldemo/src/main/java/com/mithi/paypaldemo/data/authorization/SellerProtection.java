
package com.mithi.paypaldemo.data.authorization;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "dispute_categories"
})
@Generated("jsonschema2pojo")
public class SellerProtection {

    @JsonProperty("status")
    private String status;
    @JsonProperty("dispute_categories")
    private List<String> disputeCategories = null;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("dispute_categories")
    public List<String> getDisputeCategories() {
        return disputeCategories;
    }

    @JsonProperty("dispute_categories")
    public void setDisputeCategories(List<String> disputeCategories) {
        this.disputeCategories = disputeCategories;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SellerProtection.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("disputeCategories");
        sb.append('=');
        sb.append(((this.disputeCategories == null)?"<null>":this.disputeCategories));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
