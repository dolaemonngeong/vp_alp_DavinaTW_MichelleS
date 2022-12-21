package com.uc.alp_vp_acleaning.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.model.Order

class OrderAdapter(private val dataSet: Order, private val dataOrder: Order) :
RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val address: TextView
        val phone: TextView
        val time: TextView
        val date: TextView
        val note: TextView

        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.input_name)
            address = view.findViewById(R.id.input_address)
            phone = view.findViewById(R.id.input_phone)
            time = view.findViewById(R.id.input_time)
            date = view.findViewById(R.id.input_date)
            note = view.findViewById(R.id.input_note)
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
                viewHolder.name.text = dataSet[position].name
                viewHolder.address.text = dataSet[position].address
                viewHolder.phone.text = dataSet[position].phone
                viewHolder.time.text = dataSet[position].time
                viewHolder.date.text = dataSet[position].date
                viewHolder.note.text = dataSet[position].note.toString()
            }

            // Return the size of your dataset (invoked by the layout manager)
            override fun getItemCount() = dataSet.size
        }

