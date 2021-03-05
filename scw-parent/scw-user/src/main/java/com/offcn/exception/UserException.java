package com.offcn.exception;

import com.offcn.enums.UserExceptionEnum;

public class UserException extends RuntimeException{
    public UserException(UserExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg()
        );
    }
}
