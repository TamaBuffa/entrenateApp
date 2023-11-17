package com.tbuffa.app.model

import java.io.Serializable
import java.util.Date

data class turno(
    var id: Long,
    var emailUsuario: String, // Nuevo campo para almacenar el ID del usuario
    var tipoEntrenamiento: String,
    var entrenador: String,
    var dia_cita:String,
    var hora_cita: String
) : Serializable


