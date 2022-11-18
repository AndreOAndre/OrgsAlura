package com.project.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.project.orgs.DataAcessObject.ProductDao
import com.project.orgs.R
import com.project.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configButtonSave()
    }

    private fun configButtonSave() {
        val dao = ProductDao()
        val buttonSave = findViewById<Button>(R.id.button_save_form)
        buttonSave.setOnClickListener {
            val produtoForm = createProducts()

            dao.share(produtoForm)
            finish()

            Log.i("ProdutoActivity", "onCreate: $produtoForm")
            //setOnClickListener ->  basicamente está falando que vamos configurar um listener de click na ação de click.
            //                       mas o que é um listener? São referências que ficam atentas a alguma ação, que nesse caso é de click.
            //                       Poderia ser outras ações, como: um click mais longo, ações que vamos scrollar, ações que vamos arrastar.

            //                      *OBS: tem duas opções de implementação. Uma delas recebe o view.onClickListener, que é uma interface,
            //                      e esse outro já vai para expressão Lambda.


            //toString() -> Essa é a forma que buscamos uma informação que está dentro de um EditText,
            //              utilizamos o EditText, chamamos o editable e em seguida o toString.

            //Log. -> é uma referência que vem do SDK do Android, e a partir dela temos acesso a alguns métodos,
            //        como é o caso do i = info, d = debug, v = verbose, e = error, w = warn,
            //        que permitem com que consigamos criar logs para nós também. Como se fosse o modo debug,
            //        como se fosse o modo só de informação, e assim por diante.

        }
    }

    private fun createProducts(): Produto {
        val pointName = findViewById<EditText>(R.id.name_form)
        val name = pointName.text.toString()

        val pointDescription = findViewById<EditText>(R.id.description_form)
        val description = pointDescription.text.toString()

        val pointValue = findViewById<EditText>(R.id.value_form)
        val valueText = pointValue.text.toString()

        val value = if (valueText.isBlank()) {      // .isBlank -> diz que é vazio, em branco.
            BigDecimal.ZERO // .ZERO -> numero próprio do BigDecimal
        } else {
            BigDecimal(valueText)
        }

        return Produto(
            name = name,
            description = description,
            value = value
        )
    }
}