package com.tbuffa.app

import java.io.Serializable

data class detalleUsuarios(
    val id: Int,
    var nombre: String,
    var apellido: String,
    var email: String,
    val password:String,
    val reppass: String,
):Serializable

