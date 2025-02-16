package br.com.betApi.domain.vo.enums;

import lombok.Getter;

@Getter
public enum TypePayment {

    CARD("C"),PIX("P"),BOLET("B");

    private String description;

    TypePayment(String description) {
        this.description = description;
    }
}
