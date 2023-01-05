package com.uc.alp_vp_acleaning.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
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
import com.uc.alp_vp_acleaning.model.KecamatanItem1
import com.uc.alp_vp_acleaning.retrofit.FilterListener
import com.uc.alp_vp_acleaning.view.MainActivity.Companion.loginCustId
import com.uc.alp_vp_acleaning.viewmodel.CustomerViewModel
import com.uc.alp_vp_acleaning.viewmodel.KecamatanViewModel
import com.uc.alp_vp_acleaning.viewmodel.TechnicianViewModel
import dagger.hilt.android.AndroidEntryPoint

//@EntryPoint
//@InstallIn(FragmentComponent::class)
@AndroidEntryPoint

class CustomerHomeFragment : Fragment(), FilterListener {

    private lateinit var adapterTechnician: TechnicianAdapter
    private lateinit var adapterKecamatan: KecamatanAdapter
    private lateinit var binding : FragmentCustomerHomeBinding
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private lateinit var viewModelTech : TechnicianViewModel
    private lateinit var viewModelKecamatan: KecamatanViewModel
    private lateinit var viewModelCustomer: CustomerViewModel

//    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("c_id")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCustomerHomeBinding.inflate(layoutInflater)
        binding.filterButton.setOnClickListener{
//            Toast.makeText(activity, "ini filter", Toast.LENGTH_SHORT).show()
            val dialogView = layoutInflater.inflate(R.layout.button_filter, null)

            bottomSheetDialog = BottomSheetDialog(requireContext())
            bottomSheetDialog.setContentView(dialogView)

            viewModelKecamatan = ViewModelProvider(this).get(KecamatanViewModel::class.java)
            viewModelKecamatan.getKecamatanData()
            viewModelKecamatan._kecamatan.observe(viewLifecycleOwner, Observer{response->
                val rvKecamatan = bottomSheetDialog.findViewById<RecyclerView>(R.id.rvKecamatan)
                rvKecamatan?.layoutManager = LinearLayoutManager(context)
                adapterKecamatan = KecamatanAdapter(response, this)
                rvKecamatan?.adapter = adapterKecamatan
            })

            bottomSheetDialog.show()
        }


        viewModelTech = ViewModelProvider(this).get(TechnicianViewModel::class.java)
        viewModelTech.getTechnicianData()

        viewModelTech.technician.observe(viewLifecycleOwner, Observer{ response->
//            Log.e("Technician name", response.toString())
            binding.rvAllTech.layoutManager = LinearLayoutManager(context)
            val kecamatan = ArrayList<Kecamatan>()
            adapterTechnician = TechnicianAdapter(response)
            binding.rvAllTech.adapter = adapterTechnician
        })

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
             binding.searchView.clearFocus()
                viewModelTech.getTechName(query)
                viewModelTech.technician.observe(viewLifecycleOwner, Observer{ response->
                    binding.rvAllTech.layoutManager = LinearLayoutManager(context)
                    adapterTechnician = TechnicianAdapter(response)
                    binding.rvAllTech.adapter = adapterTechnician
                })
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModelTech.getTechName(newText)
                viewModelTech.technician.observe(viewLifecycleOwner, Observer{ response->
                    binding.rvAllTech.layoutManager = LinearLayoutManager(context)
                    adapterTechnician = TechnicianAdapter(response)
                    binding.rvAllTech.adapter = adapterTechnician
                })
                return false
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onFilterItemClicked(filter: String, isSelected: Int) {
        if(filter == "filKecamatan"){
            viewModelTech.getTechFilterData(isSelected)
        }
    }

}