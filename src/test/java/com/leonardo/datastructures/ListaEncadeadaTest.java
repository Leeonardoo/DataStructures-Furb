package com.leonardo.datastructures;

import com.leonardo.datastructures.chained.ListaEncadeada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListaEncadeadaTest {
    private ListaEncadeada<Integer> testList;

    @BeforeEach
    void setup() {
        testList = new ListaEncadeada<>();
    }

    @Test
    @DisplayName("New list should be empty after construct")
    void testNewListShouldBeEmpty() {
        assertTrue(testList.estaVazia());
    }

    @Test
    @DisplayName("List with a value shouldn't be empty")
    void testListWithValueCannotBeEmpty() {
        testList.inserir(5);
        assertFalse(testList.estaVazia());
    }

    @Test
    @DisplayName("Should contain the single inserted value without any additional node")
    void testItemInclusion() {
        testList.inserir(5);

        assertEquals(5, testList.getPrimeiro().getInfo());
        assertNull(testList.getPrimeiro().getProximo());
    }

    @Test
    @DisplayName("Should contain all inserted values without any additional node")
    void testMultipleItemInclusion() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);

        assertEquals(3, testList.obterComprimento());
        assertEquals("15,10,5", testList.toString());
    }

    @Test
    @DisplayName("buscar() on the first position should return the Node with corresponding value")
    void testBuscarFirst() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        assertEquals(20, testList.buscar(20).getInfo());
    }

    @Test
    @DisplayName("buscar() on other positions should return the node with corresponding value")
    void testBuscar() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        assertEquals(15, testList.buscar(15).getInfo());
    }

    @Test
    @DisplayName("buscar() on non-existing value should return null")
    void testBuscarNonExistingValue() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        assertNull(testList.buscar(50));
    }

    @Test
    @DisplayName("retirar() on the first value should remove only that value")
    void testRetirarFirstValue() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        testList.retirar(20);

        assertEquals("15,10,5", testList.toString());
    }

    @Test
    @DisplayName("retirar() on other positions should only remove that value")
    void testRetirar() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        testList.retirar(15);
        assertEquals("20,10,5", testList.toString());
    }

    @Test
    @DisplayName("obterNo() should return the first node too")
    void testObterNoFirst() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        assertEquals(20, testList.obterNo(0).getInfo());
    }

    @Test
    @DisplayName("obterNo() on other positions should return the right node")
    void testObterNo() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        assertEquals(5, testList.obterNo(3).getInfo());
    }

    @Test
    @DisplayName("obterNo() on invalid index should throw")
    void testObterNoInvalidIndex() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        assertThrows(IndexOutOfBoundsException.class, () -> testList.obterNo(10));
    }

    @Test
    @DisplayName("obterComprimento() on an empty list should be 0")
    void testObterComprimentoEmptyList() {
        assertEquals(0, testList.obterComprimento());
    }

    @Test
    @DisplayName("obterComprimento() should return the item count")
    void testObterComprimento() {
        testList.inserir(5);
        testList.inserir(10);
        testList.inserir(15);
        testList.inserir(20);

        assertEquals(4, testList.obterComprimento());
    }
}
