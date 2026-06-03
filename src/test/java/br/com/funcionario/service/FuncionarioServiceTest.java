package br.com.funcionario.service;

import br.com.funcionario.dto.FuncionarioDTORequest;
import br.com.funcionario.dto.FuncionarioDTOResponse;
import br.com.funcionario.entity.Funcionarios;
import br.com.funcionario.entity.Squads;
import br.com.funcionario.exception.FuncionarioNaoEncontradoException;
import br.com.funcionario.exception.RacfDuplicadaException;
import br.com.funcionario.exception.SquadNaoEncontradaException;
import br.com.funcionario.mapper.FuncionarioMapper;
import br.com.funcionario.mapper.SquadMapper;
import br.com.funcionario.repository.FuncionarioRepository;
import br.com.funcionario.repository.SquadRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceTest {

    private final FuncionarioRepository funcionarioRepository;
    private final SquadRepository squadRepository;
    private final FuncionarioMapper funcionarioMapper;
    private final SquadMapper squadMapper;

    private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceTest.class);

    public void inserirFuncionario(FuncionarioDTORequest funcionarioDTO) {
        Funcionarios funcionario = funcionarioMapper.funcionarioDTOParaFuncionarios(funcionarioDTO);

        Long squadId = funcionarioDTO.getSquad().getId();

        Optional<Squads> squadsOptional = Optional.ofNullable(squadRepository.findSquadById(squadId));

        if(squadsOptional.isEmpty()) throw new SquadNaoEncontradaException();

        funcionario.setSquad(squadsOptional.get());

        try {
            funcionarioRepository.save(funcionario);
        } catch (Exception e) {
            throw new RacfDuplicadaException();
        }
    }

    public List<FuncionarioDTOResponse> buscarFuncionarios() {
        Funcionarios funcionario = new Funcionarios();
        funcionario.setDataCriacao(null);
        funcionario.setDataContratacao(null);

        Example<Funcionarios> funcionariosExample = Example.of(funcionario);
        return funcionarioRepository.findAll(funcionariosExample).stream().map(funcionarioMapper::funcionariosParaFuncionarioDTO).collect(Collectors.toList());
    }

    public FuncionarioDTOResponse buscarFuncionarioPorId(Long id) {
        Funcionarios funcionario = funcionarioRepository.findById(id).orElseThrow(FuncionarioNaoEncontradoException::new);
        return new FuncionarioDTOResponse(
                funcionario.getId(),
                funcionario.getRacf(),
                funcionario.getNome(),
                funcionario.getCargo(),
                funcionario.getSalario(),
                squadMapper.squadsParaSquadDTOResponse(funcionario.getSquad()),
                funcionario.getChefe(),
                funcionario.getDataContratacao(),
                funcionario.getDataCriacao()
        );
    }

    public List<Funcionarios> buscarFuncionariosPorSquad(Long squadId) {
        return funcionarioRepository.findBySquadId(squadId);
    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public FuncionarioDTOResponse atualizarFuncionario(Long id, FuncionarioDTORequest funcionarioDTORequest) {
        Optional<Funcionarios> funcionario = funcionarioRepository.findById(id);
        if(funcionario.isPresent()) {
            var f = funcionario.get();
            if(funcionarioDTORequest.getNome()!= null) f.setNome(funcionarioDTORequest.getNome());
            if(funcionarioDTORequest.getCargo()!= null) f.setCargo(funcionarioDTORequest.getCargo());
            if(funcionarioDTORequest.getRacf()!= null) f.setRacf(funcionarioDTORequest.getRacf());
            if(funcionarioDTORequest.getChefe()!= null) f.setChefe(funcionarioDTORequest.getChefe());
            if(funcionarioDTORequest.getSalario()!= null) f.setSalario(funcionarioDTORequest.getSalario());
            if(funcionarioDTORequest.getSquad()!= null) f.getSquad();
            if(funcionarioDTORequest.getDataContratacao()!= null) f.setDataContratacao(funcionarioDTORequest.getDataContratacao());

            return funcionarioMapper.funcionariosParaFuncionarioDTO(funcionarioRepository.save(f));
        } else {
            throw new FuncionarioNaoEncontradoException();
        }
    }
}
