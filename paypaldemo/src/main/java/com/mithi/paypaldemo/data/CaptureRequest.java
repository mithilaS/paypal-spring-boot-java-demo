
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
    "amount",
    "final_capture"
})
@Generated("jsonschema2pojo")
public class CaptureRequest {

    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("final_capture")
    private Boolean finalCapture;

    @JsonProperty("invoice_id")
    private String invoiceId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("amount")
    public Amount getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @JsonProperty("final_capture")
    public Boolean getFinalCapture() {
        return finalCapture;
    }

    @JsonProperty("final_capture")
    public void setFinalCapture(Boolean finalCapture) {
        this.finalCapture = finalCapture;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonProperty("invoice_id")
    public String getInvoiceId() {
        return invoiceId;
    }

    @JsonProperty("invoice_id")
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
