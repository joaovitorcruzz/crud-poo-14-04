package com.example.demo.controller;


import com.example.demo.model.Pessoa;
import com.example.demo.service.PessoaService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.insertPessoa(pessoa);
    }

    @GetMapping
    public List<Pessoa> listarPessoa(){
        return pessoaService.selectAllPessoa();
    }

    @PutMapping("/{id}/aprovar")
    public Pessoa aprovarPessoa(@PathVariable int id){
        return pessoaService.aprovarPessoa(id);
    }

    @GetMapping("/{id}")
    public Pessoa buscarById(@PathVariable int id){
        return pessoaService.selectPessoaById(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        pessoaService.deletarPessoa(id);
    }
}