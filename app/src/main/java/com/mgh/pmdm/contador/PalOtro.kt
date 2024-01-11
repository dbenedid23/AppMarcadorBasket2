package com.mgh.pmdm.contador


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class PalOtro : AppCompatActivity() {
    var contadorLocal = 0
    var contadorVisitante = 0
    var personalesLocal = 0
    var personalesVisitantes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pal_otro)

        val textViewContadorLocal = findViewById<TextView>(R.id.textViewContadorLocal)
        val textViewContadorVisitante = findViewById<TextView>(R.id.textViewContadorVisitante)
        val textViewPersonalesLocal = findViewById<TextView>(R.id.textViewPersonalesLocal)
        val textViewPersonalesVisitantes = findViewById<TextView>(R.id.textViewPersonalesVisitantes)

        // Recuperar datos guardados en SharedPreferences
        val sharedPreferences = getSharedPreferences("DatosLocales", Context.MODE_PRIVATE)
        contadorLocal = sharedPreferences.getInt("contadorLocal", 0)
        contadorVisitante = sharedPreferences.getInt("contadorVisitante", 0)
        personalesLocal = sharedPreferences.getInt("personalesLocal", 0)
        personalesVisitantes = sharedPreferences.getInt("personalesVisitantes", 0)

        // Inicializamos los TextViews con los valores guardados
        textViewContadorLocal.text = contadorLocal.toString()
        textViewContadorVisitante.text = contadorVisitante.toString()
        textViewPersonalesLocal.text = personalesLocal.toString()
        textViewPersonalesVisitantes.text = personalesVisitantes.toString()

        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val buttonRestarPerAtaque = findViewById<Button>(R.id.buttonRestarPerAtaque)
        val buttonRestarPerVisitante = findViewById<Button>(R.id.buttonRestarPerVisitante)
        val buttonResetPersonales = findViewById<Button>(R.id.buttonResetPersonales)
        val buttonPerDefensa = findViewById<Button>(R.id.buttonPerDefensa)
        val buttonPerAtaque = findViewById<Button>(R.id.buttonPerAtaque)
        val buttonResetAll = findViewById<Button>(R.id.buttonResetAll)
        val buttonCambio = findViewById<Button>(R.id.buttonCambio)

        button.setOnClickListener {
            contadorVisitante++
            textViewContadorVisitante.text = contadorVisitante.toString()
        }

        button2.setOnClickListener {
            contadorVisitante += 2
            textViewContadorVisitante.text = contadorVisitante.toString()
        }

        button3.setOnClickListener {
            contadorVisitante += 3
            textViewContadorVisitante.text = contadorVisitante.toString()
        }

        button4.setOnClickListener {
            if (contadorVisitante > 0) {
                contadorVisitante--
                textViewContadorVisitante.text = contadorVisitante.toString()
            }
        }

        buttonRestarPerAtaque.setOnClickListener {
            if (personalesLocal > 0) {
                personalesLocal--
                textViewPersonalesLocal.text = personalesLocal.toString()
            }
        }

        buttonRestarPerVisitante.setOnClickListener {
            if (personalesVisitantes > 0) {
                personalesVisitantes--
                textViewPersonalesVisitantes.text = personalesVisitantes.toString()
            }
        }

        buttonResetPersonales.setOnClickListener {
            personalesLocal = 0
            personalesVisitantes = 0
            textViewPersonalesLocal.text = personalesLocal.toString()
            textViewPersonalesVisitantes.text = personalesVisitantes.toString()
        }

        buttonPerAtaque.setOnClickListener {
            if(personalesVisitantes < 5 ){
                personalesVisitantes++
                textViewPersonalesVisitantes.text = personalesVisitantes.toString()
            }

        }

        buttonPerDefensa.setOnClickListener {
            if(personalesLocal < 5){
                personalesLocal++
                textViewPersonalesLocal.text = personalesLocal.toString()
            }

        }

        buttonResetAll.setOnClickListener {
            contadorLocal = 0
            contadorVisitante = 0
            personalesLocal = 0
            personalesVisitantes = 0
            textViewContadorLocal.text = contadorLocal.toString()
            textViewContadorVisitante.text = contadorVisitante.toString()
            textViewPersonalesLocal.text = personalesLocal.toString()
            textViewPersonalesVisitantes.text = personalesVisitantes.toString()
        }

        buttonCambio.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putInt("contadorLocal", contadorLocal)
            editor.putInt("contadorVisitante", contadorVisitante)
            editor.putInt("personalesLocal", personalesLocal)
            editor.putInt("personalesVisitantes", personalesVisitantes)
            editor.apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
