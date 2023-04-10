package br.com.betApi.domain.model.person.aggregates.phone;

import br.com.betApi.application.core.user.dto.request.PhoneRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tb_phone")
public class Phone {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ddi")
    private String ddi;

    @Column(name = "ddd")
    private String ddd;

    @Column(name = "number")
    private String number;

    @Column(name = "whats_app")
    private boolean isWhatsApp;

    public Phone(PhoneRequestDTO dto) {
        this.id = dto.id();
        this.ddi = dto.ddi();
        this.ddd = dto.ddd();
        this.number = dto.number();
        this.isWhatsApp = dto.isWhatsApp();
    }
}
