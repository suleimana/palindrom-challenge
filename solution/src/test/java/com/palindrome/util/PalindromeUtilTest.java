/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palindrome.util;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author suleimanalrosan
 */
public class PalindromeUtilTest {

    private Map<String, Long> source;
    private PalindromeUtil palindromeUtil;

    public PalindromeUtilTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        palindromeUtil = new PalindromeUtil();        
        
        source = new HashMap<>();
        source.put("Nicola Tesla", 531441L);
        source.put("Max Planck", 32768L);
        source.put("Marie Curie", 16807L);
        source.put("Maria Mayer", 7776L);
        source.put("", 0L);        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of palindromeCount method, of class PalindromeUtil.
     */
    @org.junit.Test
    public void testPalindromeCount() {
       
        for (String input : source.keySet()) {
            Long expResult = source.get(input);
            Long result = palindromeUtil.palindromeCount(input);
            assertEquals(expResult, result);
        }
    }

    @org.junit.Test(expected=IllegalArgumentException.class)    
    public void testPalindromeCountWithNull() {       
        palindromeUtil.palindromeCount(null);        
    }

}
