package mykytka235.ms.scriptrunner.exception;

public class InnerServiceException extends BaseException {

    public InnerServiceException(String message) {
        super(ExceptionCode.INTERNAL_SERVICE_EXCEPTION, message);
    }

}
