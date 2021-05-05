
package com.mithi.paypaldemo.data.authorization;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mithi.paypaldemo.data.authorization.Phone;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "email_address",
    "payer_id",
    "phone",
    "address"
})
@Generated("jsonschema2pojo")
public class Payer {

    @JsonProperty("name")
    private Name name;
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("payer_id")
    private String payerId;
    @JsonProperty("phone")
    private Phone phone;
    @JsonProperty("address")
    private Address address;

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

    @JsonProperty("email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("email_address")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonProperty("payer_id")
    public String getPayerId() {
        return payerId;
    }

    @JsonProperty("payer_id")
    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    @JsonProperty("phone")
    public Phone getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Payer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("emailAddress");
        sb.append('=');
        sb.append(((this.emailAddress == null)?"<null>":this.emailAddress));
        sb.append(',');
        sb.append("payerId");
        sb.append('=');
        sb.append(((this.payerId == null)?"<null>":this.payerId));
        sb.append(',');
        sb.append("phone");
        sb.append('=');
        sb.append(((this.phone == null)?"<null>":this.phone));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
