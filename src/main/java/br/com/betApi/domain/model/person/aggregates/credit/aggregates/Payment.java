package br.com.betApi.domain.model.person.aggregates.credit.aggregates;

import br.com.betApi.domain.enums.StatusPayment;
import br.com.betApi.domain.enums.TypePayment;
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

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypePayment type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPayment status;
}
