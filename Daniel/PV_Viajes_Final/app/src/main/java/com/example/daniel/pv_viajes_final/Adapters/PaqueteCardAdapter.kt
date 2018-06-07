package com.example.daniel.pv_viajes_final.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.daniel.pv_viajes_final.DataModel.Paquete
import com.example.daniel.pv_viajes_final.R

class PaqueteCardAdapter(context: Context,resource: Int,list: ArrayList<Paquete>): ArrayAdapter<Paquete>(context,resource,list) {

    private var mResource: Int=0
    private var mList :ArrayList<Paquete>
    private var mFlayoutInflator :LayoutInflater
    private var mContext:Context=context
    init {
        this.mResource=resource
        this.mList=list
        this.mFlayoutInflator=mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
       val returnView:View?
        if (convertView==null){

            returnView = try {
                mFlayoutInflator.inflate(mResource,null)

            }catch (e: Exception){
                e.printStackTrace()
                View(context)

            }
            setUI(returnView,position)
            return returnView
        }
        setUI(convertView,position)
        return convertView
    }

    private fun setUI(view: View,position: Int){
        val paquete:Paquete?=if (count>position) getItem(position) else null

        try {
            val Paquetedestino:TextView? = view.findViewById(R.id.Destino1)



            Paquetedestino?.text=paquete?.v_Destino?:""

            val Costo:TextView? = view.findViewById(R.id.Costoso1)
            Costo?.text=paquete?.v_Precio?:""

            val Dias:TextView?=view.findViewById(R.id.Duraciones1)
            Dias?.text=paquete?.v_Dias?:""


        }catch (e:Exception){
            e.printStackTrace()

        }




    }

}