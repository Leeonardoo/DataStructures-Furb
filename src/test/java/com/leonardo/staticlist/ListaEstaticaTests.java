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
}
