package com.leonardo.staticlist

class ListaEstaticaGenericaKt<T> {

    @Suppress("UNCHECKED_CAST")
    private var info = Array<Any>(10) {} as Array<T>
    var tamanho = 0
        private set

    @Suppress("UNCHECKED_CAST")
    private fun redimensionar() {
        val oldArr = info
        info = Array<Any>(oldArr.size + 10) {} as Array<T>

        oldArr.forEachIndexed { index, i ->
            info[index] = i
        }
    }

    fun inserir(item: T) {
        if (tamanho == info.size) {
            redimensionar()
        }
        //Zero-indexed
        info[tamanho] = item
        tamanho++
    }

    fun exibir() {
        println(this.toString())
    }

    fun buscar(item: T): Int {
        for (i in 0 until tamanho - 1) {
            if (obterElemento(i) == item) {
                return i
            }
        }
        return -1
    }

    fun retirar(item: T) {
        val index = buscar(item)
        if (index != -1) {
            for (i in index until tamanho - 1) {
                info[i] = info[i + 1]
            }
            tamanho--
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun liberar() {
        info = Array<Any>(10) {} as Array<T>
        tamanho = 0
    }

    fun obterElemento(position: Int): T {
        //Zero-indexed
        if (position > tamanho - 1 || position < 0) {
            throw IndexOutOfBoundsException("Trying to access an index out the bounds of the current items on the list! Requested index was $position while the size is $tamanho")
        }
        return info[position]
    }

    fun estaVazia() = tamanho == 0

    fun inverter() {
        for (i in 0 until tamanho / 2) {
            val temp = info[i]
            val farIndex: Int = tamanho - 1 - i //Zero-indexed
            info[i] = info[farIndex]
            info[farIndex] = temp
        }
    }

    override fun toString(): String {
        val elements = StringBuilder()
        for (i in 0 until tamanho) {
            elements.append(obterElemento(i).toString())
            if (i < tamanho - 1) {
                elements.append(",")
            }
        }
        return elements.toString()
    }
}