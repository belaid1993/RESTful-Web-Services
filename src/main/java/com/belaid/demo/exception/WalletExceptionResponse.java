package com.belaid.demo.exception;


public class WalletExceptionResponse {

    private String id;

    public WalletExceptionResponse(String id) {
        this.id = id;
    }

    public WalletExceptionResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
