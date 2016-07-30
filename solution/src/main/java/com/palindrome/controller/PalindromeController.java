package com.palindrome.controller;

import com.palindrome.view.PalindromeResponse;
import com.palindrome.dto.nasa.PatentReport;
import com.palindrome.exception.PalindromeException;
import com.palindrome.service.PalindromeService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController extends ErrorController{

    @Autowired
    private PalindromeService palindromeService;

    @ApiOperation("Returns back part of the patent report for particular search string ")
    @RequestMapping(value = {"/patents"}, method = RequestMethod.GET)
    public PatentReport patents(
            @RequestParam(value = "search", required = true) String search,
            @RequestParam(value = "limit", defaultValue = "1", required = false) int limit) throws PalindromeException {
        return palindromeService.getPatentReport(search, limit);
    }

    @ApiOperation("Calculates the number of palindromic strings that can be created using the name letters."
            + " Name should be treated as case-insensitive (i.e. b and B is the same letter) "
            + "and all white-spaces should be ignored. A valid palindromic string is one that uses only"
            + " the letters in the given name, and is the same length as the given name. "
            + "Each letter can be used more than once, and not every letter must be used. "
            + "For example, given the name \"Graham Bell\", \"aaahhhhaaa\" and \"bellmmlleb\" are valid, "
            + "but \"aaa\" and \"hhhsagtbbb\" are not")
    @RequestMapping(value = {"/palindromes"}, method = RequestMethod.GET)
    public List<PalindromeResponse> palindromes(
            @RequestParam(value = "search", required = true) String search,
            @RequestParam(value = "limit", defaultValue = "1", required = false) int limit) throws PalindromeException {
        return palindromeService.calculatePalindrome(search, limit);
    }
  
}
