package com.tepdev.weedwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initializer = DatabaseInitializer(this)
        initializer.initializeDatabase()

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        toolbar.title = "WeedWise"

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        if (savedInstanceState == null) {
            replaceFragment(RecognitionFragment())
            navigationView.setCheckedItem(R.id.recognition)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragment: Fragment
        val title: String

        when (item.itemId) {
            R.id.recognition -> {
                fragment = RecognitionFragment()
                title = "Recognition"
            }
            R.id.chat -> {
                fragment = WeatherFragment()
                title = "Weather"
            }
            R.id.species -> {
                fragment = WeedFragment()
                title = "Weed Species"
            }
            R.id.classification -> {
                fragment = ClassificationFragment()
                title = "Classification"
            }
            R.id.management -> {
                fragment = ManagementFragment()
                title = "Management Option"
            }
            R.id.herbicides -> {
                fragment = HerbicidesFragment()
                title = "Herbicides List"
            }
            R.id.about -> {
                fragment = AboutFragment()
                title = "About WeedWise"
            }
            else -> {
                fragment = RecognitionFragment()
                title = "Recognition"
            }
        }

        replaceFragment(fragment)
        supportActionBar?.title = title // Set the toolbar title
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

