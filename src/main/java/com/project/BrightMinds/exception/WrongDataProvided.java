package com.project.BrightMinds.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public
class WrongDataProvided extends Exception{

    public
    WrongDataProvided(String msg) {
        super(msg);
    }
}
