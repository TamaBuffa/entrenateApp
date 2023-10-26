//package com.tbuffa.app
//
//import android.content.Context
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ArrayAdapter
//import android.widget.BaseAdapter
//import android.widget.GridView
//import android.widget.ImageView
//import android.widget.TextView
//import com.tbuffa.app.databinding.ActivityEntrenaBinding
//import com.tbuffa.app.databinding.ActivityGrillaEntrenaBinding
//import java.text.FieldPosition
//
//
//class grillaEntrenaActivity : AppCompatActivity() {
//
//    lateinit var binding: ActivityGrillaEntrenaBinding
//
////    var grillaitem_lista= ArrayList<grilla_item>()
////    var name= arrayOf("abdominales", "pecho", "brazo", "piernas", "hombros y espaldas")
////    var image= intArrayOf(R.drawable.abdominales,R.drawable.pecho,R.drawable.brazos,R.drawable.piernas,R.drawable.hombro_espalda)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityGrillaEntrenaBinding.inflate(layoutInflater)
//        setContentView(binding.root)
////
//        for(i in name.indices){
//            grillaitem_lista.add(grilla_item(name[i], image[i]))
//        }
//
//        var customAdapter=CustomAdapter(grillaitem_lista,this)
//        GridView.adapter=customAdapter
//
//    }
//
//        class CustomAdapter (
//            var itemgrilla: ArrayList<grilla_item>,
//            var context: Context
//        ):BaseAdapter() {
//
//            var layoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
//            override fun getCount(): Int {
//               return itemgrilla.size
//            }
//
//            override fun getItem(p0: Int): Any {
//                return itemgrilla[p0]
//            }
//
//            override fun getItemId(p0: Int): Long {
//                return p0.toLong()
//            }
//
//            override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
//                var view=view
//                if(view==null){
//                    view=layoutInflater.inflate(R.layout.grilla_datos,viewGroup,false   )
//                }
//
//                var tvImageName=view?.findViewById<TextView>(R.id.imageName)
//                var imageView=view?.findViewById<ImageView>(R.id.imageView)
//
//                tvImageName?.text= itemgrilla[position].name
//                imageView?.setImageResource(itemgrilla[position].image!!)
//                return view!!
//            }
//        }
//
//


//    }
//}
//
//

