package com.leonardo.datastructures;

import com.leonardo.datastructures.stack.PilhaLista;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaListaTest {
    private PilhaLista<Integer> testStack;

    @Test
    @DisplayName("New stack should be empty after construct")
    void testNewStackShouldBeEmpty() {
        testStack = new PilhaLista<>();

        assertTrue(testStack.estaVazia());
    }

    @Test
    @DisplayName("stack with elements shouldn't be empty")
    void testWithElementsShoulntBeEmpty() {
        testStack = new PilhaLista<>();

        testStack.push(10);
        assertFalse(testStack.estaVazia());
    }

    @Test
    @DisplayName("stack should push and pop correctly")
    void testPushAndPop() {
        testStack = new PilhaLista<>();
        testStack.push(10);
        testStack.push(20);
        testStack.push(30);

        assertEquals(30, testStack.pop());
        assertEquals(20, testStack.pop());
        assertEquals(10, testStack.pop());

        assertTrue(testStack.estaVazia());
    }

    @Test
    @DisplayName("peek should return the top value")
    void testPeek() {
        testStack = new PilhaLista<>();
        testStack.push(10);
        testStack.push(20);
        testStack.push(30);

        assertEquals(30, testStack.peek());
        assertEquals(30, testStack.pop());
    }

    @Test
    @DisplayName("liberar() should remove all elements")
    void testLiberar() {
        testStack = new PilhaLista<>();
        testStack.push(10);
        testStack.push(20);
        testStack.push(30);

        testStack.liberar();

        assertTrue(testStack.estaVazia());
    }
}
