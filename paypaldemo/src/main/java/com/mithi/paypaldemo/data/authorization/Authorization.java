
package com.mithi.paypaldemo.data.authorization;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mithi.paypaldemo.data.authorization.Amount;
import com.mithi.paypaldemo.data.authorization.Link;
import com.mithi.paypaldemo.data.authorization.SellerProtection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "id",
    "amount",
    "invoice_id",
    "custom_id",
    "seller_protection",
    "expiration_time",
    "links",
    "create_time",
    "update_time"
})
@Generated("jsonschema2pojo")
public class Authorization {

    @JsonProperty("status")
    private String status;
    @JsonProperty("id")
    private String id;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("invoice_id")
    private String invoiceId;
    @JsonProperty("custom_id")
    private String customId;
    @JsonProperty("seller_protection")
    private SellerProtection sellerProtection;
    @JsonProperty("expiration_time")
    private String expirationTime;
    @JsonProperty("links")
    private List<Link> links = null;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("update_time")
    private String updateTime;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("amount")
    public Amount getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @JsonProperty("invoice_id")
    public String getInvoiceId() {
        return invoiceId;
    }

    @JsonProperty("invoice_id")
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    @JsonProperty("custom_id")
    public String getCustomId() {
        return customId;
    }

    @JsonProperty("custom_id")
    public void setCustomId(String customId) {
        this.customId = customId;
    }

    @JsonProperty("seller_protection")
    public SellerProtection getSellerProtection() {
        return sellerProtection;
    }

    @JsonProperty("seller_protection")
    public void setSellerProtection(SellerProtection sellerProtection) {
        this.sellerProtection = sellerProtection;
    }

    @JsonProperty("expiration_time")
    public String getExpirationTime() {
        return expirationTime;
    }

    @JsonProperty("expiration_time")
    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @JsonProperty("create_time")
    public String getCreateTime() {
        return createTime;
    }

    @JsonProperty("create_time")
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @JsonProperty("update_time")
    public String getUpdateTime() {
        return updateTime;
    }

    @JsonProperty("update_time")
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Authorization.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null)?"<null>":this.amount));
        sb.append(',');
        sb.append("invoiceId");
        sb.append('=');
        sb.append(((this.invoiceId == null)?"<null>":this.invoiceId));
        sb.append(',');
        sb.append("customId");
        sb.append('=');
        sb.append(((this.customId == null)?"<null>":this.customId));
        sb.append(',');
        sb.append("sellerProtection");
        sb.append('=');
        sb.append(((this.sellerProtection == null)?"<null>":this.sellerProtection));
        sb.append(',');
        sb.append("expirationTime");
        sb.append('=');
        sb.append(((this.expirationTime == null)?"<null>":this.expirationTime));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("createTime");
        sb.append('=');
        sb.append(((this.createTime == null)?"<null>":this.createTime));
        sb.append(',');
        sb.append("updateTime");
        sb.append('=');
        sb.append(((this.updateTime == null)?"<null>":this.updateTime));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
