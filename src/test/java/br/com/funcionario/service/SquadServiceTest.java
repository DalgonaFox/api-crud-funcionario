package br.com.funcionario.service;

import br.com.funcionario.dto.SquadDTORequest;
import br.com.funcionario.dto.SquadDTOResponse;
import br.com.funcionario.entity.Squads;
import br.com.funcionario.exception.SquadNaoEncontradaException;
import br.com.funcionario.mapper.SquadMapper;
import br.com.funcionario.repository.SquadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SquadServiceTest {

    private final SquadRepository squadRepository;
    private final SquadMapper squadMapper;

    public void inserirSquad(SquadDTORequest squadDTORequest) {
        Squads squad = squadMapper.squadDTORequestParaSquads(squadDTORequest);
        squadRepository.save(squad);
    }

    public List<SquadDTOResponse> buscarSquads() {
        Squads squad = new Squads();

        Example<Squads> squadsExample = Example.of(squad);
        return squadRepository.findAll(squadsExample).stream().map(squadMapper::squadsParaSquadDTOResponse).collect(Collectors.toList());
    }

    public SquadDTOResponse buscarSquadPorId(Long id) {
        Squads squad = squadRepository.findById(id).orElseThrow(SquadNaoEncontradaException::new);
        return new SquadDTOResponse(
                squad.getId(),
                squad.getRt(),
                squad.getNome(),
                squad.getProductManager(),
                squad.getProduto(),
                squad.getComunidade(),
                squad.getCoordenador(),
                squad.getDiretor(),
                squad.getTechLead()
        );
    }

    public void deletarSquad(Long id) {
        squadRepository.deleteById(id);
    }

    public SquadDTOResponse atualizarSquad(Long id, SquadDTORequest squadDTORequest) {
        Optional<Squads> squad = squadRepository.findById(id);
        if(squad.isPresent()) {
            var s = squad.get();
            if(squadDTORequest.getNome()!= null) s.setNome(squadDTORequest.getNome());
            if(squadDTORequest.getRt()!= null) s.setRt(squadDTORequest.getRt());
            if(squadDTORequest.getProductManager()!= null) s.setProductManager(squadDTORequest.getProductManager());
            if(squadDTORequest.getProduto()!= null) s.setProduto(squadDTORequest.getProduto());
            if(squadDTORequest.getComunidade()!= null) s.setComunidade(squadDTORequest.getComunidade());
            if(squadDTORequest.getCoordenador()!= null) s.setCoordenador(squadDTORequest.getCoordenador());
            if(squadDTORequest.getDiretor()!= null) s.setDiretor(squadDTORequest.getDiretor());
            if(squadDTORequest.getTechLead()!= null) s.setTechLead(squadDTORequest.getTechLead());

            return squadMapper.squadsParaSquadDTOResponse(squadRepository.save(s));
        } else {
            throw new SquadNaoEncontradaException();
        }
    }

}
