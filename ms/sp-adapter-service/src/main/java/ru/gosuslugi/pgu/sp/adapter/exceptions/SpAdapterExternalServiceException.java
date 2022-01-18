package ru.gosuslugi.pgu.sp.adapter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.gosuslugi.pgu.common.core.exception.PguException;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class SpAdapterExternalServiceException extends PguException {

    public SpAdapterExternalServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
