package com.tbuffa.app.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tbuffa.app.databinding.ItemTurnoBinding
import com.tbuffa.app.model.turno

class AdaptadorTurnos(private val listaTurnos: ArrayList<turno>) : RecyclerView.Adapter<AdaptadorTurnos.ViewHolder>() {
    class ViewHolder(private val binding: ItemTurnoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(turno: turno) {
            binding.tvHistId.text = "Turno n°: ${turno.id}"
            binding.tvHistEntrenador.text = "Entrenador: ${turno.entrenador}"
            binding.tvHistTipo.text = "Tipo de entrenamiento: ${turno.tipoEntrenamiento}"
            binding.tvHistFecha.text = "Día: ${turno.dia_cita}"
            binding.tvHistHora.text = "Hora: ${turno.hora_cita}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTurnoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = listaTurnos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaTurnos[position])
    }
}
















//package com.tbuffa.app.views
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.tbuffa.app.R
//import com.tbuffa.app.databinding.ItemTurnoBinding
//import com.tbuffa.app.model.turno
//
//class AdaptadorTurnos(private val listaTurnos: ArrayList<turno>) : RecyclerView.Adapter<AdaptadorTurnos.ViewHolder>() {
//    class ViewHolder(private val binding: ItemTurnoBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(turno: turno) {
//            binding.tvHistId.text = "Cita Medica: ${turno.id}"
//            binding.tvHistEntrenador.text = turno.entrenador
//            binding.tvHistTipo.text = "Atención el día ${turno.tipoEntrenamiento}"
//            binding.tvHistFecha.text = "A las ${turno.dia_cita}"
//            binding.tvHistHora.text = "A las ${turno.hora_cita}"
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding = ItemTurnoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun getItemCount() = listaTurnos.size
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(listaTurnos[position])
//    }
//}
//
//class AdaptadorTurnos(private val listaTurnos: ArrayList<turno>) : RecyclerView.Adapter<AdaptadorTurnos.ViewHolder>() {
//    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
//        val tvHistId = itemView.binding.tvHistId
//        val tvHistEntrenador =itemView.binding.tvHistId
//        val tvHistTipo =itemView.binding.tvHistTipo
//        val tvHistFecha =itemView.binding.tvHistFecha
//        val tvHistHora=itemView.binding.tvHistHora
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.item_turno, parent, false)
//
//        )
//    }
//
//    override fun getItemCount() = listaTurnos.size
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val turno = listaTurnos[position]
//
//        holder.tvHistId.text = "Cita Medica: ${turno.id}"
//        holder.tvHistEntrenador.text = turno.entrenador
//        holder.tvHistTipo.text = "Atención el día  ${turno.tipoEntrenamiento}}"
//        holder.tvHistFecha.text = "A las ${turno.dia_cita}"
//        holder.tvHistHora.text = "A las ${turno.hora_cita}"
//
//    }
//
//
//}

//class AdaptadorTurnos(private val listaTurnos: List<turno>) :
//    RecyclerView.Adapter<AdaptadorTurnos.TurnoViewHolder>() {
//
//
//




//    inner class TurnoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val tvFechaTurno: TextView = itemView.findViewById(R.id.tvFechaTurno)
//        // Otros elementos de la vista de cada turno
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TurnoViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_turno, parent, false)
//        return TurnoViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: TurnoViewHolder, position: Int) {
//        val turno = listaTurnos[position]
//
//        // Asignar los valores del turno a los elementos de la vista
//        holder.tvFechaTurno.text = "Fecha del turno: ${turno.dia_cita}"
//        // Asignar otros valores a los elementos correspondientes
//    }
//
//    override fun getItemCount(): Int {
//        return listaTurnos.size
//    }
//}
//











//package com.tbuffa.app.views
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.tbuffa.app.R
//import com.tbuffa.app.model.turno
//
//class AdaptadorTurnos(private val listaTurnos: List<turno>) :
//    RecyclerView.Adapter<AdaptadorTurnos.TurnoViewHolder>() {
//
//    class TurnoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val tvFechaTurno: TextView = itemView.findViewById(R.id.tvFechaTurno)
//        // Puedes incluir aquí los demás elementos según la estructura del item_turno.xml
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TurnoViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_turno, parent, false)
//        return TurnoViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: TurnoViewHolder, position: Int) {
//        val turno = listaTurnos[position]
//
//        // Asignar los valores del turno a los elementos de la vista
//        holder.tvFechaTurno.text = "Fecha del turno: ${turno.dia_cita}"
//        // Asignar los demás valores a los elementos correspondientes
//    }
//
//    override fun getItemCount(): Int {
//        return listaTurnos.size
//    }
//}
