package br.com.treino.exemplo01.controle;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treino.exemplo01.modelo.Colaborador;
import br.com.treino.exemplo01.repositorio.ColaboradorRepositorio;


@RestController
@RequestMapping("/colaboradores")
public class ColaboradorControle {
    
    @Autowired
    private ColaboradorRepositorio colaborador_respositorio;

    @GetMapping("/")
    public ResponseEntity<List<Colaborador>>listar(){
        List<Colaborador>lista =(List<Colaborador>)colaborador_respositorio.findAll();
        return ResponseEntity.status(200).body(lista);
    }

    

    @GetMapping("/{id}")
    public Optional<Colaborador> listarId(@PathVariable Long id ){

        return colaborador_respositorio.findById(id);
    }
    

    @PostMapping("/")
    public  ResponseEntity<Colaborador>cadastrar(@RequestBody Colaborador colaborador){
       Colaborador colaboradorNovo = colaborador_respositorio.save(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorNovo);
    
    }


  @DeleteMapping("/")
    public void delete(@RequestBody Colaborador colaborador){
     colaborador_respositorio.delete(colaborador);
    
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteId(@PathVariable Long id){
        colaborador_respositorio.deleteById(id);
        return ResponseEntity.status(204).build();
        
    }

    @PutMapping("/")
    public ResponseEntity<Colaborador> update(@RequestBody Colaborador  obj ){
    Colaborador colaboradorNovo = colaborador_respositorio.save(obj); 
    return ResponseEntity.status(HttpStatus.OK).body(colaboradorNovo);

    }

    }



    

    

