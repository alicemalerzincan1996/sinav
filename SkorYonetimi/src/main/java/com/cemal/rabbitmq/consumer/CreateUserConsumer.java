package com.cemal.rabbitmq.consumer;


import com.cemal.rabbitmq.model.Usermodel;
import com.cemal.repository.entity.Skor;
import com.cemal.service.SkorService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserConsumer {
    private final SkorService skorService;

    @RabbitListener(queues = "skor-get")
    public void createUserFromQueue(Usermodel model){
        Skor skor= Skor.builder().name(model.getUsername()).skor(model.getSkor()).build();
        /*userProfileService.save(UserProfile.builder()
                        .authid(model.getAuthid())
                        .username(model.getUsername())
                        .email(model.getEmail())
                .build());*/
    }
}
