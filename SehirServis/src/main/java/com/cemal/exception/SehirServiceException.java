package com.cemal.exception;

import lombok.Getter;

@Getter
public class SehirServiceException extends RuntimeException{
    private final EerrorType type;

    public SehirServiceException(EerrorType type){
        super(type.getMesaj());
        this.type=type;
    }
    public SehirServiceException(EerrorType type, String mesaj){
        super(mesaj);
        this.type=type;
    }

}
