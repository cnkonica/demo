package com.cnkonica.demo.example.common.exception;

public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private final String code;
    private final String message;

    public ServiceException(final String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(final ResultCode bizResultCode) {
        if (bizResultCode == null) {
            this.code = "";
            this.message = "";
        } else {
            this.code = bizResultCode.getCode();
            this.message = bizResultCode.getMessage();
        }

    }

    public ServiceException(final String code, final String message, final Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return "ServiceException{code='" + this.code + '\'' + ", message='" + this.message + '\'' + '}';
    }
}
