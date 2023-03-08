package com.example.snippets.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumPalindromeTest {


    @Test
    public void palindromeTest() throws OperationNotSupportedException {
        MaximumPalindrome target = new MaximumPalindrome();
        assertEquals("989", target.palindrome("8199"));
        assertEquals("5", target.palindrome("12345"));
        assertEquals("898", target.palindrome("39878"));
        assertEquals("83238", target.palindrome("83238"));
        assertEquals("33833", target.palindrome("83333"));
        assertEquals("83338", target.palindrome("88333"));
        assertEquals("83838", target.palindrome("33888"));
        assertEquals("88388", target.palindrome("38888"));
        assertEquals("00000", target.palindrome("00000"));
        assertEquals("80008", target.palindrome("08800"));
        assertEquals("99999", target.palindrome("99999"));
        assertEquals("444", target.palindrome("44412"));
        assertEquals("83838", target.palindrome("88833"));

        assertEquals("97679", target.palindrome("76997"));
        assertEquals("97779", target.palindrome("77997"));
        assertEquals("989", target.palindrome("8199"));

        assertEquals("999", target.palindrome("81999"));
        assertEquals("99899", target.palindrome("89999"));
        assertEquals("11911", target.palindrome("91111"));
        assertEquals("464", target.palindrome("44456"));
        assertEquals("464", target.palindrome("44456"));


    }

    @Test
    public void palindromeSpecificTest() {
        MaximumPalindrome target = new MaximumPalindrome();
        //assertEquals("33833", target.palindrome("83333"));

        //assertEquals("898", target.palindrome("39878"));
        //assertEquals("97779", target.palindrome("77997"));
        //assertEquals("33833", target.palindrome("83333"));
        assertEquals("83338", target.palindrome("88333"));


    }

    @Test
    public void palindromeMoreThanNValuesTest() {
        MaximumPalindrome target = new MaximumPalindrome();
        assertEquals("9", target.palindrome("123456789"));
    }

}
