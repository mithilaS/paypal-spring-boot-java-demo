
package com.mithi.paypaldemo.data.authorization;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mithi.paypaldemo.data.authorization.Payer;
import com.mithi.paypaldemo.data.authorization.PurchaseUnit;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "status",
    "purchase_units",
    "payer",
    "links"
})
@Generated("jsonschema2pojo")
public class AuthResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("status")
    private String status;
    @JsonProperty("purchase_units")
    private List<PurchaseUnit> purchaseUnits = null;
    @JsonProperty("payer")
    private Payer payer;
    @JsonProperty("links")
    private List<Link> links = null;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("purchase_units")
    public List<PurchaseUnit> getPurchaseUnits() {
        return purchaseUnits;
    }

    @JsonProperty("purchase_units")
    public void setPurchaseUnits(List<PurchaseUnit> purchaseUnits) {
        this.purchaseUnits = purchaseUnits;
    }

    @JsonProperty("payer")
    public Payer getPayer() {
        return payer;
    }

    @JsonProperty("payer")
    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AuthResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("purchaseUnits");
        sb.append('=');
        sb.append(((this.purchaseUnits == null)?"<null>":this.purchaseUnits));
        sb.append(',');
        sb.append("payer");
        sb.append('=');
        sb.append(((this.payer == null)?"<null>":this.payer));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
