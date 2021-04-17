package com.leonardo.datastructures.queue;

import java.util.PriorityQueue;

public class FilaVetor<T> implements Fila<T> {

    private T[] info;
    private final int limite;
    private int tamanho = 0, inicio = 0;

    @SuppressWarnings("unchecked")
    public FilaVetor(int limite) {
        info = (T[]) new Object[limite];
        this.limite = limite;
    }

    @Override
    public void inserir(T value) {
        if (tamanho == limite) {
            throw new FilaCheiaException("Trying to add a new value when the queue is already full.");
        }

        int pos = (inicio + tamanho) % limite;
        info[pos] = value;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException("Trying to peek into a empty queue.");
        }

        return info[inicio];
    }

    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException("Trying to peek into a empty queue.");
        }

        T value = peek();
        info[inicio] = null;

        inicio = (inicio + 1) % limite;
        tamanho--;
        return value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void liberar() {
        info = (T[]) new Object[limite];
        tamanho = 0;
        inicio = 0;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> f3 = new FilaVetor<>(this.limite + f2.limite);

        int index = this.inicio;

        for (int i = 0; i < this.tamanho; i++) {
            f3.inserir(this.info[index]);
            index = (index + 1) % this.limite;
        }

        index = f2.inicio;
        for (int i = 0; i < f2.tamanho; i++) {
            f3.inserir(f2.info[index]);
            index = (index + 1) % f2.limite;
        }

        return f3;
    }

    @Override
    public String toString() {
        StringBuilder elements = new StringBuilder();

        int index = inicio;

        for (int i = 0; i < tamanho; i++) {
            elements.append(info[index].toString());
            if (i < tamanho - 1) {
                elements.append(",");
            }

            index = (index + 1) % limite;
        }

        return elements.toString();
    }
}