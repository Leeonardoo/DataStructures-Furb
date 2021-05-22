package com.leonardo.datastructures.staticlist;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    @Override
    public void inserir(T dado) {
        if (getLimite() == getTamanho()) {
            redimensionar();
        }

        int position = procurarPosicaoInclusao(dado);

        if (position < getTamanho()) {
            deslocarDados(position);
        }

        Object[] info = getInfo();
        info[position] = dado;

        setTamanho(getTamanho() + 1);
    }

    private int procurarPosicaoInclusao(T item) {
        Object[] info = getInfo();
        int i;

        for (i = 0; i < getTamanho(); i++) {
            if (((Comparable) info[i]).compareTo(item) > 0) {
                break;
            }
        }

        return i;
    }

    private void deslocarDados(int position) {
        Object[] info = getInfo();
        for (int i = getTamanho() - 1; i >= position; i--) {
            info[i + 1] = info[i];
        }
    }

    @Override
    public int buscar(T item) {
        Object[] info = getInfo();

        int inicio = 0;
        int fim = getTamanho() - 1;
        int meio;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;

            int comp = item.compareTo((T) info[meio]);
            if (comp < 0) {
                fim = meio - 1;
            } else {
                if (comp > 0) {
                    inicio = meio + 1;
                } else {
                    return meio;
                }
            }
        }

        return -1;
    }


}
