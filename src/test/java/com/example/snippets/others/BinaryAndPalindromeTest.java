package com.example.snippets.others;

import com.example.snippets.algorithms.MaximumPalindrome;
import com.example.snippets.demo.others.BinaryAndPalindrome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryAndPalindromeTest {

    private BinaryAndPalindrome target = new BinaryAndPalindrome();

    @Test
    public void palindromeTest() throws OperationNotSupportedException {
        BinaryAndPalindrome target = new BinaryAndPalindrome();
        assertEquals("989", target.palindrome("8199"));
        assertEquals("5", target.palindrome("12345"));
        assertEquals("898", target.palindrome("39878"));
        assertEquals("83238", target.palindrome("83238"));
        assertEquals("33833", target.palindrome("83333"));
        assertEquals("83338", target.palindrome("88333"));
        assertEquals("38883", target.palindrome("33888"));
        assertEquals("88388", target.palindrome("38888"));
        assertEquals("0", target.palindrome("00000"));
        assertEquals("80008", target.palindrome("08800"));
        assertEquals("99999", target.palindrome("99999"));
        assertEquals("97979", target.palindrome("77999"));
        assertEquals("434", target.palindrome("44312"));
        assertEquals("444", target.palindrome("44412"));
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
