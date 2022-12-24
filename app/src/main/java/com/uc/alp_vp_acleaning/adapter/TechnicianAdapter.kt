package com.uc.alp_vp_acleaning.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonObject
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.model.Kecamatan
import com.uc.alp_vp_acleaning.model.KecamatanElement
import com.uc.alp_vp_acleaning.model.Technician
import com.uc.alp_vp_acleaning.model.TechnicianElement


class TechnicianAdapter(private val dataSet: ArrayList<TechnicianElement>, private val dataKecamatan: ArrayList<KecamatanElement>) :
        RecyclerView.Adapter<TechnicianAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val rating: TextView
        val kecamatan: TextView

        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.tech_dn)
            rating = view.findViewById(R.id.tech_rating)
            kecamatan = view.findViewById(R.id.tech_district)

            //kl gk bs pk (datakecamatan.size-1)
            for (i in 0 until dataKecamatan.size){
                if(dataSet[adapterPosition].kecamatanID == dataKecamatan[i].kID){
                    val a = dataKecamatan[adapterPosition].kecamatanName
                    kecamatan.text = a
                }
            }
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
        viewHolder.name.text = dataSet[position].tName
        viewHolder.rating.text = dataSet[position].rate.toString()
//        viewHolder.kecamatan.text = dataSet[position].kecamatanID

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
