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

    public void realocarMapa(int novoTamanho) {
        ListaEncadeada<NoMapa<T>>[] tmp = info;

        info = new ListaEncadeada[novoTamanho];

        for (int i = 0; i < tmp.length-1; i++) {
            if (tmp[i] != null) {
                int size = tmp[i].obterComprimento();

                for (int j = 0; j < size; j++) {
                    NoLista<NoMapa<T>> item = tmp[i].obterNo(j);

                    if (item.getInfo() != null) {
                        inserir(item.getInfo().getChave(), item.getInfo().getInfo());
                    }

                    while (item.getProximo() != null) {
                        item = item.getProximo();
                        inserir(item.getInfo().getChave(), item.getInfo().getInfo());
                    }
                }
            }
        }
    }
}
