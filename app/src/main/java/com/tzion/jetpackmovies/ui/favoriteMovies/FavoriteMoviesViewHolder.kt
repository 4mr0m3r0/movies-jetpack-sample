package com.tzion.jetpackmovies.ui.favoriteMovies

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tzion.jetpackmovies.databinding.ItemFavoriteMovieBinding
import com.tzion.jetpackmovies.databinding.ItemMovieBinding
import com.tzion.jetpackmovies.presentation.model.UiFavoriteMovie
import com.tzion.jetpackmovies.presentation.model.UiMovieDetail
import timber.log.Timber

class FavoriteMoviesViewHolder(private val binding: ItemFavoriteMovieBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(listener: View.OnClickListener, item: UiFavoriteMovie) {
        binding.apply {
            clickListener = listener
            favoriteMovie = item
            executePendingBindings()
        }
    }

    fun setImage(poster: String?) {
        try {
            Glide.with(binding.root)
                .load(poster)
                .into(binding.acivMovieAvatar)
        } catch (e: Exception) {
            Timber.d("adapter setImage ERROR: ${e.stackTrace}")
        }
    }

}