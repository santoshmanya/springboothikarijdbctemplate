package com.frazedprogramming.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Santosh on 1/20/2017.
 */
public class ExceptionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionUtil.class);

    public static ResponseEntity getNumberFormatExceptionResponseEntity(HttpServletRequest request, NumberFormatException e1) {
        LOGGER.error("ZipCodeController.addAreaCodes()|3.1|Error casting String to Integer.", e1);

        MultiValueMap errorMap = new LinkedMultiValueMap();
        errorMap.put("status", HttpStatus.BAD_REQUEST);
        errorMap.put("code", 4000);
        errorMap.put("message", e1.getMessage());
        errorMap.put("link", request.getRequestURL());
        errorMap.put("developerMessage", "Error casting String to Integer");
        return new ResponseEntity<Boolean>(false, errorMap, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity getInternalErrorResponseEntity(HttpServletRequest request, Exception Ex) {
        LOGGER.error("ZipCodeController.addAreaCodes()|3.1|Internal error.", Ex.getMessage());

        MultiValueMap errorMap = new LinkedMultiValueMap();
        errorMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        errorMap.put("code", 5000);
        errorMap.put("message", Ex.getMessage());
        errorMap.put("link", request.getRequestURL());
        errorMap.put("developerMessage", "Error while performing operation");
        return new ResponseEntity<Boolean>(false, errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
