package com.tzion.jetpackmovies.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.tzion.jetpackmovies.JetpackMoviesApp
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.common.DefaultValues
import com.tzion.jetpackmovies.databinding.ActivityMainBinding
import com.tzion.jetpackmovies.presentation.FindMoviesViewModel
import com.tzion.jetpackmovies.presentation.MainViewModel
import com.tzion.jetpackmovies.ui.di.ViewModelFactory
import com.tzion.jetpackmovies.ui.di.module.DaggerMoviesComponent
import javax.inject.Inject

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration : AppBarConfiguration
    @Inject lateinit var viewModelFactory: ViewModelFactory
    private val mainViewModel: MainViewModel? by lazy {
        ViewModelProviders
            .of(this, viewModelFactory)
            .get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        val navHostFragment = getNavHostFragment()
        appBarConfiguration = makeAppBarConfigurationWithDestinations()
        setupActionBar(navHostFragment.navController, appBarConfiguration)
        setupDependencyInjection()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarMovies)
    }

    private fun getNavHostFragment(): NavHostFragment = supportFragmentManager
        .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

    private fun makeAppBarConfigurationWithDestinations(): AppBarConfiguration = AppBarConfiguration(
            setOf(R.id.findMoviesByNameFragment, R.id.favoriteMovies),
            binding.drawerLayout)

    private fun setupActionBar(navController: NavController, appBarConfiguration: AppBarConfiguration) {
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(findNavController(R.id.nav_host_fragment), appBarConfiguration)
    }

    private fun setupDependencyInjection() {
        val applicationComponent = (applicationContext as JetpackMoviesApp).appComponent
        DaggerMoviesComponent.factory().create(applicationComponent).inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.find_movies_menu, menu)
        val searchView = menu?.findItem(R.id.menu_search)?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(text: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(text: String?): Boolean {
                mainViewModel?.postFindMovieQuery(name = text ?: DefaultValues.emptyString())
                return false
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_search -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}