package com.dicoding.myexpert

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.dicoding.myexpert.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)

        drawerLayout = binding.drawerLayout

        // Setup Navigation Component
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Setup Drawer Toggle
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Hubungkan NavigationView dengan NavController
        binding.navView.setNavigationItemSelectedListener { item ->
            onNavigationItemSelected(item)
        }
    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                if (navController.currentDestination?.id != R.id.homeFragment) {
                    navController.navigate(R.id.homeFragment)
                }
            }
            R.id.nav_favorite -> {
                val uri = Uri.parse("myexpert://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
                drawerLayout.closeDrawer(GravityCompat.START)
                return true // Keluar dari fungsi agar drawer tidak ditutup dua kali
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
