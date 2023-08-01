package com.cemal.mapper;

import com.cemal.dto.request.SehirSaveRequestDto;
import com.cemal.repository.entity.Sehir;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISehirMapper {
    ISehirMapper INSTANCE= Mappers.getMapper(ISehirMapper.class);
    Sehir toUserProfile(final SehirSaveRequestDto dto);

}
