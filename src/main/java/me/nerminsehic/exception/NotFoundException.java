package me.nerminsehic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(Class<?> entity, Object identifier) {
        super("A %s could not be found using the following identifier: %s".formatted(entity.getName(), identifier));
    }

    public NotFoundException(String message) {
        super(message);
    }
}
