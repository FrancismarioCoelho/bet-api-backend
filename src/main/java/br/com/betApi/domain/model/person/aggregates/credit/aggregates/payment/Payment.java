package br.com.betApi.domain.model.person.aggregates.credit.aggregates.payment;

import br.com.betApi.domain.vo.enums.StatusPayment;
import br.com.betApi.domain.vo.enums.TypePayment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private Double value;

    @Column(name = "created")
    private LocalDateTime created;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypePayment type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPayment status;
}
