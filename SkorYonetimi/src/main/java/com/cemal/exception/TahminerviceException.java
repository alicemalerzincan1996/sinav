package com.cemal.exception;

import lombok.Getter;

@Getter
public class TahminerviceException extends RuntimeException{
    private final EerrorType type;

    public TahminerviceException(EerrorType type){
        super(type.getMesaj());
        this.type=type;
    }
    public TahminerviceException(EerrorType type, String mesaj){
        super(mesaj);
        this.type=type;
    }

}
