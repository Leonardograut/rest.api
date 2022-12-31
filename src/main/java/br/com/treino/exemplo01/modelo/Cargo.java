package br.com.treino.exemplo01.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Setter;

import lombok.Getter;

@Entity
@Table(name="cargos")
@Getter
@Setter
public class Cargo {
    
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long codigo;


    private String cargo;
    private double salario;
  

}
