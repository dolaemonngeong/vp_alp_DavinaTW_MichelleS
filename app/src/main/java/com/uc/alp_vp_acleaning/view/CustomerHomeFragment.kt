package com.uc.alp_vp_acleaning.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.databinding.FragmentCustomerHomeBinding

class CustomerHomeFragment : Fragment() {

    private lateinit var binding : FragmentCustomerHomeBinding
    private lateinit var bottomSheetDialog: BottomSheetDialog

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

        binding.filterButton.setOnClickListener{
            Toast.makeText(activity, "ini filter", Toast.LENGTH_SHORT).show()
            val dialogView = layoutInflater.inflate(R.layout.button_filter, null)

            bottomSheetDialog = BottomSheetDialog(requireContext())
            bottomSheetDialog.setContentView(dialogView)
            bottomSheetDialog.show()
        }
    }

}