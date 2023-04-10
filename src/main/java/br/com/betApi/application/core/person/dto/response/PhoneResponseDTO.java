package br.com.betApi.application.core.person.dto.response;

public record PhoneResponseDTO(Long id,
                               String ddi,
                               String ddd,
                               String number,
                               Boolean whatsApp) {
}
