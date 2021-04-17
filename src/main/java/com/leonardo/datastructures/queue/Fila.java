package com.leonardo.datastructures.queue;

public interface Fila<T> {

    void inserir(T value);

    boolean estaVazia();

    T peek();

    T retirar();

    void liberar();
}
