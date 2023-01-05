package com.uc.alp_vp_acleaning.view

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.adapter.OrderAdapter
import com.uc.alp_vp_acleaning.adapter.OrderTechAdapter
import com.uc.alp_vp_acleaning.adapter.TechnicianAdapter
import com.uc.alp_vp_acleaning.databinding.FragmentTechnicianHomeBinding
import com.uc.alp_vp_acleaning.model.Technician
import com.uc.alp_vp_acleaning.model.Order
import com.uc.alp_vp_acleaning.view.MainActivity.Companion.loginTechId
import com.uc.alp_vp_acleaning.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TechnicianHomeFragment : Fragment() {

    private lateinit var binding: FragmentTechnicianHomeBinding
    private lateinit var viewModelTechOrder: OrderViewModel
    private lateinit var adapterTechOrder: OrderTechAdapter
    private lateinit var adapterTechnician: TechnicianAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTechnicianHomeBinding.inflate(layoutInflater)
//        binding.nmTechWelcome.text =
        var status = ""
        notif()
        binding.pendingRb.setOnClickListener {
            status = "pending"
            Toast.makeText(context, "ini pending", Toast.LENGTH_SHORT).show()
            filter(status)


        }
        binding.ongoingRb.setOnClickListener {
            status = "on-going"
            Toast.makeText(context, "ini ongoing", Toast.LENGTH_SHORT).show()
            filter(status)
        }
        binding.completedRb.setOnClickListener {
            status = "completed"
            Toast.makeText(context, "ini completed", Toast.LENGTH_SHORT).show()
            filter(status)
        }

        return binding.root
    }

    fun filter(status: String) {
        viewModelTechOrder =
            ViewModelProvider(this@TechnicianHomeFragment).get(OrderViewModel::class.java)

        viewModelTechOrder.getOrderCustomerStatusData(loginTechId, status)

        viewModelTechOrder.order.observe(viewLifecycleOwner, Observer { response ->
//            Log.e("Customer Order", response)
            if (response.isEmpty()) {
                Toast.makeText(context, "order masih kosong", Toast.LENGTH_SHORT).show()
            } else {
                binding.listOrder.layoutManager = LinearLayoutManager(context)
                adapterTechOrder = OrderTechAdapter(response)
                binding.listOrder.adapter = adapterTechOrder
            }
        })
    }

    fun notif() {
        AlertDialog.Builder(context).setMessage("You have new order(s)")
            .setPositiveButton("") { dialog, id ->
                dialog.dismiss()
//                adapter.notifyDataSetChanged()

//                val snackBar = Snackbar.make(viewBind.root, "Hewan telah dihapus", Snackbar.LENGTH_SHORT)
            }
            .setNegativeButton("Tidak") { dialog, id ->

                dialog.dismiss()
            }.create().show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        onRadioButtonChecked(R.id.rgStatus, )

    }

//    fun onRadioButtonChecked(group: RadioGroup, checkedId: Int) {
//        when(checkedId) {
//            R.id.pending_rb -> {
//                Toast.makeText(context, "ini pending", Toast.LENGTH_SHORT).show()
//            }
//            R.id.ongoing_rb -> {
//                Toast.makeText(context, "ini ongoing", Toast.LENGTH_SHORT).show()
//            }
//            R.id.completed_rb -> {
//                Toast.makeText(context, "ini completed", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

}