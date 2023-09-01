package com.example.Mobiles.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MobileNotFound extends Exception{

    public MobileNotFound(String msg){
        super(msg);
    }

}
