package com.example.demo.service;

import com.example.demo.model.Pessoa;
import com.example.demo.model.Trabalho;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Trabalho salvarTrabalho(Long pessoaId, Trabalho trabalho) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        trabalho.setPessoa(pessoa);
        return trabalhoRepository.save(trabalho);
    }

    public List<Trabalho> findAll() {
        return trabalhoRepository.findAll();
    }

    public Trabalho findById(Long id) {
        return trabalhoRepository.findById(id).orElse(null);
    }

    public Trabalho save(Trabalho trabalho) {
        return trabalhoRepository.save(trabalho);
    }

    public void deleteById(Long id) {
        trabalhoRepository.deleteById(id);
    }
}