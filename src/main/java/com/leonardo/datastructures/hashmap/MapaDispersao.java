package com.leonardo.datastructures.hashmap;

import com.leonardo.datastructures.chained.ListaEncadeada;
import com.leonardo.datastructures.chained.NoLista;

public class MapaDispersao<T> {

    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        info = new ListaEncadeada[tamanho];
    }

    private int calcularHash(int key) {
        return (key % info.length);
    }

    public void inserir(int key, T dado) {
        int indice = calcularHash(key);

        if (info[indice] == null) {
            info[indice] = new ListaEncadeada<>();
        }

        NoMapa<T> no = new NoMapa<>();
        no.setChave(key);
        no.setInfo(dado);

        info[indice].inserir(no);
    }

    public void remover(int key) {
        int indice = calcularHash(key);

        if (info[indice] != null) {
            NoMapa<T> no = new NoMapa<>();
            no.setChave(key);
            info[indice].retirar(no);
        }
    }

    public T buscar(int key) {
        int indice = calcularHash(key);

        if (info[indice] != null) {
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(key);

            NoLista<NoMapa<T>> no = info[indice].buscar(noMapa);
            if (no != null) {
                return no.getInfo().getInfo();
            }
        }

        return null;
    }
}
