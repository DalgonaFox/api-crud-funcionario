package br.com.funcionario.mapper;

import br.com.funcionario.dto.FuncionarioDTORequest;
import br.com.funcionario.dto.FuncionarioDTOResponse;
import br.com.funcionario.entity.Funcionarios;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    Funcionarios funcionarioDTOParaFuncionarios(FuncionarioDTORequest funcionarioDTORequest);

    FuncionarioDTOResponse funcionariosParaFuncionarioDTO(Funcionarios funcionarios);

    @Named("mapearDataCriacao")
    default LocalDate mapearDataCriacao(FuncionarioDTORequest funcionarioDTORequest) {
        return LocalDate.now();
    }

    @BeforeMapping
    default void gerarDataCriacao(FuncionarioDTORequest funcionarioDTORequest) {
        if (funcionarioDTORequest != null) funcionarioDTORequest.setDataCriacao(LocalDate.now());
    }
}
