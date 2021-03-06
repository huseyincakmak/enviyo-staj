package com.enviyo.staj.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<ExceptionResponseDto> badRequest(BadRequestException ex) {

        return new ResponseEntity<ExceptionResponseDto>(toExceptionResponseDto(ex,"400_BAD_REQUEST" ), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotAcceptableException.class)
    ResponseEntity<ExceptionResponseDto> badRequest(NotAcceptableException ex) {

        return new ResponseEntity<ExceptionResponseDto>(toExceptionResponseDto(ex,"406_NOT_ACCEPTABLE" ), HttpStatus.NOT_ACCEPTABLE);
    }

    private ExceptionResponseDto toExceptionResponseDto(Exception ex, String code) {
        final ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto();
        exceptionResponseDto.setErrorCode(code);
        exceptionResponseDto.setErrorMessage(ex.getMessage());
        exceptionResponseDto.setTimeStamp(LocalDateTime.now());

        return exceptionResponseDto;
    }

}
