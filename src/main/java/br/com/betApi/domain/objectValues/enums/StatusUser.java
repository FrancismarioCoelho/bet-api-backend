package br.com.betApi.domain.objectValues.enums;

public enum StatusUser {

    ATIVO("A"),
    INATIVO("I"),
    SUSPENSO("S"),
    CANCELADO("C");

    private String description;

    StatusUser(String description) {
        this.description = description;
    }
}
