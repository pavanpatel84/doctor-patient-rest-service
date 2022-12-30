package com.doctorpatient.exception.handler;

import com.doctorpatient.exception.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.MethodParameter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ExtendWith(MockitoExtension.class)
class RestExceptionHandlerTest {

    @InjectMocks
    private RestExceptionHandler restExceptionHandler;

    @Test
    void handleEntityNotFound() {
        ResponseEntity<Object> response = restExceptionHandler.handleEntityNotFound
                (new EntityNotFoundException(RestExceptionHandlerTest.class, "key", "value"));
        Assertions.assertEquals(404, response.getStatusCode().value());
    }

    @Test
    void handleMissingServletRequestParameter() {
        ResponseEntity<Object> response = restExceptionHandler.handleMissingServletRequestParameter
                (new MissingServletRequestParameterException("Method", "URL", true), null, null, null);
        Assertions.assertEquals(400, response.getStatusCode().value());
    }

    @Test
    void testHandleEntityNotFound() {
        ResponseEntity<Object> response = restExceptionHandler.handleEntityNotFound
                (new javax.persistence.EntityNotFoundException());
        Assertions.assertEquals(404, response.getStatusCode().value());
    }

    @Test
    void testHandleHttpMessageNotReadable() {
        ResponseEntity<Object> response = restExceptionHandler.handleHttpMessageNotReadable
                (new HttpMessageNotReadableException("HttpMessageNotReadable Exception"), null, null, null);
        Assertions.assertEquals(400, response.getStatusCode().value());
    }

    @Test
    void testHandleHttpMessageNotWritable() {
        ResponseEntity<Object> response = restExceptionHandler.handleHttpMessageNotWritable
                (new HttpMessageNotWritableException("HttpMessageNotWritable Exception"), null, null, null);
        Assertions.assertEquals(500, response.getStatusCode().value());
    }

    @Test
    void testHandleDataIntegrityViolation() {
        ResponseEntity<Object> response = restExceptionHandler.handleDataIntegrityViolation
                (new DataIntegrityViolationException("DataIntegrityViolation Exception"), null);
        Assertions.assertEquals(500, response.getStatusCode().value());
    }

    @Test
    void testHandleMethodArgumentTypeMismatch() {
        ResponseEntity<Object> response = restExceptionHandler.handleMethodArgumentTypeMismatch
                (new MethodArgumentTypeMismatchException(null, null, "MethodArgumentTypeMismatch Exception", null, null), null);
        Assertions.assertEquals(400, response.getStatusCode().value());
    }

}
