package br.com.isissouzaguimaraes.desafio_bbb.service;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import br.com.isissouzaguimaraes.desafio_bbb.dto.VotoRequest;
import br.com.isissouzaguimaraes.desafio_bbb.entity.Candidato;
import br.com.isissouzaguimaraes.desafio_bbb.entity.Voto;
import br.com.isissouzaguimaraes.desafio_bbb.repository.VotoRepository;

@RequiredArgsConstructor
@Service
public class VotoService {
    private final RabbitTemplate rabbitTemplate;
    private final VotoRepository repository;

    // public void processaVoto(VotoRequest request) {
    // rabbitTemplate.convertAndSend("computar-voto.ex", "", request);
    // }

    public void processaVoto(VotoRequest request) {
        try {
            rabbitTemplate.convertAndSend("computar-voto.ex", "", request);
            System.out.println("Mensagem enviada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao enviar mensagem para o RabbitMQ: " + e.getMessage());
        }
    }

    public void salvar(VotoRequest request) {
        Voto voto = new Voto();
        voto.setCandidato(new Candidato(request.getIdCandidato()));
        voto.setDataHora(LocalDateTime.now());

        repository.save(voto);
    }
}
