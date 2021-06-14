package com.leonardo.datastructures.sorting;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        int n = getInfo().length - 1;
        quickSort(0, n);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int index = particionar(inicio, fim);
            quickSort(inicio, index - 1);
            quickSort(index + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        int a = inicio;
        int b = fim + 1;
        T pivot = getInfo()[inicio];

        while (true) {
            do {
                a++;
            } while (a <= fim && getInfo()[a].compareTo(pivot) < 0);

            do {
                b--;
            } while (b >= inicio && getInfo()[b].compareTo(pivot) > 0);

            if (a >= b) {
                break;
            }

            trocar(a, b);
        }

        trocar(b, inicio);
        return b;
    }
}
