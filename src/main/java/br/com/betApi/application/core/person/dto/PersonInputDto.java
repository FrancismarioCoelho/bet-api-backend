package br.com.betApi.application.core.person.dto;

import br.com.betApi.domain.model.user.aggregates.phone.Phone;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

public record PersonInputDto(
        Long id,
        @NotBlank(message = "Informe o campo de nome.")
        String name,
        @NotBlank(message = "Informe o campo de nickName.")
        String nickName,
        @NotBlank(message = "Informe o campo de cpf.")
        @Size(min = 11, max = 11, message = "Insira uma senha com 8 caracteres.")
        String taxId,
        @NotBlank(message = "Informe o campo de genero.")
        String gender,
        @NotNull(message = "Informe o campo de data de nascimento.")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        Date birthDate,
        List<Phone> phones
) {
}
