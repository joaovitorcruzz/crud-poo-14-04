package com.example.demo.service;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa insertPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> selectAllPessoa(){
        return pessoaRepository.findAll();
    }

    public Pessoa selectPessoaById(int id){
        Optional<Pessoa> oc = pessoaRepository.findById(id);
        if(oc.isPresent()){
            return oc.get();
        }else{
            throw new RuntimeException("Pessoa nao encotrada.");
        }
    }


    public Pessoa aprovarPessoa(int id){
        Pessoa ps = selectPessoaById(id);
        ps.setWorking("Contratado");
        return pessoaRepository.<Pessoa>save(ps);
    }

    public void deletarPessoa(int id){
        pessoaRepository.deleteById(id);
    }
}