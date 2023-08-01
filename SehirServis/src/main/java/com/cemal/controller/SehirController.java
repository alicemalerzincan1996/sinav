package com.cemal.controller;

import com.cemal.dto.request.UserProfileLoginDto;
import com.cemal.dto.request.SehirSaveRequestDto;
import com.cemal.repository.entity.Sehir;
import com.cemal.service.SehirService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cemal.constants.EndPoints.*;

@RestController
@RequestMapping("/sehir")
@RequiredArgsConstructor
public class SehirController {
    private final SehirService userProfileService;

    @PostMapping(SAVE)
    public ResponseEntity<Sehir> save(@RequestBody SehirSaveRequestDto dto,String tokken){
       return ResponseEntity.ok(userProfileService.saveDto(dto,tokken));
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<Sehir>> findAll(){
        return ResponseEntity.ok(userProfileService.findAll());
    }





    @PutMapping(UPDATE)
    public ResponseEntity<Sehir> update(@RequestBody SehirSaveRequestDto dto, String tokken)
    {return ResponseEntity.ok(userProfileService.updateyap(tokken,dto));};




}
