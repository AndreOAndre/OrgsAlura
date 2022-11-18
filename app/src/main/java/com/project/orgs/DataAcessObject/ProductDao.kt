package com.project.orgs.DataAcessObject

import com.project.orgs.model.Produto

class ProductDao {

    companion object {
        private val produtos = mutableListOf<Produto>()
    }

    fun share(produto: Produto) {
        produtos.add(produto)

    }

    fun take(): List<Produto> {
        return produtos.toList()
    }


}