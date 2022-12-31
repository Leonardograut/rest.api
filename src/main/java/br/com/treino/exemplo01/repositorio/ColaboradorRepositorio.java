package br.com.treino.exemplo01.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.treino.exemplo01.modelo.Colaborador;


@Repository
public interface ColaboradorRepositorio extends JpaRepository<Colaborador,Long> {
      
    Colaborador findById(long id);
}
