package br.com.isissouzaguimaraes.desafio_bbb.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.isissouzaguimaraes.desafio_bbb.dto.VotoRequest;
import br.com.isissouzaguimaraes.desafio_bbb.service.VotoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ComputaVotoListener {
    private final VotoService votoService;

    @RabbitListener(queues = "computar-voto.queue")
    public void processMessage(VotoRequest request) {
        votoService.salvar(request);
    }
}