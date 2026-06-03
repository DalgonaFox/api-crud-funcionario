package br.com.funcionario.repository;

import br.com.funcionario.entity.Squads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadRepository extends
        JpaRepository<Squads, Long> {
            Squads findSquadById(Long squadId);
        }
