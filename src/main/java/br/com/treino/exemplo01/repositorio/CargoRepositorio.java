package br.com.treino.exemplo01.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.treino.exemplo01.modelo.Cargo;

@Repository
public interface CargoRepositorio extends JpaRepository<Cargo,Long> {
    
}
