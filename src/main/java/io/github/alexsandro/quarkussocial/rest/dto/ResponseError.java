package io.github.alexsandro.quarkussocial.rest.dto;

import jakarta.validation.ConstraintViolation;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ResponseError {

    private String message;
    private Collection<FieldError> errors;

    public ResponseError(String message, Collection<FieldError> errors) {
        this.message = message;
        this.errors = errors;
    }

    public static <T> ResponseError createFromValidation(Set<ConstraintViolation<T>> violations) {

        violations.stream().map(cv -> new FieldError(cv.getPropertyPath().toString(), cv.getMessage()))
                .collect(Collectors.toList());

        String message = "Erro de Validação";
        return new ResponseError(message, errors);

    }

    public String getMessage() {
        return message;
    }

    public Collection<FieldError> getErrors() {
        return errors;
    }
}
