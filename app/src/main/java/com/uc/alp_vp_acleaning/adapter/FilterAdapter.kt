//package com.uc.alp_vp_acleaning.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.core.content.ContextCompat
//import androidx.recyclerview.widget.RecyclerView
//import com.uc.alp_vp_acleaning.R
//import com.uc.alp_vp_acleaning.retrofit.FilterClickListener
////import com.uc.alp_vp_acleaning.view.KecamatanButton
//
//class FilterAdapter (private val kecamatan: ArrayList<String>,
//                     private val listener: FilterClickListener
//) :
//    RecyclerView.Adapter<FilterAdapter.DataViewHolder>(){
//    class DataViewHolder(itemView: View) :
//        RecyclerView.ViewHolder(itemView) {
//        fun bind(filter: String) {
//            itemView.apply {
////                kec_button.text = filter
//            }
//        }
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
//            DataViewHolder =
//            DataViewHolder(
//            LayoutInflater.from(parent.context)
//            .inflate(R.layout.button_kecamatan, parent, false))
//
////    override fun getItemCount(): Int = filters.size
//
//    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
////        val filter = filters[position]
////        holder.bind(filter)
////        holder.itemView.apply {
////            kec_button.setOnClickListener {
////                it.isSelected = !it.isSelected
////                if(it.isSelected) {
////                    it.background =
////                        holder.itemView.context
////                            .getDrawable(R.drawable.ic_rounded_rectangle_unselected)
////                    kec_button.setTextColor(ContextCompat.getColor(this.context,R.color.black))
////                } else {
////                    it.background =
////                        holder.itemView.context
////                            .getDrawable(R.drawable.ic_rounded_rectangle_selected)
////                    kec_button.setTextColor(ContextCompat.getColor(this.context,R.color.white))
////                }
////                listener.onFilterItemClicked(filter, it.isSelected)
//            }
//
//        }
//    }
//}