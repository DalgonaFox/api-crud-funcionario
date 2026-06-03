package br.com.funcionario.repository;

import br.com.funcionario.entity.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends
        JpaRepository<Funcionarios, Long> {
            List<Funcionarios> findBySquadId(Long squadId);
        }
