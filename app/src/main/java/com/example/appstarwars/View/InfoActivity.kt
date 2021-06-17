package com.example.appstarwars.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appstarwars.R
import com.example.appstarwars.Service.Constantes.Constantes.Companion.BIRTHEY_COLOR
import com.example.appstarwars.Service.Constantes.Constantes.Companion.EYE_COLOR
import com.example.appstarwars.Service.Constantes.Constantes.Companion.HAIR_COLOR
import com.example.appstarwars.Service.Constantes.Constantes.Companion.KEY_GENDER
import com.example.appstarwars.Service.Constantes.Constantes.Companion.KEY_HEIGHT
import com.example.appstarwars.Service.Constantes.Constantes.Companion.KEY_MASS
import com.example.appstarwars.Service.Constantes.Constantes.Companion.KEY_NAME
import com.example.appstarwars.Service.Constantes.Constantes.Companion.SKIN_COLOR
import kotlinx.android.synthetic.main.person_deitals.*

class InfoActivity : AppCompatActivity() {
    private val nam by lazy { intent.extras?.getString(KEY_NAME) }
    private val height by lazy { intent.extras?.getString(KEY_HEIGHT) }
    private val masss by lazy { intent.extras?.getString(KEY_MASS) }
    private val gende by lazy { intent.extras?.getString(KEY_GENDER) }
    private val hair by lazy { intent.extras?.getString(HAIR_COLOR) }
    private val eye by lazy { intent.extras?.getString(EYE_COLOR) }
    private val skin by lazy { intent.extras?.getString(SKIN_COLOR) }
    private val birthey by lazy { intent.extras?.getString(BIRTHEY_COLOR) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.person_deitals)

        personInfo()


    }

    private fun personInfo(){
        name.text = nam
        heigth.text = height
        mass.text = masss
        gender.text = gende
        hair_color.text = hair
        eye_color.text = eye
        skin_color.text = skin
        birth_year.text = birthey
    }
}