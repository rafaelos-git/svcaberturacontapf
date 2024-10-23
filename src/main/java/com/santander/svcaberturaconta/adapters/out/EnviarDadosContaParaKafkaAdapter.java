package com.santander.svcaberturaconta.adapters.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.santander.svcaberturaconta.application.core.domain.Conta;
import com.santander.svcaberturaconta.application.ports.out.EnviarDadosContaParaKafkaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EnviarDadosContaParaKafkaAdapter implements EnviarDadosContaParaKafkaOutputPort {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void enviar(Conta conta) {
        try {
            String contaJson = objectMapper.writeValueAsString(conta);
            kafkaTemplate.send("tp-abertura-conta-out", contaJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
