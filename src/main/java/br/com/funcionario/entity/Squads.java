package br.com.funcionario.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Squad")
public class Squads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String techLead;
    @NotBlank
    private String productManager;
    @NotBlank
    private String produto;
    @NotBlank
    private String comunidade;
    @NotBlank
    private String rt;
    @NotBlank
    private String coordenador;
    @NotBlank
    private String diretor;
}
