
package com.mithi.paypaldemo.data;

import java.util.HashMap;
import java.util.List;
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
    "intent",
    "processing_instruction",
    "application_context",
    "payer",
    "purchase_units"
})
@Generated("jsonschema2pojo")
public class Orders {

    @JsonProperty("intent")
    private String intent;
    @JsonProperty("processing_instruction")
    private String processingInstruction;
    @JsonProperty("application_context")
    private ApplicationContext applicationContext;
    @JsonProperty("payer")
    private Payer payer;
    @JsonProperty("purchase_units")
    private List<PurchaseUnit> purchaseUnits = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("intent")
    public String getIntent() {
        return intent;
    }

    @JsonProperty("intent")
    public void setIntent(String intent) {
        this.intent = intent;
    }

    @JsonProperty("processing_instruction")
    public String getProcessingInstruction() {
        return processingInstruction;
    }

    @JsonProperty("processing_instruction")
    public void setProcessingInstruction(String processingInstruction) {
        this.processingInstruction = processingInstruction;
    }

    @JsonProperty("application_context")
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @JsonProperty("application_context")
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @JsonProperty("payer")
    public Payer getPayer() {
        return payer;
    }

    @JsonProperty("payer")
    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    @JsonProperty("purchase_units")
    public List<PurchaseUnit> getPurchaseUnits() {
        return purchaseUnits;
    }

    @JsonProperty("purchase_units")
    public void setPurchaseUnits(List<PurchaseUnit> purchaseUnits) {
        this.purchaseUnits = purchaseUnits;
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
