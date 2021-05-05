package com.mithi.paypaldemo.data;

public class PayPalOauth {

    public String scope;
    public String access_token;
    public String token_type;
    public String app_id;
    public int expires_in;
    public String nonce;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "PayPalOauth{" +
                "scope='" + scope + '\'' +
                ", access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", app_id='" + app_id + '\'' +
                ", expires_in=" + expires_in +
                ", nonce='" + nonce + '\'' +
                '}';
    }
}
