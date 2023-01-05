package com.uc.alp_vp_acleaning.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.model.*
import com.uc.alp_vp_acleaning.view.TechnicianDetailActivity


class TechnicianAdapter(private val dataSet: ArrayList<TechnicianItem>) :
        RecyclerView.Adapter<TechnicianAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val rating: TextView
        val kecamatan: TextView
        val card: CardView

        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.tech_dn)
            rating = view.findViewById(R.id.tech_rating)
            kecamatan = view.findViewById(R.id.tech_district)
            card = view.findViewById(R.id.theCard)

            //kl gk bs pk (datakecamatan.size-1)
//            for (i in 0 until dataKecamatan.size){
//                if(dataSet[adapterPosition].kecamatan_id == dataKecamatan[i].k_id){
//                    val a = dataKecamatan[adapterPosition].kecamatan_name
//                    kecamatan.text = a
//                }
//            }

//            for (i in 0 until dataKecamatan.size){
//                if(dataSet[adapterPosition].kecamatan_id == dataKecamatan[i].k_id){
//                    kecamatan.text = dataKecamatan[i].kecamatan_name
//                }
//            }

        }

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.card_technician, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.name.text = dataSet[position].t_name
        viewHolder.rating.text = dataSet[position].rate.toString()
        viewHolder.kecamatan.text = dataSet[position].Kecamatan.kecamatan_name
        viewHolder.card.setOnClickListener {
            val intent = Intent(it.context, TechnicianDetailActivity::class.java)
            intent.putExtra("t_id", dataSet[position].t_id)
            it.context.startActivity(intent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

//    fun getKecamatanName(kecamatanId: Int): String {
//        for (i in 0 until dataKecamatan.size) {
//            if (kecamatanId == dataKecamatan[i].k_id) {
//                return dataKecamatan[i].kecamatan_name
//            }
//        }
//        return "" // return an empty string if kecamatan_name is not found
//    }

}
