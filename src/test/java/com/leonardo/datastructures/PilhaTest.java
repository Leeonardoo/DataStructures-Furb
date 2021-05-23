package com.leonardo.datastructures;

import com.leonardo.datastructures.chained.ListaEncadeada;
import com.leonardo.datastructures.stack.PilhaCheiaException;
import com.leonardo.datastructures.stack.PilhaVetor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaTest {
    private PilhaVetor<Integer> testStack;

    @Test
    @DisplayName("New stack should be empty after construct")
    void testNewStackShouldBeEmpty() {
        testStack = new PilhaVetor<>(5);

        assertTrue(testStack.estaVazia());
    }

    @Test
    @DisplayName("stack with elements shouldn't be empty")
    void testWithElementsShoulntBeEmpty() {
        testStack = new PilhaVetor<>(10);

        testStack.push(10);
        assertFalse(testStack.estaVazia());
    }

    @Test
    @DisplayName("stack should push and pop correctly")
    void testPushAndPop() {
        testStack = new PilhaVetor<>(10);
        testStack.push(10);
        testStack.push(20);
        testStack.push(30);

        assertEquals(30, testStack.pop());
        assertEquals(20, testStack.pop());
        assertEquals(10, testStack.pop());

        assertTrue(testStack.estaVazia());
    }

    @Test
    @DisplayName("should throw PilhaCheiaException when trying to add more items than the capacity")
    void testThrowOnFull() {
        testStack = new PilhaVetor<>(3);
        testStack.push(10);
        testStack.push(20);
        testStack.push(30);

        assertThrows(PilhaCheiaException.class, () -> testStack.push(40));
    }

    @Test
    @DisplayName("peek should return the top value")
    void testPeek() {
        testStack = new PilhaVetor<>(5);
        testStack.push(10);
        testStack.push(20);
        testStack.push(30);

        assertEquals(30, testStack.peek());
        assertEquals(30, testStack.pop());
    }

    @Test
    @DisplayName("liberar() should remove all elements")
    void testLiberar() {
        testStack = new PilhaVetor<>(5);
        testStack.push(10);
        testStack.push(20);
        testStack.push(30);

        testStack.liberar();

        assertTrue(testStack.estaVazia());
    }

    @Test
    @DisplayName("peek should return the top value")
    void testConcatenation() {
        testStack = new PilhaVetor<>(5);
        testStack.push(10);
        testStack.push(20);
        testStack.push(30);

        var testStack2 = new PilhaVetor<Integer>(2);
        testStack2.push(40);
        testStack2.push(50);

        testStack.concatenar(testStack2);

        assertEquals("50,40,30,20,10", testStack.toString());
    }
}
