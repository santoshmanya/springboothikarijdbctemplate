package com.frazedprogramming.demo.web;

import com.frazedprogramming.demo.data.domain.AreaCode;
import com.frazedprogramming.demo.service.AreaCodeService;
import com.frazedprogramming.demo.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Santosh on 1/20/2017.
 */
@RestController
@RequestMapping("/areacode")
public class AreaCodeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AreaCodeController.class);

    @Autowired
    AreaCodeService areaCodeService;


    @RequestMapping(value = "/add/{areacode}/state/{statecode}/city/{city}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity save(@PathVariable(value = "areacode") String areaCode,
                               @PathVariable("statecode") String statecode,
                               @PathVariable("city") String city, HttpServletRequest request, HttpServletResponse response) {
        Integer areaCodeInt = null;
        try {
            areaCodeInt = new Integer(areaCode);
            boolean retVal = areaCodeService.save(new AreaCode(areaCodeInt, statecode, city));
            return new ResponseEntity<Boolean>(retVal, null, HttpStatus.CREATED);

        } catch (NumberFormatException e1) {
            return ExceptionUtil.getNumberFormatExceptionResponseEntity(request, e1);

        } catch (Exception e1) {

            return ExceptionUtil.getInternalErrorResponseEntity(request, e1);


        }


    }

    @RequestMapping(value = "/update/{areacode}/state/{statecode}/city/{city}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable(value = "areacode") String areaCode,
                                 @PathVariable("statecode") String statecode,
                                 @PathVariable("city") String city, HttpServletRequest request, HttpServletResponse response) {


        Integer areaCodeInt = null;
        try {
            areaCodeInt = new Integer(areaCode);
            boolean retVal = areaCodeService.update(new AreaCode(areaCodeInt, statecode, city));
            return new ResponseEntity<Boolean>(retVal, null, HttpStatus.CREATED);


        } catch (NumberFormatException e1) {
            return ExceptionUtil.getNumberFormatExceptionResponseEntity(request, e1);

        } catch (Exception e1) {

            return ExceptionUtil.getInternalErrorResponseEntity(request, e1);


        }

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable(value = "id") String strId, HttpServletRequest request) {

        Integer areaCodeInt = null;
        try {
            areaCodeInt = new Integer(strId);
            boolean retVal = areaCodeService.delete(areaCodeInt);
            return new ResponseEntity(retVal, null, HttpStatus.OK);


        } catch (NumberFormatException e1) {
            return ExceptionUtil.getNumberFormatExceptionResponseEntity(request, e1);

        } catch (Exception e1) {

            return ExceptionUtil.getInternalErrorResponseEntity(request, e1);

        }


    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAll(HttpServletRequest request) {
        try {
            List retVal = areaCodeService.findAll();
            return new ResponseEntity(retVal, null, HttpStatus.OK);
        } catch (NumberFormatException e1) {
            return ExceptionUtil.getNumberFormatExceptionResponseEntity(request, e1);

        } catch (Exception e1) {

            return ExceptionUtil.getInternalErrorResponseEntity(request, e1);

        }
    }


    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findOne(@PathVariable(value = "id") String strId, HttpServletRequest request) {
        try {
            Integer areaCodeInt = null;
            areaCodeInt = new Integer(strId);
            AreaCode retVal = areaCodeService.findOne(areaCodeInt);
            return new ResponseEntity(retVal, null, HttpStatus.OK);

        } catch (NumberFormatException e1) {
            return ExceptionUtil.getNumberFormatExceptionResponseEntity(request, e1);

        } catch (Exception e1) {

            return ExceptionUtil.getInternalErrorResponseEntity(request, e1);

        }
    }
}
