package mykytka235.ms.scriptrunner.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    SOME_PARAMETERS_ABSENT_OR_INVALID_EXCEPTION(40001, "Some parameters are absent, or invalid.", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVICE_EXCEPTION(50001, "Issue with internal service", HttpStatus.INTERNAL_SERVER_ERROR),
    UNKNOWN_EXCEPTION(99999, "Unknown error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

}
