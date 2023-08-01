package com.cemal.service;

import com.cemal.dto.request.UserProfileLoginDto;
import com.cemal.dto.request.UserProfileSaveRequestDto;
import com.cemal.dto.request.UserProfileUpdate;
import com.cemal.exception.EerrorType;
import com.cemal.exception.UserProfileServiceException;

import com.cemal.mapper.IUserProfileMapper;
import com.cemal.model.Usermodel;
import com.cemal.repository.IUserProfileRepository;
import com.cemal.repository.entity.UserProfile;
import com.cemal.utility.JwtTokenManager;
import com.cemal.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,Long> implements Serializable {
   private final IUserProfileRepository userProfileRepository;

   private final JwtTokenManager jwtTokenManager;


    public UserProfileService(IUserProfileRepository userProfileRepository, JwtTokenManager jwtTokenManager){
        super(userProfileRepository);
        this.userProfileRepository=userProfileRepository;

        this.jwtTokenManager = jwtTokenManager;
    }

    public UserProfile saveDto(UserProfileSaveRequestDto dto) {
        UserProfile user=IUserProfileMapper.INSTANCE.toUserProfile(dto);
        save(user);
        return user;
    }

    public String login(UserProfileLoginDto dto){
        Optional<UserProfile> userProfile=userProfileRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (userProfile.isEmpty())throw new UserProfileServiceException(EerrorType.DOLOGIN_USERNAMEORPASSWORD_NOTEXISTS);
        else {
            return String.valueOf(jwtTokenManager.createToken(userProfile.get().getId(),userProfile.get().getType().toString()));

        }
    }

    public UserProfile updateyap(String tokken, UserProfileUpdate profileUpdate){
        if (!jwtTokenManager.verifyToken(tokken)) throw new UserProfileServiceException(EerrorType.INVALID_TOKEN);
        Optional<Long> id=jwtTokenManager.getIdFromToken(tokken);
        UserProfile userProfile= userProfileRepository.findById(id.get()).get();
        if (!profileUpdate.getEmail().equals("string")){
            userProfile.setEmail(profileUpdate.getEmail());
        };
        if (!profileUpdate.getTelefon().equals("string")){
            userProfile.setTelefon(profileUpdate.getTelefon());
        };
        if (!profileUpdate.getPassword().equals("string")){
            userProfile.setPassword(profileUpdate.getPassword());
        }
        return update(userProfile);

    }


    public Usermodel findbyIdmodel(Long id){
       return IUserProfileMapper.INSTANCE.tomodel(findById(id).get());

    }


    public void userupdait(Usermodel usermodel){
        UserProfile userProfile=findById(usermodel.getId()).get();
        userProfile.setOynanmasayisi(usermodel.getOynanmasayisi());
        userProfile.setMaxskor(usermodel.getMaxskor());
        update(userProfile);
    }




}
