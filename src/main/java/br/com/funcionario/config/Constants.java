package br.com.funcionario.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final String MENSAGEM_FUNCIONARIO_NAO_ENCONTRADO = "Funcionário não encontrado.";
    public static final String MENSAGEM_RACF_DUPLICADA = "Racf não pode ser duplicada.";
    public static final String MENSAGEM_SQUAD_NAO_ENCONTRADA = "Squad não encontrada.";
}
