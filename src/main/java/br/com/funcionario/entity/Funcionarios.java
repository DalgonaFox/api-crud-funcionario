package br.com.funcionario.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Funcionario")
public class Funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 7, max = 7)
    @Column(nullable = false, unique = true)
    private String racf;

    @NotBlank
    private String nome;

    @NotBlank
    private String cargo;

    @NotNull
    @Min(1)
    private BigDecimal salario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_squad")
    private Squads squad;

    @NotBlank
    private String chefe;

    private LocalDate dataContratacao;
    private LocalDate dataCriacao;
}
