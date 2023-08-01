package com.cemal.manager;

import com.cemal.repository.entity.Sehir;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.cemal.constants.EndPoints.GETALL;

@FeignClient(name = "sehir2-service-manager",url = "http://localhost:9094/sehir", decode404 = true)
public interface ISehirManager {
    @GetMapping(GETALL)
    public ResponseEntity<List<Sehir>> findAll();
}
