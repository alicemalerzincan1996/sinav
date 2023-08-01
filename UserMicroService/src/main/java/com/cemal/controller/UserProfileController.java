package com.cemal.controller;

import com.cemal.dto.request.UserProfileLoginDto;
import com.cemal.dto.request.UserProfileSaveRequestDto;
import com.cemal.dto.request.UserProfileUpdate;
import com.cemal.model.Usermodel;
import com.cemal.repository.entity.UserProfile;
import com.cemal.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cemal.constants.EndPoints.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(SAVE)
    public ResponseEntity<UserProfile> save(@RequestBody UserProfileSaveRequestDto dto){
       return ResponseEntity.ok(userProfileService.saveDto(dto));
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<UserProfile>> findAll(){
        return ResponseEntity.ok(userProfileService.findAll());
    }


    @PutMapping(UPDATE)
    public ResponseEntity<UserProfile> update(@RequestBody UserProfileUpdate dto,String tokken)
    {return ResponseEntity.ok(userProfileService.updateyap(tokken,dto));};

    @PostMapping(LOGIN)
    public ResponseEntity<String> dologin(@RequestBody UserProfileLoginDto dto)
    { return ResponseEntity.ok(userProfileService.login(dto));};

    @GetMapping("/findbyidmodel")
    public ResponseEntity<Usermodel> usermodel(Long id)
    {return ResponseEntity.ok(userProfileService.findbyIdmodel(id));}

    @GetMapping("/updatefetch")
    public void update(@RequestBody Usermodel usermodel)
    {
        userProfileService.userupdait(usermodel);
    }


}
