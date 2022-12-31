package com.uc.alp_vp_acleaning.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.databinding.FragmentCustomerHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TechnicianHomeFragment : Fragment() {

    private lateinit var binding : FragmentCustomerHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCustomerHomeBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
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