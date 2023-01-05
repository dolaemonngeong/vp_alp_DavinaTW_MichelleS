package com.uc.alp_vp_acleaning.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.model.KecamatanItem1
import com.uc.alp_vp_acleaning.retrofit.FilterListener


class KecamatanAdapter(private val dataSet: ArrayList<KecamatanItem1>, val filterListener: FilterListener) :
        RecyclerView.Adapter<KecamatanAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View, val filterListener1: FilterListener) : RecyclerView.ViewHolder(view) {
        val kecButton: Button

        init {
            // Define click listener for the ViewHolder's View.
            kecButton = view.findViewById(R.id.kec_button)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
//        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.button_kecamatan, viewGroup, false)

        return ViewHolder(view, filterListener)
    }

//    override fun getItemCount(): Int = selectedItems.size
//
//    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
//        holder.bind(selectedItems[position])
//    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.kecButton.text = dataSet[position].kecamatan_name
//        dataSet[position].
        viewHolder.kecButton.setOnClickListener {
//            Toast.makeText(this, "id kec $dataSet[position].k_id", Toast.LENGTH_SHORT).show()
            filterListener.onFilterItemClicked("filKecamatan", dataSet[position].k_id)
        }
//        viewHolder.kecButton.setOnClickListener {
//            // Get the selected kecamatan ID.
//            val kecId = dataSet[position].k_id
//            // Filter the list of technicians based on the kecamatan ID.
//            val filteredTechnicians = dataKecamatan.filter { it.ke == kecId }
//            // Update the list displayed in the RecyclerView.
//            updateTechniciansList(filteredTechnicians)
//        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

//    fun updateTechniciansList(technicians: List<TechnicianItem>) {
//        // Update the list of technicians and notify the adapter.
//        dataSet.clear()
//        dataSet.addAll(technicians)
//        notifyDataSetChanged()
//    }

}
