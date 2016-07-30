package com.palindrome.controller;

import com.palindrome.view.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author suleimanalrosan - Jul 29, 2016
 */
public abstract class ErrorController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public BaseResponse handleException(Exception e) {
        return new BaseResponse(false, e.getMessage());
    }

}
