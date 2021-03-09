package com.leonardo.staticlist;

@SuppressWarnings("unchecked")
public class ListaEstaticaGenerica<T> {

    private T[] info = (T[]) new Object[10];
    private int tamanho = 0;

    @SuppressWarnings("unchecked")
    private void redimensionar() {
        T[] oldArr = info;
        info = (T[]) new Object[oldArr.length + 10];
        for (int i = 0; i < oldArr.length; i++) {
            info[i] = oldArr[i];
        }
    }

    public void inserir(T item) {
        if (tamanho == info.length) {
            redimensionar();
        }
        //Zero-indexed
        info[tamanho] = item;
        tamanho++;
    }

    public void exibir() {
        System.out.println(this.toString());
    }

    public int buscar(T item) {
        for (int i = 0; i < getTamanho() - 1; i++) {
            if (obterElemento(i).equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T item) {
        int index = buscar(item);

        if (index != -1) {
            for (int i = index; i < getTamanho() - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    @SuppressWarnings("unchecked")
    public void liberar() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    public T obterElemento(int position) {
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
            elements.append(obterElemento(i).toString());
            if (i < getTamanho() - 1) {
                elements.append(",");
            }
        }

        return elements.toString();
    }
}