package com.leonardo.datastructures.hashmap;

import com.leonardo.datastructures.staticlist.ListaEstaticaGenerica;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class MapaDispersaoTest {

    @Test
    @DisplayName("should add and be able to locate back")
    public void testAddAndLocate() {
        MapaDispersao<Aluno> testMap = new MapaDispersao<>(53);

        var obj1 = new Aluno(12000, "Jean", LocalDate.parse("2000-01-01"));
        testMap.inserir(12000, obj1);

        assertEquals(obj1, testMap.buscar(12000));
    }

    @Test
    @DisplayName("Should be able to locate a few items")
    public void testLocate() {
        MapaDispersao<Aluno> testMap = new MapaDispersao<>(53);

        var obj1 = new Aluno(12000, "Jean", LocalDate.parse("2000-01-01"));
        var obj2 = new Aluno(14000, "Pedro", LocalDate.parse("1999-01-20"));
        var obj3 = new Aluno(12500, "Marta", LocalDate.parse("2001-02-18"));
        var obj4 = new Aluno(13000, "Lucas", LocalDate.parse("1998-11-25"));

        testMap.inserir(12000, obj1);
        testMap.inserir(14000, obj2);
        testMap.inserir(12500, obj3);
        testMap.inserir(13000, obj4);

        assertEquals(obj1, testMap.buscar(12000));
        assertEquals(obj2, testMap.buscar(14000));
        assertEquals(obj3, testMap.buscar(12500));
        assertEquals(obj4, testMap.buscar(13000));
    }

    @Test
    @DisplayName("Should be able to handle key collision")
    public void testKeyCollision() {
        MapaDispersao<Aluno> testMap = new MapaDispersao<>(53);

        var obj1 = new Aluno(12500, "Jean", LocalDate.parse("2000-01-01"));
        var obj2 = new Aluno(14000, "Pedro", LocalDate.parse("1999-01-20"));
        var obj3 = new Aluno(14226, "Marta", LocalDate.parse("2001-02-18"));
        var obj4 = new Aluno(17180, "Lucas", LocalDate.parse("1998-11-25"));

        testMap.inserir(12500, obj1);
        testMap.inserir(14000, obj2);
        testMap.inserir(14226, obj3);
        testMap.inserir(17180, obj4);

        assertEquals(obj1, testMap.buscar(12500));
        assertEquals(obj2, testMap.buscar(14000));
        assertEquals(obj3, testMap.buscar(14226));
        assertEquals(obj4, testMap.buscar(17180));
    }
}
