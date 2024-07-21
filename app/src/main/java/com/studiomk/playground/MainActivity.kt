package com.studiomk.playground

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.studiomk.dashboard.di.dashboardModule
import com.studiomk.home.di.homeModule
import com.studiomk.network.di.networkModule
import com.studiomk.playground.databinding.ActivityMainBinding
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startNavigation()
    }

    private fun startNavigation() {
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun startKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(
                dashboardModule,
                homeModule,
                networkModule
            )
        }
    }
}