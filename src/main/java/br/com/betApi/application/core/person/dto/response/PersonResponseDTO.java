package br.com.betApi.application.core.person.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record PersonResponseDTO(Long id,
                                String name,
                                String email,
                                String nickName,
                                String taxId,
                                String gender,
                                LocalDateTime birthDate,
                                Double credit,
                                List<PhoneResponseDTO> phones) {
}
