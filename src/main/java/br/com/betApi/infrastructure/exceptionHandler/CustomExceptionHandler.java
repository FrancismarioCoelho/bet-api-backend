package br.com.betApi.infrastructure.exceptionHandler;

import br.com.betApi.domain.vo.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class CustomExceptionHandler {


    @ExceptionHandler(Exception.class)
    public Mono<Object> handleException(Exception ex, BindingResult bindingResult) {
        return Mono.error(ex)
                .onErrorResume(error -> {
                    String errorMessage = getErrorMessage(error, bindingResult);
                    ErrorDetails errorDetails = new ErrorDetails("Internal Server Error", errorMessage);
                    return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails));
                });
    }

    private String getErrorMessage(Throwable ex, BindingResult bindingResult) {
        if (!bindingResult.getFieldErrors().isEmpty()) {
            return bindingResult.getFieldErrors().get(0).getDefaultMessage();
        }
        return ex.getMessage();
    }



}
