
package com.mithi.paypaldemo.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CaptureResponse {

    private String id;
    private Amount amount;
    private Boolean finalCapture;
    private SellerProtection sellerProtection;
    private SellerReceivableBreakdown sellerReceivableBreakdown;
    private String invoiceId;
    private String status;
    private String createTime;
    private String updateTime;
    private List<Link> links = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Boolean getFinalCapture() {
        return finalCapture;
    }

    public void setFinalCapture(Boolean finalCapture) {
        this.finalCapture = finalCapture;
    }

    public SellerProtection getSellerProtection() {
        return sellerProtection;
    }

    public void setSellerProtection(SellerProtection sellerProtection) {
        this.sellerProtection = sellerProtection;
    }

    public SellerReceivableBreakdown getSellerReceivableBreakdown() {
        return sellerReceivableBreakdown;
    }

    public void setSellerReceivableBreakdown(SellerReceivableBreakdown sellerReceivableBreakdown) {
        this.sellerReceivableBreakdown = sellerReceivableBreakdown;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
