package com.dt2.gtavi.controller;

import com.dt2.gtavi.entities.Missoes;
import com.dt2.gtavi.repositories.MissoesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missoes")
public class MissoesController {
    private final MissoesRepository repository;
    public MissoesController(MissoesRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Missoes> mostrar(){
        return repository.findAll();
    }

    @PostMapping
    public String criarMissoes(@RequestBody Missoes mis){
        try {
            repository.save(mis);
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
    public void atualizar (@PathVariable int id, @RequestBody Missoes m){
        Missoes missoes = repository.getReferenceById(id);
        missoes.setNome(m.getNome());
        missoes.setLocal(m.getLocal());
        missoes.setDifculdade(m.getDifculdade());
        missoes.setDescricao(m.getDescricao());
        missoes.setImagem(m.getImagem());
        repository.save(missoes);
    }

}
