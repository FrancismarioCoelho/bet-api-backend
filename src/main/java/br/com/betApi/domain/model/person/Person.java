package br.com.betApi.domain.model.person;

import br.com.betApi.application.core.person.dto.request.PersonRequestDTO;
import br.com.betApi.domain.model.person.aggregates.credit.Credit;
import br.com.betApi.domain.model.person.aggregates.phone.Phone;
import br.com.betApi.domain.vo.enums.GenderType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tb_person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "tax_id")
    private String taxId;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderType gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_id")
    private Credit credit;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private List<Phone> phones;

    public Person(PersonRequestDTO dto) {
        this.id = dto.id();
        this.email = dto.email();
        this.name = dto.name();
        this.nickName = dto.nickName();
        this.taxId = dto.taxId();
        this.gender = GenderType.valueOf(dto.gender());
        this.birthDate = dto.birthDate();
        this.phones =  dto.phones().stream().map(Phone::new).collect(Collectors.toList());
    }
}
