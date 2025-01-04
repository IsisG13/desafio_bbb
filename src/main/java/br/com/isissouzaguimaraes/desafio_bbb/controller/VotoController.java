package br.com.isissouzaguimaraes.desafio_bbb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.isissouzaguimaraes.desafio_bbb.dto.VotoRequest;
import br.com.isissouzaguimaraes.desafio_bbb.service.VotoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/voto")
public class VotoController {

    private final VotoService votoService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void processaVoto(@RequestBody VotoRequest request) {
        votoService.processaVoto(request);
    }
}
