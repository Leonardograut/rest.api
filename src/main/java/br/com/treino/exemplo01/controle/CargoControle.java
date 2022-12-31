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

import br.com.treino.exemplo01.modelo.Cargo;
import br.com.treino.exemplo01.repositorio.CargoRepositorio;

@RestController
@RequestMapping("/cargos")
public class CargoControle {
    
  
    @Autowired
    private CargoRepositorio cargo_repositorio;


    

    @GetMapping("/")
    public ResponseEntity<List<Cargo>>listar(){
        List<Cargo>lista =(List<Cargo>)cargo_repositorio.findAll();
        return ResponseEntity.status(200).body(lista);
    }


    @PostMapping("/")
    public  ResponseEntity<Cargo>cadastrar(@RequestBody Cargo cargo){
       Cargo cargoNovo = cargo_repositorio.save(cargo);
       
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoNovo);
    
    }

        
  
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteId(@PathVariable Long id){
        cargo_repositorio.deleteById(id);
        return ResponseEntity.status(204).build();
        
    }



    @DeleteMapping("/")
    public void delete(@RequestBody Cargo cargo){
     cargo_repositorio.delete(cargo);
    
    }



   @GetMapping("/{id}")
   public Optional<Cargo> listarId(@PathVariable Long id ){

       return cargo_repositorio.findById(id);
   }
   

  
   @PutMapping("/")
   public ResponseEntity<Cargo> update(@RequestBody Cargo  obj ){
   Cargo cargoNovo = cargo_repositorio.save(obj); 
   return ResponseEntity.status(HttpStatus.OK).body(cargoNovo);

   }

  }


  




    

