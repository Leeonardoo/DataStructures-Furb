package com.leonardo.datastructures;

import com.leonardo.datastructures.doublechained.ListaDupla;
import com.leonardo.datastructures.doublechained.NoListaDupla;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListaDuplaTest {
    private ListaDupla<Integer> testList;

    @BeforeEach
    void setup() {
        testList = new ListaDupla<>();

        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);
    }

    @Test
    @DisplayName("Items should keep the right orded")
    void testItemsOrder() {
        var item = testList.getPrimeiro();

        assertEquals(20, item.getInfo());
        item = item.getProximo();
        assertEquals(15, item.getInfo());
        item = item.getProximo();
        assertEquals(10, item.getInfo());
        item = item.getProximo();
        assertEquals(5, item.getInfo());

        item = testList.obterUltimo();
        assertEquals(5, item.getInfo());
        item = item.getAnterior();
        assertEquals(10, item.getInfo());
        item = item.getAnterior();
        assertEquals(15, item.getInfo());
        item = item.getAnterior();
        assertEquals(20, item.getInfo());
    }

    @Test
    @DisplayName("buscar() should return the correct node containing the value provided")
    void testBuscar1() {
        assertEquals(20, testList.buscar(20).getInfo());
    }

    @Test
    @DisplayName("buscar() should return the correct node containing the value provided - 2")
    void testBuscar2() {
        assertEquals(10, testList.buscar(10).getInfo());
    }

    @Test
    @DisplayName("remove the first element")
    void removeFirstElementTest() {
        testList.retirar(20);

        var item = testList.getPrimeiro();

        assertEquals(15, item.getInfo());
        item = item.getProximo();
        assertEquals(10, item.getInfo());
        item = item.getProximo();
        assertEquals(5, item.getInfo());

        item = testList.obterUltimo();
        assertEquals(5, item.getInfo());
        item = item.getAnterior();
        assertEquals(10, item.getInfo());
        item = item.getAnterior();
        assertEquals(15, item.getInfo());
    }

    @Test
    @DisplayName("remove an element from the middle")
    void removeMiddleElementTest() {
        testList.retirar(10);

        var item = testList.getPrimeiro();

        assertEquals(20, item.getInfo());
        item = item.getProximo();
        assertEquals(15, item.getInfo());
        item = item.getProximo();
        assertEquals(5, item.getInfo());

        item = testList.obterUltimo();
        assertEquals(5, item.getInfo());
        item = item.getAnterior();
        assertEquals(15, item.getInfo());
        item = item.getAnterior();
        assertEquals(20, item.getInfo());
    }

    @Test
    @DisplayName("remove the last element")
    void removeLastElementTest() {
        testList.retirar(5);

        var item = testList.getPrimeiro();

        assertEquals(20, item.getInfo());
        item = item.getProximo();
        assertEquals(15, item.getInfo());
        item = item.getProximo();
        assertEquals(10, item.getInfo());

        item = testList.obterUltimo();
        assertEquals(10, item.getInfo());
        item = item.getAnterior();
        assertEquals(15, item.getInfo());
        item = item.getAnterior();
        assertEquals(20, item.getInfo());
    }

    @Test
    @DisplayName("liberar() should remove all elements references")
    void liberarTest() {
        var node5 = testList.buscar(5);
        var node10 = testList.buscar(10);
        var node15 = testList.buscar(15);
        var node20 = testList.buscar(20);

        testList.liberarLista();

        assertNull(node5.getAnterior());
        assertNull(node5.getProximo());

        assertNull(node10.getAnterior());
        assertNull(node10.getProximo());

        assertNull(node15.getAnterior());
        assertNull(node15.getProximo());

        assertNull(node20.getAnterior());
        assertNull(node20.getProximo());
    }
}
