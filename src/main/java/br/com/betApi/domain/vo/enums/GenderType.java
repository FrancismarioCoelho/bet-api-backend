package br.com.betApi.domain.vo.enums;

import lombok.Getter;

@Getter
public enum GenderType {

    MASCULINO("M"),
    FEMININO("F"),
    OUTROS("O");
    private String description;
    GenderType(String description) {
        this.description = description;
    }
}
