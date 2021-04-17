package com.leonardo.datastructures.staticlist;

public class ListaEstaticaProva {

    private int[] info = new int[10];
    private int tamanho = 0;

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

        boolean move = false;
        int index = -1;
        int old = -1;

        for (int i = 0; i <= getTamanho() - 1; i++) {
            if (move) {
                info[i + 1] = info[i];
            } else {
                if (info[i] > value) {
                    old = info[i];
                    index = i;
                    move = true;
                    tamanho++;
                }
            }
        }

        if (index == -1) {
            info[tamanho] = value;
            tamanho++;
        } else {
            info[index] = value;
        }

        if (move) {
            info[index + 1] = old;
        }
    }

    public void exibir() {
        System.out.println(this.toString());
    }

    public int buscar(int value) {
        for (int i = 0; i < getTamanho() - 1; i++) {
            if (obterElemento(i) == value) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(int value) {
        int index = buscar(value);

        if (index != -1) {
            for (int i = index; i < getTamanho() - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    public void liberar() {
        info = new int[10];
        tamanho = 0;
    }

    public int obterElemento(int position) {
        //Zero-indexed
        if (position > getTamanho() - 1 || position < 0) {
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
        StringBuilder elements = new StringBuilder();
        for (int i = 0; i < getTamanho(); i++) {
            elements.append(obterElemento(i));
            if (i < getTamanho() - 1) {
                elements.append(",");
            }
        }

        return elements.toString();
    }
}
