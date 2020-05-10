package com.cross.uaa.exception;


import com.cross.uaa.handler.GlobalException;

public class UaaException extends GlobalException {

    public UaaException(int returnCode, String returnMessage) {
        super(returnCode, returnMessage);
    }

}
