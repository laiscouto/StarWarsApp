package com.example.appstarwars.Service.Constantes

import com.google.gson.annotations.SerializedName

class Constantes private constructor() {

    object HTTP {
        const val SUCCESS = 200
    }
    companion object {
        const val KEY_NAME = "name"
        const val KEY_HEIGHT = "neight"
        const val KEY_MASS = "mass"
        const val KEY_GENDER = "gender"
        const val HAIR_COLOR = "hair"
        const val SKIN_COLOR = "skin"
        const val EYE_COLOR = "eye"
        const val BIRTHEY_COLOR = "BIRTHEY"

    }

}