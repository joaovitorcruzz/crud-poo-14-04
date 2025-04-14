package com.example.demo.controller;

import com.example.demo.model.Trabalho;
import com.example.demo.service.TrabalhoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping
    public List<Trabalho> getAllTrabalhos() {
        return trabalhoService.findAll();
    }

    @PostMapping
    public Trabalho createPessoa(@RequestBody Trabalho trabalho) {
        return trabalhoService.save(trabalho);
    }

    @PostMapping("/pessoa/{pessoaId}")
    public ResponseEntity<Trabalho> criarTrabalho(@PathVariable Long pessoaId,
                                                  @RequestBody Trabalho trabalho) {
        Trabalho novoTrabalho = trabalhoService.salvarTrabalho(pessoaId, trabalho);
        return new ResponseEntity<>(novoTrabalho, HttpStatus.CREATED);
    }
}