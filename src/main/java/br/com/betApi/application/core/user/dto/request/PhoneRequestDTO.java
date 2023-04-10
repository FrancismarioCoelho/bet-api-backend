package br.com.betApi.application.core.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PhoneRequestDTO(Long id,
                              @NotBlank(message = "Informe o campo ddi.")
                              @Size(min = 2,max =4)
                              String ddi,
                              @NotBlank(message = "Informe o campo ddd.")
                              @Size(min = 2,max =4 )
                              String ddd,
                              @NotBlank(message = "Informe o campo numero.")
                              @Size(min = 9, max = 10)
                              String number,
                              @NotNull(message = "Informe o campo whatsApp.")
                              boolean isWhatsApp) {
}
