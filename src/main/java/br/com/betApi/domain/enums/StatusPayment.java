package br.com.betApi.domain.enums;

import lombok.Getter;

@Getter
public enum StatusPayment {

    APPROVED("A"),
    DISAPPROVED("D"),
    WAITING("W");

    private String description;

    StatusPayment(String description) {
        this.description = description;
    }
}
