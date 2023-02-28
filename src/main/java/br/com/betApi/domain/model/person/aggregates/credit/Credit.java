package br.com.betApi.domain.model.person.aggregates.credit;

import br.com.betApi.domain.model.person.aggregates.credit.aggregates.Payment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tb_credit")
public class Credit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "payment_id")
    private List<Payment> payments;

}
