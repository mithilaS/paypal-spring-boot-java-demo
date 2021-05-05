
package com.mithi.paypaldemo.data.authorization;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "given_name",
    "surname"
})
@Generated("jsonschema2pojo")
public class Name__1 {

    @JsonProperty("given_name")
    private String givenName;
    @JsonProperty("surname")
    private String surname;

    @JsonProperty("given_name")
    public String getGivenName() {
        return givenName;
    }

    @JsonProperty("given_name")
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @JsonProperty("surname")
    public String getSurname() {
        return surname;
    }

    @JsonProperty("surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Name__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("givenName");
        sb.append('=');
        sb.append(((this.givenName == null)?"<null>":this.givenName));
        sb.append(',');
        sb.append("surname");
        sb.append('=');
        sb.append(((this.surname == null)?"<null>":this.surname));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
