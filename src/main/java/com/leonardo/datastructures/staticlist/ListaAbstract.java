package com.leonardo.datastructures.staticlist;

import kotlin.BuilderInference;

public abstract class ListaAbstract<T> {

    private T[] info;
    private int tamanho;
    private static final byte TAMANHO_INICIAL = 10;

    public ListaAbstract() {
        info = (T[]) new Object[TAMANHO_INICIAL];
        tamanho = 0;
    }

    public int getLimite() {
        return info.length;
    }

    public int getTamanho() {
        return tamanho;
    }

    protected void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    protected void redimensionar() {
        T[] novo = (T[]) new Object[TAMANHO_INICIAL];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }

    public abstract void inserir(T dado);

    public void exibir() {
        StringBuilder elements = new StringBuilder();
        for (int i = 0; i < getTamanho(); i++) {
            elements.append(info[i]);
            if (i < getTamanho() - 1) {
                elements.append(",");
            }
        }

        System.out.println(elements.toString());
    }

    public abstract int buscar(T info);

    public void retirar(T info) {
        int position = buscar(info);
        if (position > -1) {
            for (int i = position; i < tamanho - 1; i++) {
                this.info[i] = this.info[i + 1];
            }
        }

        this.info[tamanho - 1] = null;
        tamanho--;
    }

    public void liberar() {
        info = (T[]) new Object[TAMANHO_INICIAL];
        tamanho = 0;
    }

    public T obterElemento(int pos) {
        if (pos >= 0 && (pos < tamanho)) {
            return info[pos];
        } else {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
    }

    @Override
    public String toString() {
        StringBuilder elements = new StringBuilder();
        for (int i = 0; i < getTamanho(); i++) {
            elements.append(obterElemento(i));
            if (i < getTamanho() -1) {
                elements.append(",");
            }
        }

        return elements.toString();
    }

    protected T[] getInfo() {
        return info;
    }
}
