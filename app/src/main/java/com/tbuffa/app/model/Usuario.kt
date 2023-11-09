package com.tbuffa.app.model

import java.io.Serializable
import java.sql.Blob
import java.sql.Date

data class Usuario(
    var id: Long,
    var nombre: String,
    var apellido: String,
    var email: String,
    var password:String,

//    val photoPath: String
//    var imagenPerfil:Blob,
//    var fechnac:Date
//    var reppass:String,

):Serializable

