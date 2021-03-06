package com.leonardo.staticlist;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ListaEstaticaGenericaKt<Integer> test = new ListaEstaticaGenericaKt<>();

        test.inserir(1);
        test.exibir();
        test.inserir(2);
        test.exibir();
        test.inserir(3);
        test.exibir();
        test.inserir(4);
        test.exibir();
        test.inserir(5);
        test.exibir();
        test.inserir(6);
        test.exibir();
        test.inserir(7);
        test.exibir();
        test.inserir(8);
        test.exibir();
        test.inserir(9);
        test.exibir();
        test.inserir(10);
        test.exibir();
        test.inserir(11);
        test.exibir();
        test.inserir(12);
        test.exibir();
        test.inserir(13);
        test.exibir();
        test.inserir(14);
        test.exibir();
        test.inserir(15);
        test.exibir();

        System.out.println(test.obterElemento(14));

        System.out.println(test.getTamanho());
        test.retirar(13);
        test.exibir();
        System.out.println(test.getTamanho());
        test.retirar(16);
    }
}
