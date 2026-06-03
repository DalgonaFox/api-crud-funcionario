package br.com.funcionario.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTORequest {

    @NotBlank
    @Length(min = 7, max = 7)
    @Column(unique = true)
    private String racf;

    @NotBlank
    private String nome;

    @NotBlank
    private String cargo;

    @NotNull
    @Min(1)
    private BigDecimal salario;

    private SquadDTOResponse squad;

    @NotBlank
    private String chefe;

    private LocalDate dataContratacao;
    private LocalDate dataCriacao;
}
