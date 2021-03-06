package com.leonardo.staticlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListaEstaticaGenericaTests {

    private ListaEstaticaGenerica<Integer> testList;

    @BeforeEach
    void setup() {
        testList = new ListaEstaticaGenerica<>();
    }

    @Test
    @DisplayName("Simple inclusion and .toString() should work")
    void itemInclusion() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        assertEquals("5,10,15,20", testList.toString());
    }

    @Test
    @DisplayName("getTamanho() should match with the actual size")
    void ensureSize() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        assertEquals(4, testList.getTamanho());
    }

    @Test
    @DisplayName("buscar() should return the value's index")
    void findIndex() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        assertEquals(2, testList.buscar(15));
    }

    @Test
    @DisplayName("buscar() on a non-existing value should return -1")
    void findNonExisting() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        assertEquals(-1, testList.buscar(30));
    }

    @Test
    @DisplayName("retirar() should remove the item")
    void removeItem() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        testList.retirar(10);

        assertEquals("5,15,20", testList.toString());
    }

    @Test
    @DisplayName("more than 10 items should cause the internal array to grow")
    void testGrow() {
        for (int i = 1; i <= 15; i++) {
            testList.inserir(i);
        }

        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", testList.toString());
    }

    @Test
    @DisplayName("buscar() should return the element within that index")
    void getElement() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        assertEquals(20, testList.obterElemento(3));
    }

    @Test
    @DisplayName("buscar() on a out of bounds index should throw")
    void getOutOfBoundsElement() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        assertThrows(IndexOutOfBoundsException.class, () -> testList.obterElemento(5));
    }

    @Test
    @DisplayName("liberar() should remove all items")
    void testFreeList() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        testList.liberar();

        assertTrue(testList.estaVazia());
    }
}
