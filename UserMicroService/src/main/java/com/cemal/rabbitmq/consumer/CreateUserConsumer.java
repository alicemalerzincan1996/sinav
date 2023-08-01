package com.cemal.rabbitmq.consumer;

import com.cemal.rabbitmq.model.SaveAuthModel;
import com.cemal.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserConsumer {
    private final UserProfileService userProfileService;


}
