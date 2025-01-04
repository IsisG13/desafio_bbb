package br.com.isissouzaguimaraes.desafio_bbb.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.isissouzaguimaraes.desafio_bbb.entity.Candidato;
import br.com.isissouzaguimaraes.desafio_bbb.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/candidato")
public class CandidatoController {
    private final CandidatoRepository candidatoRepository;

    // @GetMapping
    // @ResponseStatus(HttpStatus.OK)
    // public List<Candidato> listarCandidatos() {
    // return candidatoService.listarCandidatos();
    // }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Candidato> listarCandidatos() {
        List<Candidato> candidatos = (List<Candidato>) candidatoRepository.findAll();
        System.out.println("Candidatos retornados: " + candidatos);
        return candidatos;
    }
}