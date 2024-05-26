package com.pmgt.krish.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultData<T> {
    private int status;
    private String message;
    private String prop;
    private T data;

    public ResultData(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public ResultData(){

    }

}

