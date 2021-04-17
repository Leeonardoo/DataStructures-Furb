package com.leonardo.datastructures.queue;

import com.leonardo.datastructures.chained.ListaEncadeada;

public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> lista = new ListaEncadeada<>();

    @Override
    public void inserir(T value) {
        lista.inserirNoFinal(value);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException("Trying to peek into a empty queue.");
        }

        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        T value = peek();
        lista.retirar(value);

        return value;
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}