package com.dt2.gtavi.controller;

import com.dt2.gtavi.entities.Arma;
import com.dt2.gtavi.repositories.ArmaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/armas")
public class ArmaController {
    private final ArmaRepository repository;
    public ArmaController(ArmaRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Arma> mostrar(){
        return repository.findAll();
    }

    @PostMapping
    public String criarArma(@RequestBody Arma arm){
        try {
            repository.save(arm);
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
    public void atualizar (@PathVariable int id, @RequestBody Arma a){
        Arma arma = repository.getReferenceById(id);
        arma.setNome(a.getNome());
        arma.setFabricante(a.getFabricante());
        arma.setCategoria(a.getCategoria());
        arma.setDescricao(a.getDescricao());
        arma.setImagem(a.getImagem());
        repository.save(arma);
    }

}

