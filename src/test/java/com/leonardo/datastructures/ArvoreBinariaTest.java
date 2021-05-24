package com.leonardo.datastructures;

import com.leonardo.datastructures.stack.PilhaCheiaException;
import com.leonardo.datastructures.stack.PilhaVetor;
import com.leonardo.datastructures.tree.binary.ArvoreBinaria;
import com.leonardo.datastructures.tree.binary.NoArvoreBinaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArvoreBinariaTest {
    private ArvoreBinaria<Integer> testTree;

    @BeforeEach
    void setup() {
        testTree = new ArvoreBinaria<>();
    }

    @Test
    @DisplayName("New tree should be empty after construct")
    void testNewTreeShouldBeEmpty() {
        assertTrue(testTree.estaVazia());
    }

    @Test
    @DisplayName("Tree with a node should not be empty")
    void testTreeWithNoteShouldntBeEmpty() {
        testTree.setRaiz(new NoArvoreBinaria<>(5));

        assertFalse(testTree.estaVazia());
    }

    @Test
    @DisplayName("toString should return in pre-order")
    void testToStringPreOrder() {
        var root = new NoArvoreBinaria<>(1);

        var nodeLeft = new NoArvoreBinaria<>(2);
        var nodeLeftBottom = new NoArvoreBinaria<>(4);
        nodeLeft.setDireita(nodeLeftBottom);

        var nodeRight = new NoArvoreBinaria<>(3);
        var nodeRightBottomLeft = new NoArvoreBinaria<>(5);
        var nodeRightBottomRight = new NoArvoreBinaria<>(6);

        nodeRight.setEsquerda(nodeRightBottomLeft);
        nodeRight.setDireita(nodeRightBottomRight);

        root.setEsquerda(nodeLeft);
        root.setDireita(nodeRight);

        testTree.setRaiz(root);

        assertEquals("<1<2<><4<><>>><3<5<><>><6<><>>>>", testTree.toString());
    }

    @Test
    @DisplayName("should be able to check if a value is part of the tree")
    void testPertence() {
        var root = new NoArvoreBinaria<>(1);

        var nodeLeft = new NoArvoreBinaria<>(2);
        var nodeLeftBottom = new NoArvoreBinaria<>(4);
        nodeLeft.setDireita(nodeLeftBottom);

        var nodeRight = new NoArvoreBinaria<>(3);
        var nodeRightBottomLeft = new NoArvoreBinaria<>(5);
        var nodeRightBottomRight = new NoArvoreBinaria<>(6);

        nodeRight.setEsquerda(nodeRightBottomLeft);
        nodeRight.setDireita(nodeRightBottomRight);

        root.setEsquerda(nodeLeft);
        root.setDireita(nodeRight);

        testTree.setRaiz(root);

        assertTrue(testTree.pertence(1));
    }

    @Test
    @DisplayName("should be able to check if a value is part of the tree - 2")
    void testPertence2() {
        var root = new NoArvoreBinaria<>(1);

        var nodeLeft = new NoArvoreBinaria<>(2);
        var nodeLeftBottom = new NoArvoreBinaria<>(4);
        nodeLeft.setDireita(nodeLeftBottom);

        var nodeRight = new NoArvoreBinaria<>(3);
        var nodeRightBottomLeft = new NoArvoreBinaria<>(5);
        var nodeRightBottomRight = new NoArvoreBinaria<>(6);

        nodeRight.setEsquerda(nodeRightBottomLeft);
        nodeRight.setDireita(nodeRightBottomRight);

        root.setEsquerda(nodeLeft);
        root.setDireita(nodeRight);

        testTree.setRaiz(root);

        assertTrue(testTree.pertence(3));
    }

    @Test
    @DisplayName("should be able to check if a value is part of the tree - 3")
    void testPertence3() {
        var root = new NoArvoreBinaria<>(1);

        var nodeLeft = new NoArvoreBinaria<>(2);
        var nodeLeftBottom = new NoArvoreBinaria<>(4);
        nodeLeft.setDireita(nodeLeftBottom);

        var nodeRight = new NoArvoreBinaria<>(3);
        var nodeRightBottomLeft = new NoArvoreBinaria<>(5);
        var nodeRightBottomRight = new NoArvoreBinaria<>(6);

        nodeRight.setEsquerda(nodeRightBottomLeft);
        nodeRight.setDireita(nodeRightBottomRight);

        root.setEsquerda(nodeLeft);
        root.setDireita(nodeRight);

        testTree.setRaiz(root);

        assertTrue(testTree.pertence(6));
    }

    @Test
    @DisplayName("should be able to check if a value isn't part of the tree")
    void testPertence4() {
        var root = new NoArvoreBinaria<>(1);

        var nodeLeft = new NoArvoreBinaria<>(2);
        var nodeLeftBottom = new NoArvoreBinaria<>(4);
        nodeLeft.setDireita(nodeLeftBottom);

        var nodeRight = new NoArvoreBinaria<>(3);
        var nodeRightBottomLeft = new NoArvoreBinaria<>(5);
        var nodeRightBottomRight = new NoArvoreBinaria<>(6);

        nodeRight.setEsquerda(nodeRightBottomLeft);
        nodeRight.setDireita(nodeRightBottomRight);

        root.setEsquerda(nodeLeft);
        root.setDireita(nodeRight);

        testTree.setRaiz(root);

        assertFalse(testTree.pertence(10));
    }

    @Test
    @DisplayName("the number of nodes should be the same as inserted")
    void testContarNos() {
        var root = new NoArvoreBinaria<>(1);

        var nodeLeft = new NoArvoreBinaria<>(2);
        var nodeLeftBottom = new NoArvoreBinaria<>(4);
        nodeLeft.setDireita(nodeLeftBottom);

        var nodeRight = new NoArvoreBinaria<>(3);
        var nodeRightBottomLeft = new NoArvoreBinaria<>(5);
        var nodeRightBottomRight = new NoArvoreBinaria<>(6);

        nodeRight.setEsquerda(nodeRightBottomLeft);
        nodeRight.setDireita(nodeRightBottomRight);

        root.setEsquerda(nodeLeft);
        root.setDireita(nodeRight);

        testTree.setRaiz(root);

        assertEquals(6, testTree.contarNos());
    }
}
