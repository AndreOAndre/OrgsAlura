package com.project.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.orgs.DataAcessObject.ProductDao
import com.project.orgs.R
import com.project.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

//SEMPRE  que criarmos uma ACTIVITY do zero, é nescessário relatar no AndroidManifest.xml
class ListProductsActivity : AppCompatActivity(R.layout.activity_list_products) {

    private val dao = ProductDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.take())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Bem vindo(a) ao Orgs!", Toast.LENGTH_SHORT).show()
        // Toast > mostra uma msg PopUp ao iniciar o app'''


    }

    override fun onResume() {
//        onResume -> https://developer.android.com/reference/android/app/Activity#activity-lifecycle
        super.onResume()
        adapter.atualiza(dao.take())
        ConfigRecyclerView()
        ConfigFab()
    }


    private fun ConfigFab() {
        //  CONFIGURAÇÃO DO BOTÃO DE AÇÃO
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)


            //Intent -> O Intent é um objeto de mensagem que pode ser usado
            //              para solicitar uma ação de outro componente do aplicativo.
            //              Embora os intents facilitem a comunicação entre os componentes de diversas formas.
            //              Neste caso vamos criar uma intenção para acessar nossa outra activity.

            //startActivity -> faz parte do intent, para iniciar a activity através dele

            //packageContext -> usa o próprio context e uma referência de classe.
            //                  Basicamente mandamos o contexto -> que é nossa própria activity -> a partir do this
            //                  e esse outro que é a referência da classe é a classe da activity que nós queremos.
            //                  Nesse caso, vai ser formularioProdutoActivity::class.java
            //                  OBS= ::class.java-> é assim que fazemos a referência de classes
            //                  utilizando o Android a partir da intent.

        }
    }
    private fun ConfigRecyclerView() {
        // CONFIGURAÇÃO DA LISTA DE PRODUTOS
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
    }
}