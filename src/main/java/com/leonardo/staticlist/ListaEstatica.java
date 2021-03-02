package com.leonardo.staticlist;

import java.util.Arrays;

public class ListaEstatica {
    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new int[10];
        tamanho = 0; //Empty
    }

    private void redimensionar() {
        int[] oldArr = info;
        info = new int[oldArr.length + 10];
        for (int i = 0; i < oldArr.length; i++) {
            info[i] = oldArr[i];
        }
    }

    public void inserir(int value) {
        if (tamanho == info.length) {
            redimensionar();
        }
        //Zero-indexed
        info[tamanho] = value;
        tamanho++;
    }

    public void exibir() {
        System.out.println(this.toString());
    }

    public int buscar(int value) {
        return -1;
    }

    public void retirar(int value) {

    }

    public int obterElemento(int position) {
        //Zero-indexed
        if (position > getTamanho() - 1 || position <= 0) {
            throw new IndexOutOfBoundsException("Trying to access an index out the bounds of the current items on the list! Requested index was " + position + " while the size is " + getTamanho());
        }
        return info[position];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return Arrays.toString(info);
    }
}
