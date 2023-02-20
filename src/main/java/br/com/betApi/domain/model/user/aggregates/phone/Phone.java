package br.com.betApi.domain.model.user.aggregates.phone;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
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
}
