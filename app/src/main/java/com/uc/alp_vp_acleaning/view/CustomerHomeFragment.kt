package com.uc.alp_vp_acleaning.view

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.adapter.KecamatanAdapter
import com.uc.alp_vp_acleaning.adapter.TechnicianAdapter
import com.uc.alp_vp_acleaning.databinding.FragmentCustomerHomeBinding
import com.uc.alp_vp_acleaning.model.Kecamatan
import com.uc.alp_vp_acleaning.model.KecamatanElement
import com.uc.alp_vp_acleaning.model.KecamatanItem
import com.uc.alp_vp_acleaning.viewmodel.KecamatanViewModel
import com.uc.alp_vp_acleaning.viewmodel.TechnicianViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.internal.Contexts

//@EntryPoint
//@InstallIn(FragmentComponent::class)
@AndroidEntryPoint

class CustomerHomeFragment : Fragment() {

    private lateinit var adapterTechnician: TechnicianAdapter
    private lateinit var adapterKecamatan: KecamatanAdapter
    private lateinit var binding : FragmentCustomerHomeBinding
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private lateinit var viewModelTech : TechnicianViewModel
    private lateinit var viewModelKecamatan: KecamatanViewModel

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

            viewModelKecamatan = ViewModelProvider(this).get(KecamatanViewModel::class.java)
            viewModelKecamatan.getKecamatanData()
            viewModelKecamatan._kecamatan.observe(viewLifecycleOwner, Observer{response->
                val rvKecamatan = bottomSheetDialog.findViewById<RecyclerView>(R.id.rvKecamatan)
                rvKecamatan?.layoutManager = LinearLayoutManager(context)
                adapterKecamatan = KecamatanAdapter(response)
                rvKecamatan?.adapter = adapterKecamatan
            })

            bottomSheetDialog.show()
        }

        viewModelTech = ViewModelProvider(this).get(TechnicianViewModel::class.java)
//        viewModelTech = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(
//            Application()
//        )).get(TechnicianViewModel::class.java)
        viewModelTech.getTechnicianData()

        viewModelTech.technician.observe(viewLifecycleOwner, Observer{ response->
            Log.e("Technician name", response.toString())
            binding.rvAllTech.layoutManager = LinearLayoutManager(context)
            val kecamatan = ArrayList<KecamatanItem>()
            adapterTechnician = TechnicianAdapter(response, kecamatan)
            binding.rvAllTech.adapter = adapterTechnician
        })

    }

}