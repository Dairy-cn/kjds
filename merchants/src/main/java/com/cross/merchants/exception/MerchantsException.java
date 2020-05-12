package com.cross.merchants.exception;


import com.cross.merchants.handler.GlobalException;

public class MerchantsException extends GlobalException {

    public MerchantsException(int returnCode, String returnMessage) {
        super(returnCode, returnMessage);
    }

}
