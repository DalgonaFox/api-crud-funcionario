package br.com.funcionario.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SquadDTOResponse {

    private Long id;
    private String nome;
    private String techLead;
    private String productManager;
    private String produto;
    private String comunidade;
    private String rt;
    private String coordenador;
    private String diretor;
}
