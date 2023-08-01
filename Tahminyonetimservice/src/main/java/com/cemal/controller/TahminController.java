package com.cemal.controller;

import com.cemal.dto.request.SehirSaveRequestDto;
import com.cemal.dto.request.Tahmin;
import com.cemal.repository.entity.Sehir;
import com.cemal.service.TahminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cemal.constants.EndPoints.*;

@RestController
@RequestMapping("/tahmin")
@RequiredArgsConstructor
public class TahminController {
    private final TahminService tahminServiceService;

    @GetMapping("/ipucu")
    public ResponseEntity<String> ipucuver(){
        return tahminServiceService.random();



    }
    @PostMapping("/tahmin")
    public ResponseEntity<String> tahmin(String tahmin){
        return tahminServiceService.tahminoyunu(tahmin);
    }

    @GetMapping("/yenioyun")
    public ResponseEntity<String> yenioyun(String tokken){
        return tahminServiceService.oyunubasltamak(tokken);



    }





}
