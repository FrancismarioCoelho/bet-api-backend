package br.com.betApi.domain.objectValues.enums;

public enum StatusPayment {


    APPROVED("A"),DISAPPROVED("D"),WAITING("W");

    private String description;

    StatusPayment(String description) {
        this.description = description;
    }
}
