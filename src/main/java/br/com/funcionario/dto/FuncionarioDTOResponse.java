package br.com.funcionario.dto;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioDTOResponse {

    private Long id;
    private String racf;
    private String nome;
    private String cargo;
    private BigDecimal salario;

    @ManyToOne(targetEntity = SquadDTOResponse.class)
    private SquadDTOResponse squad;

    private String chefe;
    private LocalDate dataContratacao;
    private LocalDate dataCriacao;

    public FuncionarioDTOResponse(Long id, String racf, String nome, String cargo, BigDecimal salario, SquadDTOResponse squad, String chefe, LocalDate dataContratacao, LocalDate dataCriacao) {
        this.id = id;
        this.racf = racf;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.squad = squad;
        this.chefe = chefe;
        this.dataContratacao = dataContratacao;
        this.dataCriacao = dataCriacao;
    }
}
