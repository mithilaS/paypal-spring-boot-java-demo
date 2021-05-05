
package com.mithi.paypaldemo.data.authorization;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "national_number"
})
@Generated("jsonschema2pojo")
public class PhoneNumber {

    @JsonProperty("national_number")
    private String nationalNumber;

    @JsonProperty("national_number")
    public String getNationalNumber() {
        return nationalNumber;
    }

    @JsonProperty("national_number")
    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PhoneNumber.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("nationalNumber");
        sb.append('=');
        sb.append(((this.nationalNumber == null)?"<null>":this.nationalNumber));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
