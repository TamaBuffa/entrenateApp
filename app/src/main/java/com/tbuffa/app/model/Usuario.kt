package com.tbuffa.app.model
import java.io.Serializable

data class Usuario(
    var id: Long,
    var nombre: String,
    var apellido: String,
    var email: String,
    var password: String,
    var rutaFoto: String? // Nueva propiedad para almacenar la ruta de la imagen
) : Serializable