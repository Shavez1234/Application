package com.TicketBooking.Application.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.print.attribute.standard.Destination;
import javax.xml.transform.Source;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ResponseModel> handleIncosistentEditException(MethodArgumentNotValidException ex, WebRequest request){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(objectError -> {
            String em = objectError.getDefaultMessage();
            errors.put("message", em);
        });
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(HttpStatus.BAD_REQUEST.value());
        responseModel.setMessage(errors.get("message"));
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NameNotValidException.class)
    ResponseEntity<ResponseModel> handleInconsistentEditException(NameNotValidException e) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(HttpStatus.BAD_REQUEST.value());
        responseModel.setMessage(e.getMessage());
        responseModel.setData(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidDateException.class)
    ResponseEntity<ResponseModel> handleInconsistentEditException(InvalidDateException e) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(HttpStatus.BAD_REQUEST.value());
        responseModel.setMessage(e.getMessage());
        responseModel.setData(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SourceNotValidException.class)
    ResponseEntity<ResponseModel> handleInconsistentEditException(SourceNotValidException e) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(HttpStatus.BAD_REQUEST.value());
        responseModel.setMessage(e.getMessage());
        responseModel.setData(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DestinationNotValidException.class)
    ResponseEntity<ResponseModel> handleInconsistentEditException(DestinationNotValidException e) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(HttpStatus.BAD_REQUEST.value());
        responseModel.setMessage(e.getMessage());
        responseModel.setData(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }
}
