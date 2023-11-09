package com.tbuffa.app.model

import java.io.Serializable

data class Entrenador(
    val nombre: String,
    val especialidad: String,
    val nivel:String,
    val telefono:String,
    val horarioDisponibilidad: List<String>
): Serializable
