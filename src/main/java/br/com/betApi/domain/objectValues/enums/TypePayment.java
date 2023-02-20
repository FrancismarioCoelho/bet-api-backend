package br.com.betApi.domain.objectValues.enums;

public enum TypePayment {

    CARD("C"),PIX("P"),BOLET("B");

    private String description;

    TypePayment(String description) {
        this.description = description;
    }
}
