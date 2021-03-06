package com.leonardo.staticlist

class ListaEstaticaKt {

    private var info = IntArray(10) //Empty
    var tamanho = 0
        private set

    private fun redimensionar() {
        val oldArr = info
        info = IntArray(oldArr.size + 10)

        oldArr.forEachIndexed { index, i ->
            info[index] = i
        }
    }

    fun inserir(value: Int) {
        if (tamanho == info.size) {
            redimensionar()
        }
        //Zero-indexed
        info[tamanho] = value
        tamanho++
    }

    fun exibir() {
        println(this.toString())
    }

    fun buscar(value: Int): Int {
        for (i in 0 until tamanho - 1) {
            if (obterElemento(i) == value) {
                return i
            }
        }
        return -1
    }

    fun retirar(value: Int) {
        val index = buscar(value)
        if (index != -1) {
            for (i in index until tamanho - 1) {
                info[i] = info[i + 1]
            }
            tamanho--
        }
    }

    fun liberar() {
        info = IntArray(10)
        tamanho = 0
    }

    fun obterElemento(position: Int): Int {
        //Zero-indexed
        if (position > tamanho - 1 || position < 0) {
            throw IndexOutOfBoundsException("Trying to access an index out the bounds of the current items on the list! Requested index was $position while the size is $tamanho")
        }
        return info[position]
    }

    fun estaVazia() = tamanho == 0

    override fun toString(): String {
        val elements = StringBuilder()
        for (i in 0 until tamanho) {
            elements.append(obterElemento(i))
            if (i < tamanho - 1) {
                elements.append(",")
            }
        }
        return elements.toString()
    }
}