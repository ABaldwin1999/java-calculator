package org.example;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {
    Calculate testCalculate = new Calculate();
    @Test
    void addition_ofTwoNumbers_returnCorrect () {
        assertEquals(5,testCalculate.calculate("2+3"));
    }
    @Test
    void addition_ofNegativeNumbers_returnCorrect () {
        assertEquals(-6,testCalculate.calculate("-2+-3+-1"));
    }
    @Test
    void subtraction_ofTwoNumbers_returnCorrect () {
        assertEquals(-1,testCalculate.calculate("2-3"));
    }
    @Test
    void multiplication_ofTwoNumbers_returnCorrect () {
        assertEquals(6,testCalculate.calculate("2*3"));
    }
    @Test
    void division_ofTwoNumbers_returnCorrect () {
        assertEquals(3,testCalculate.calculate("6/2"));
    }
    @Test
    void calculate_fullBODMAS_returnCorrect () {
        assertEquals(3,testCalculate.calculate("6/2+3-4*2"));
    }
    @Test
    void calculate_fullBODMASWithBrackets_returnCorrect () {
        assertEquals(3,testCalculate.calculate("6/(2+3)-4*2"));
    }
}