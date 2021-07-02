package com.tzion.jetpackmovies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.WorkManager
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.databinding.ActivityMainBinding
import com.tzion.jetpackmovies.device.notification.NotificationBuilder
import com.tzion.jetpackmovies.device.worker.FavoriteMovieWorkRequest
import com.tzion.jetpackmovies.device.worker.FavoriteMovieWorker
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    @Inject
    lateinit var notificationBuilder: NotificationBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        val navHostFragment = getNavHostFragment()
        appBarConfiguration = makeAppBarConfigurationWithDestinations()
        setupActionBar(navHostFragment.navController, appBarConfiguration)
        setupNavigationMenu(navHostFragment.navController)
        createFavoriteMovieChannel()
        setupWorker()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarMovies)
    }

    private fun getNavHostFragment(): NavHostFragment = supportFragmentManager
        .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

    private fun makeAppBarConfigurationWithDestinations(): AppBarConfiguration =
        AppBarConfiguration(
            setOf(R.id.findMoviesByNameFragment, R.id.favoriteMoviesFragment),
            binding.drawerLayout
        )

    private fun setupActionBar(
        navController: NavController,
        appBarConfiguration: AppBarConfiguration
    ) {
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            findNavController(R.id.nav_host_fragment),
            appBarConfiguration
        )
    }

    private fun setupNavigationMenu(navController: NavController) {
        binding.navView.setupWithNavController(navController)
    }

    private fun createFavoriteMovieChannel() {
        notificationBuilder.createFavoriteMovieNotificationChannel(this)
    }

    private fun setupWorker() {
        val request = FavoriteMovieWorkRequest()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            FavoriteMovieWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            request.makeFavoriteMovieWorkRequest()
        )
    }
}
