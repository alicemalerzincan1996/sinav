package com.cemal.rabbitmq.producer;


import com.cemal.rabbitmq.model.Usermodel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserProducer {

    private final RabbitTemplate rabbitTemplate;
    public void convertAndSend(Usermodel model){
        rabbitTemplate.convertAndSend("skor-get","skor-binding-key",model);
    }
}
