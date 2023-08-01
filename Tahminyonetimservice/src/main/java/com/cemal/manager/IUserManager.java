package com.cemal.manager;

import com.cemal.rabbitmq.model.Usermodel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service-manager",url = "http://localhost:9093/user", decode404 = true)
public interface IUserManager {
    @GetMapping("/findbyidmodel")
    public ResponseEntity<Usermodel> usermodel(Long id);

    @GetMapping("/updatefetch")
    public void update(@RequestBody Usermodel usermodel);

}
