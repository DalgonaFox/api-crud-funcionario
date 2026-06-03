package br.com.funcionario.mapper;

import br.com.funcionario.dto.SquadDTORequest;
import br.com.funcionario.dto.SquadDTOResponse;
import br.com.funcionario.entity.Squads;
import org.mapstruct.Mapper;

@Mapper
public interface SquadMapperTest {

    Squads squadDTORequestParaSquads(SquadDTORequest squadDTORequest);

    Squads squadDTOResponseParaSquads(SquadDTOResponse squadDTOResponse);

    SquadDTOResponse squadsParaSquadDTOResponse(Squads squads);

    SquadDTORequest squadsParaSquadDTORequest(Squads squads);
}
