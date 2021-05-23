package com.leonardo.datastructures;

import com.leonardo.datastructures.queue.FilaCheiaException;
import com.leonardo.datastructures.queue.FilaVaziaException;
import com.leonardo.datastructures.queue.FilaVetor;
import com.leonardo.datastructures.stack.PilhaCheiaException;
import com.leonardo.datastructures.stack.PilhaVetor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilaTest {
    private FilaVetor<Integer> testQueue;

    @Test
    @DisplayName("New queue should be empty after construct")
    void testNewQueueShouldBeEmpty() {
        testQueue = new FilaVetor<>(5);

        assertTrue(testQueue.estaVazia());
    }

    @Test
    @DisplayName("queue with elements shouldn't be empty")
    void testWithElementsShoulntBeEmpty() {
        testQueue = new FilaVetor<>(10);

        testQueue.inserir(10);
        assertFalse(testQueue.estaVazia());
    }

    @Test
    @DisplayName("queue should add and remove correctly")
    void testAddAndRemove() {
        testQueue = new FilaVetor<>(10);
        testQueue.inserir(10);
        testQueue.inserir(20);
        testQueue.inserir(30);

        assertEquals(10, testQueue.retirar());
        assertEquals(20, testQueue.retirar());
        assertEquals(30, testQueue.retirar());

        assertTrue(testQueue.estaVazia());
    }

    @Test
    @DisplayName("should throw FilaCheiaException when trying to add more items than the capacity")
    void testThrowOnFull() {
        testQueue = new FilaVetor<>(3);
        testQueue.inserir(10);
        testQueue.inserir(20);
        testQueue.inserir(30);

        assertThrows(FilaCheiaException.class, () -> testQueue.inserir(40));
    }

    @Test
    @DisplayName("retirar() should throe FilaVaziaException on an empty queue")
    void testThrowOnEmpty() {
        testQueue = new FilaVetor<>(5);

        assertThrows(FilaVaziaException.class, () -> testQueue.retirar());
    }

    @Test
    @DisplayName("peek() should return the bottom value")
    void testPeek() {
        testQueue = new FilaVetor<>(5);
        testQueue.inserir(10);
        testQueue.inserir(20);
        testQueue.inserir(30);

        assertEquals(10, testQueue.peek());
        assertEquals(10, testQueue.retirar());
    }


    @Test
    @DisplayName("liberar() should clear all items from the queue")
    void testLiberar() {
        testQueue = new FilaVetor<>(5);
        testQueue.inserir(10);
        testQueue.inserir(20);
        testQueue.inserir(30);

        testQueue.liberar();
        assertTrue(testQueue.estaVazia());
    }

    @Test
    @DisplayName("concatenation should add the second queue to the first")
    void testConcatenation() {
        testQueue = new FilaVetor<>(5);
        testQueue.inserir(10);
        testQueue.inserir(20);
        testQueue.inserir(30);

        var testQueue2 = new FilaVetor<Integer>(3);
        testQueue2.inserir(40);
        testQueue2.inserir(50);

        var newQueue = testQueue.criarFilaConcatenada(testQueue2);

        assertEquals("10,20,30,40,50", newQueue.toString());
        assertEquals("10,20,30", testQueue.toString());
        assertEquals("40,50", testQueue2.toString());
    }
}
