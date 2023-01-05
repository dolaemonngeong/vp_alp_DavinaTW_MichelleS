package com.uc.alp_vp_acleaning.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.model.Kecamatan
import com.uc.alp_vp_acleaning.model.Order
import com.uc.alp_vp_acleaning.model.OrderItem
import com.uc.alp_vp_acleaning.model.Technician
import com.uc.alp_vp_acleaning.view.OrderDetailActivity
import com.uc.alp_vp_acleaning.view.TechnicianDetailActivity

class OrderAdapter(private val dataSet: ArrayList<OrderItem>) :
RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val status: TextView
        val time: TextView
        val date: TextView
        val card: CardView
        val btnCon : Button

        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.tech_order)
            status = view.findViewById(R.id.order_status)
            time = view.findViewById(R.id.order_time)
            date = view.findViewById(R.id.order_date)
            card = view.findViewById(R.id.order_cust)
            btnCon = view.findViewById(R.id.btn_confirm)
        }
    }
            override fun onCreateViewHolder(
                viewGroup: ViewGroup,
                viewType: Int
            ): OrderAdapter.ViewHolder {
                // Create a new view, which defines the UI of the list item
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.card_orders_customer, viewGroup, false)

                return ViewHolder(view)
            }



            // Replace the contents of a view (invoked by the layout manager)
            override fun onBindViewHolder(viewHolder: OrderAdapter.ViewHolder, position: Int) {

                // Get element from your dataset at this position and replace the
                // contents of the view with that element
                viewHolder.name.text = dataSet[position].Technician.t_name
                viewHolder.time.text = dataSet[position].time
                viewHolder.date.text = dataSet[position].date
                viewHolder.status.text = dataSet[position].status

                if(viewHolder.status.text != "On-going"){
                    viewHolder.btnCon.isVisible = false
                }
                viewHolder.card.setOnClickListener {
                    val intent = Intent(it.context, OrderDetailActivity::class.java)
                    intent.putExtra("o_id", dataSet[position].o_id)
                    it.context.startActivity(intent)
                }

                viewHolder.btnCon.setOnClickListener {

                }
            }

            // Return the size of your dataset (invoked by the layout manager)
            override fun getItemCount() = dataSet.size
        }

