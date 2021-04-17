package com.leonardo.datastructures;

import com.leonardo.datastructures.staticlist.ListaEstaticaProva;

public class Test {

    public static void main(String[] args) {
        ListaEstaticaProva lista = new ListaEstaticaProva();

        lista.inserir(20);
        lista.inserir(25);
        lista.inserir(30);

        lista.inserir(22);

        System.out.println("");
    }
}
