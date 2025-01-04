package br.com.isissouzaguimaraes.desafio_bbb.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import br.com.isissouzaguimaraes.desafio_bbb.dto.VotoRequest;

@RequiredArgsConstructor
@Service
public class VotoService {
    private final RabbitTemplate rabbitTemplate;

    public void processaVoto(VotoRequest request) {
        rabbitTemplate.convertAndSend("computar-voto.ex", "", request);
    }
}
