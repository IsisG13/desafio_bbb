package br.com.isissouzaguimaraes.desafio_bbb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.isissouzaguimaraes.desafio_bbb.entity.Candidato;
import br.com.isissouzaguimaraes.desafio_bbb.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CandidatoService {
    private final CandidatoRepository candidatoRepository;

    public List<Candidato> listarCandidatos() {
        return (List<Candidato>) candidatoRepository.findAll();
    }
}
