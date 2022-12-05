package com.uc.alp_vp_acleaning.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.databinding.ActivityMainBinding
import com.uc.alp_vp_acleaning.databinding.FragmentTechnicianHomeBinding

class MainActivity : AppCompatActivity(){
    lateinit var viewBind: ActivityMainBinding
    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBind.root)
        viewBind.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity,drawerLayout,R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            //custom background
            supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.color.white))
            supportActionBar?.setDisplayShowTitleEnabled(false)

            //custom image
            supportActionBar?.setDisplayShowCustomEnabled(true)
            val view:View = layoutInflater.inflate(R.layout.logo, null)
            supportActionBar?.setCustomView(view)

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            Log.d("test1", "test")
            changeFragment(CustomerHomeFragment())

            navView.setNavigationItemSelectedListener{

                when(it.itemId){
                    R.id.nav_technician_home -> {
                        Log.d("test1", it.itemId.toString())
                        Toast.makeText(baseContext, "ini home", Toast.LENGTH_SHORT).show()
                        changeFragment(TechnicianHomeFragment())
                    }
                    R.id.nav_technician_profile -> {
                        Toast.makeText(applicationContext, "ini profile", Toast.LENGTH_SHORT).show()
                        changeFragment(TechnicianProfileFragment())
                    }
                    R.id.nav_technician_delete -> {
                        Toast.makeText(applicationContext, "ini delete", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_technician_logout -> {
                        Toast.makeText(applicationContext, "ini log out", Toast.LENGTH_SHORT).show()
//                        val loginIntent = Intent(this, LoginAsActivity::class.java)
//                        startActivity(loginIntent)
                    }
                }
                true
            }
        }
    }

    fun changeFragment(frag: Fragment){
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container, frag).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item.itemId==R.id.nav_technician_profile){
//            Toast.makeText(this, "ini profile", Toast.LENGTH_SHORT).show()
//            changeFragment(TechnicianProfileFragment())
//        }else if(item.itemId == R.id.nav_technician_profile){
//            Toast.makeText(this, "ini home", Toast.LENGTH_SHORT).show()
//            changeFragment(TechnicianHomeFragment())
//        }
//        return true
//    }



}