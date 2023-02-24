package br.com.betApi.application.shared.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FilterDto {
    private Long id;
    private String email;
    private List<String> roles;
}
