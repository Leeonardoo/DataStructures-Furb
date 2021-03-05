package com.leonardo.staticlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaEstaticaTests {

    private ListaEstatica testList;

    @BeforeEach
    void setup() {
        testList = new ListaEstatica();
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

}
