package com.cemal.service;

import com.cemal.dto.request.SehirSaveRequestDto;
import com.cemal.dto.request.UserProfileLoginDto;
import com.cemal.exception.EerrorType;
import com.cemal.exception.SehirServiceException;

import com.cemal.mapper.ISehirMapper;
import com.cemal.repository.ISehirRepository;
import com.cemal.repository.entity.Sehir;
import com.cemal.utility.JwtTokenManager;
import com.cemal.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Service
public class SehirService extends ServiceManager<Sehir,Long> implements Serializable {
   private final ISehirRepository userProfileRepository;

   private final JwtTokenManager jwtTokenManager;


    public SehirService(ISehirRepository userProfileRepository,  JwtTokenManager jwtTokenManager){
        super(userProfileRepository);
        this.userProfileRepository=userProfileRepository;

        this.jwtTokenManager = jwtTokenManager;
    }

    public Sehir saveDto(SehirSaveRequestDto dto,String tokken) {

        if (jwtTokenManager.gettypeFromToken(tokken).get().equals("Admin")){
        Sehir user= ISehirMapper.INSTANCE.toUserProfile(dto);
        save(user);
        return user;
    }else throw new SehirServiceException(EerrorType.INVALID_TOKEN2);
    }



    public Sehir updateyap(String tokken, SehirSaveRequestDto profileUpdate){
        if (!jwtTokenManager.verifyToken(tokken)) throw new SehirServiceException(EerrorType.INVALID_TOKEN);
        Optional<Long> id=jwtTokenManager.getIdFromToken(tokken);
        Sehir userProfile= userProfileRepository.findById(id.get()).get();
        if (!profileUpdate.getName().equals("string")){
            userProfile.setName(profileUpdate.getName());
        };
        if (!profileUpdate.getNufus().equals("string")){
            userProfile.setNufus(profileUpdate.getNufus());
        };
        if (!profileUpdate.getBolge().equals("string")){
            userProfile.setBolge(profileUpdate.getBolge());
        }

        return update(userProfile);

    }




}
