package com.uc.alp_vp_acleaning.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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

            navView.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.nav_technician_home->{
                        Toast.makeText(this@MainActivity, "ini home", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_technician_profile->{
                        Toast.makeText(this@MainActivity, "ini profile", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_technician_delete->{
                        Toast.makeText(this@MainActivity, "ini delete", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_technician_logout->{
                        Toast.makeText(this@MainActivity, "ini home", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }

}