package br.com.funcionario.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SquadDTORequest {

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
