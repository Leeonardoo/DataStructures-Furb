package com.leonardo.datastructures.staticlist;

public class ListaEstaticaGenerica<T> extends ListaAbstract<T> {

    public void inserir(T item) {
        if (getTamanho() == getLimite()) {
            redimensionar();
        }

        T[] info = getInfo();
        info[getTamanho()] = item;
        setTamanho(getTamanho() + 1);
    }

    public int buscar(T item) {
        T[] info = getInfo();

        for (int i = 0; i < getTamanho() - 1; i++) {
            if (info[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean estaVazia() {
        return getTamanho() == 0;
    }

    public void inverter() {
        T[] info = getInfo();

        for (int i = 0; i < getTamanho() / 2; i++) {
            T temp = info[i];
            int farIndex = getTamanho() - 1 - i; //Zero-indexed
            info[i] = info[farIndex];
            info[farIndex] = temp;
        }
    }
}