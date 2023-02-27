package br.com.betApi.domain.model.person;

import br.com.betApi.domain.enums.GenderType;
import br.com.betApi.domain.model.user.aggregates.phone.Phone;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "tax_id")
    private String taxId;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderType gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToOne
    @JoinColumn(name = "phone_id")
    private Phone phone;

}
