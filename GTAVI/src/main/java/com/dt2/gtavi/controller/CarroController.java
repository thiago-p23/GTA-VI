package com.dt2.gtavi.controller;

import com.dt2.gtavi.entities.Carro;
import com.dt2.gtavi.repositories.CarroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class CarroController {
    private final CarroRepository repository;
    public CarroController(CarroRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Carro> mostrar(){
        return repository.findAll();
    }

    @PostMapping
    public String criarCarro(@RequestBody Carro car){
        try {
            repository.save(car);
            return "Salvo com sucesso";
        }
        catch (Exception e){
            return "Dados incorretos";
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id){
        try {
            repository.deleteById(id);
            return "excluido com sucesso!";
        }
        catch (Exception e){
            return "Não foi possivel exluir!";
        }
    }

    @GetMapping("/{id}")
    public void buscarid(@PathVariable int id){
        repository.findById(id);
    }

    @PutMapping("/{id}")
    public void atualizar (@PathVariable int id, @RequestBody Carro c){
        Carro carro = repository.getReferenceById(id);
        carro.setNome(c.getNome());
        carro.setMarca(c.getMarca());
        carro.setCategoria(c.getCategoria());
        carro.setDescricao(c.getDescricao());
        carro.setImagem(c.getImagem());
        repository.save(carro);
    }

}
