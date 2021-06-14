package com.leonardo.datastructures.sorting;

public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        int size = getInfo().length - 1;
        mergeSort(0, size);
    }

    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, fim, meio);
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(int inicio, int fim, int meio) {
        T[] info = getInfo();

        int leftSize = meio - inicio + 1;
        T[] left = (T[]) new Comparable[leftSize];
        for (int i = 0; i <= leftSize - 1; i++) {
            left[i] = info[inicio + i];
        }

        int rightSize = fim - meio;
        T[] right = (T[]) new Comparable[rightSize];
        for (int i = 0; i <= rightSize - 1; i++) {
            right[i] = info[meio + 1 + i];
        }

        int cLeft = 0, cRight = 0;

        int i;
        for (i = inicio; i <= fim; i++) {
            if (cLeft < leftSize && cRight < rightSize) {
                if (left[cLeft].compareTo(right[cRight]) < 0) {
                    info[i] = left[cLeft];
                    cLeft++;
                } else {
                    info[i] = right[cRight];
                    cRight++;
                }
            } else {
                break;
            }
        }

        while (cLeft < leftSize) {
            info[i] = left[cLeft];
            cLeft++;
            i++;
        }

        while (cRight < rightSize) {
            info[i] = right[cRight];
            cRight++;
            i++;
        }

        setInfo(info);
    }
}
