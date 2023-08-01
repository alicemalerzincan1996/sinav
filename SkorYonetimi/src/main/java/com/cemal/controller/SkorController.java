package com.cemal.controller;


import com.cemal.repository.entity.Skor;
import com.cemal.service.SkorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skor")
@RequiredArgsConstructor
public class SkorController {
    private final SkorService skor;


    @GetMapping("/getall")
    public ResponseEntity<List<Skor>> ipucuver(){
        return ResponseEntity.ok(skor.findall());



    }
    @GetMapping("/getbyid")
    public ResponseEntity<Skor> tahmin(Long id){
        return ResponseEntity.ok(skor.findbyid(id));
    }

    @GetMapping("/sirala")
    public ResponseEntity<List<Skor>> sirala(){
        return ResponseEntity.ok(skor.sirala());



    }





}
