package com.uc.alp_vp_acleaning.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.model.Kecamatan
import com.uc.alp_vp_acleaning.model.Order
import com.uc.alp_vp_acleaning.model.OrderItem
import com.uc.alp_vp_acleaning.model.Technician
import com.uc.alp_vp_acleaning.view.OrderDetailActivity
import com.uc.alp_vp_acleaning.view.TechnicianDetailActivity

class OrderTechAdapter(private val dataSet: ArrayList<OrderItem>) :
    RecyclerView.Adapter<OrderTechAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val address: TextView
        val time: TextView
        val date: TextView
        val card: CardView

        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.tech_order)
            address = view.findViewById(R.id.cust_address)
            time = view.findViewById(R.id.order_time)
            date = view.findViewById(R.id.order_date)
            card = view.findViewById(R.id.t_order)
        }
    }
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): OrderTechAdapter.ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_orders_technician, viewGroup, false)

        return ViewHolder(view)
    }



    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: OrderTechAdapter.ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.name.text = dataSet[position].name
        viewHolder.address.text = dataSet[position].address
        viewHolder.time.text = dataSet[position].time
        viewHolder.date.text = dataSet[position].date
        viewHolder.card.setOnClickListener {
            val intent = Intent(it.context, OrderDetailActivity::class.java)
            intent.putExtra("o_id", dataSet[position].the0_id)
            it.context.startActivity(intent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}

