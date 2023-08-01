package com.cemal.mapper;

import com.cemal.dto.request.UserProfileSaveRequestDto;
import com.cemal.model.Usermodel;
import com.cemal.rabbitmq.model.SaveAuthModel;
import com.cemal.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserProfileMapper {
    IUserProfileMapper INSTANCE= Mappers.getMapper(IUserProfileMapper.class);
    UserProfile toUserProfile(final UserProfileSaveRequestDto dto);
    UserProfile toUserProfile(final Usermodel model);
    Usermodel tomodel(final UserProfile userProfile);



}
