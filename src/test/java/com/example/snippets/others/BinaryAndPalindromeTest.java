package com.example.snippets.others;

import com.example.snippets.demo.others.BinaryAndPalindrome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryAndPalindromeTest {

    private BinaryAndPalindrome target = new BinaryAndPalindrome();

    @Test
    public void palindromeTest() throws OperationNotSupportedException {
        String result = target.palindrome("8199");
        assertEquals("989", result);
        result = target.palindrome("12345");
        assertEquals("5", result);
        result = target.palindrome("39878");
        assertEquals("898", result);
        result = target.palindrome("83238");
        assertEquals("83238", result);
        result = target.palindrome("83333");
        assertEquals("33833", result);
        result = target.palindrome("88333");
        assertEquals("83338", result);
        result = target.palindrome("33888");
        assertEquals("38883", result);
        result = target.palindrome("38888");
        assertEquals("88388", result);
        result = target.palindrome("00000");
        assertEquals("0", result);
        result = target.palindrome("08800");
        assertEquals("80008", result);
        result = target.palindrome("99999");
        assertEquals("99999", result);
        Assertions.assertThrows(OperationNotSupportedException.class, () -> target.palindrome("839938"), "The number is grater than 100000");

    }

    @Test
    public void binaryTest(){
        int amountOfOnes = target.binary(3, 7);
        assertEquals(3, amountOfOnes);
        amountOfOnes = target.binary(5, 7);
        assertEquals(3, amountOfOnes);
        amountOfOnes = target.binary(15, 72);
        assertEquals(4, amountOfOnes);
    }

}
