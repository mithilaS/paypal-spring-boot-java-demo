
package com.mithi.paypaldemo.data.authorization;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mithi.paypaldemo.data.authorization.Authorization;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorizations"
})
@Generated("jsonschema2pojo")
public class Payments {

    @JsonProperty("authorizations")
    private List<com.mithi.paypaldemo.data.authorization.Authorization> authorizations = null;

    @JsonProperty("authorizations")
    public List<com.mithi.paypaldemo.data.authorization.Authorization> getAuthorizations() {
        return authorizations;
    }

    @JsonProperty("authorizations")
    public void setAuthorizations(List<Authorization> authorizations) {
        this.authorizations = authorizations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Payments.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("authorizations");
        sb.append('=');
        sb.append(((this.authorizations == null)?"<null>":this.authorizations));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
