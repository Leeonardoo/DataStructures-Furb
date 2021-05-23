package com.leonardo.datastructures;

import com.leonardo.datastructures.queue.FilaLista;
import com.leonardo.datastructures.queue.FilaLista;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilaListaTest {
    private FilaLista<Integer> testQueue;

    @Test
    @DisplayName("New queue should be empty after construct")
    void testNewQueueShouldBeEmpty() {
        testQueue = new FilaLista<>();

        assertTrue(testQueue.estaVazia());
    }

    @Test
    @DisplayName("queue with elements shouldn't be empty")
    void testWithElementsShoulntBeEmpty() {
        testQueue = new FilaLista<>();

        testQueue.inserir(10);
        assertFalse(testQueue.estaVazia());
    }

    @Test
    @DisplayName("queue should add and remove correctly")
    void testAddAndRemove() {
        testQueue = new FilaLista<>();
        testQueue.inserir(10);
        testQueue.inserir(20);
        testQueue.inserir(30);

        assertEquals(10, testQueue.retirar());
        assertEquals(20, testQueue.retirar());
        assertEquals(30, testQueue.retirar());

        assertTrue(testQueue.estaVazia());
    }

    @Test
    @DisplayName("peek should return the bottom value")
    void testPeek() {
        testQueue = new FilaLista<>();
        testQueue.inserir(10);
        testQueue.inserir(20);
        testQueue.inserir(30);

        assertEquals(10, testQueue.peek());
        assertEquals(10, testQueue.retirar());
    }

    @Test
    @DisplayName("liberar() should remove all elements")
    void testLiberar() {
        testQueue = new FilaLista<>();
        testQueue.inserir(10);
        testQueue.inserir(20);
        testQueue.inserir(30);

        testQueue.liberar();

        assertTrue(testQueue.estaVazia());
    }
}
