package com.project.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.orgs.R
import com.project.orgs.model.Produto

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>

) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val products = produtos.toMutableList()
    //                             .toMutableList() ->

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(produto: Produto) {

            val name = itemView.findViewById<TextView>(R.id.name)
                name.text = produto.name

            val description = itemView.findViewById<TextView>(R.id.description)
                description.text = produto.description

            val value = itemView.findViewById<TextView>(R.id.value)
            value.text = produto.value.toPlainString()
        }
    }

    // onCreateViewHolder --> cria a referencia de viewHolder - responsável por pegar cada uma da view e fazer o processo de vinculação
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // Inflater -->  metodo usado para "inflar" a view
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item, parent, false)

        return ViewHolder(view)
    }

    //onBindViewHolder --> metodo que indica qual o item que estamos no adapter. e indicar o indice/a posição e qual o viewHolder estamos
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = products[position]
        holder.vincula(produto)
    }

    //getItemCount --> getItemCount determina quantos itens queremos apresentar dentro do adapter
    override fun getItemCount(): Int = products.size

    fun atualiza(products: List<Produto>) {
    this.products.clear()
    this.products.addAll(products)
    notifyDataSetChanged()
    }
}
