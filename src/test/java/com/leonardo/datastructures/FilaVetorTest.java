package com.leonardo.datastructures;

import com.leonardo.datastructures.queue.FilaCheiaException;
import com.leonardo.datastructures.queue.FilaVaziaException;
import com.leonardo.datastructures.queue.FilaVetor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilaVetorTest {

    @Test
    @DisplayName("New queue should be empty after construct")
    void testNewQueueShouldBeEmpty() {
        FilaVetor<Integer> testQueue = new FilaVetor<>(1);
        assertTrue(testQueue.estaVazia());
    }

    @Test
    @DisplayName("Queue with a value shouldn't be empty")
    void testQueueWithValueCannotBeEmpty() {
        FilaVetor<Integer> testQueue = new FilaVetor<>(5);
        testQueue.inserir(10);
        assertFalse(testQueue.estaVazia());
    }

    @Test
    @DisplayName("Should insert and remove all the items from que queue until it's empty again")
    void testItemInclusionExclusion() {
        FilaVetor<Integer> testQueue = new FilaVetor<>(10);
        testQueue.inserir(10);
        testQueue.inserir(20);
        testQueue.inserir(30);

        assertEquals(10, testQueue.retirar());
        assertEquals(20, testQueue.retirar());
        assertEquals(30, testQueue.retirar());

        assertTrue(testQueue.estaVazia());
    }

    @Test
    @DisplayName("Insert after maximum limit should throw")
    void testInsertAfterLimit() {
        FilaVetor<Integer> testQueue = new FilaVetor<>(3);

        testQueue.inserir(10);
        testQueue.inserir(20);
        testQueue.inserir(30);

        assertThrows(FilaCheiaException.class, () -> testQueue.inserir(40));
    }

    @Test
    @DisplayName("retirar() on an empty queue should throw")
    void testRemoveFromEmptyQueue() {
        FilaVetor<Integer> testQueue = new FilaVetor<>(1);

        assertThrows(FilaVaziaException.class, testQueue::retirar);
    }

    @Test
    @DisplayName("peek() should return the value on the start of the queue")
    void testPeek() {
        FilaVetor<Integer> testQueue = new FilaVetor<>(5);

        testQueue.inserir(10);
        testQueue.inserir(20);
        testQueue.inserir(30);

        assertEquals(10, testQueue.retirar());
    }

    @Test
    @DisplayName("liberar() on a queue should clear it")
    void testLiberar() {
        FilaVetor<Integer> testQueue = new FilaVetor<>(5);

        testQueue.inserir(10);
        testQueue.inserir(20);
        testQueue.inserir(30);
        testQueue.liberar();

        assertTrue(testQueue.estaVazia());
    }

    //TODO
}
