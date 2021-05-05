
package com.mithi.paypaldemo.data.authorization;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mithi.paypaldemo.data.authorization.Payments;
import com.mithi.paypaldemo.data.authorization.Shipping;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "shipping",
    "payments"
})
@Generated("jsonschema2pojo")
public class PurchaseUnit {

    @JsonProperty("id")
    private String id;
    @JsonProperty("shipping")
    private Shipping shipping;
    @JsonProperty("payments")
    private Payments payments;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("shipping")
    public Shipping getShipping() {
        return shipping;
    }

    @JsonProperty("shipping")
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    @JsonProperty("payments")
    public Payments getPayments() {
        return payments;
    }

    @JsonProperty("payments")
    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PurchaseUnit.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("shipping");
        sb.append('=');
        sb.append(((this.shipping == null)?"<null>":this.shipping));
        sb.append(',');
        sb.append("payments");
        sb.append('=');
        sb.append(((this.payments == null)?"<null>":this.payments));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
