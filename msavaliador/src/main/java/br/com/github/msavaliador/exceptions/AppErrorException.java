package br.com.github.msavaliador.exceptions;

import lombok.Getter;

public class AppErrorException extends Exception{
    
    @Getter
    private Integer status;

    public AppErrorException(String msg, Integer status) {
        super(msg);
        this.status = status;
    }
}
