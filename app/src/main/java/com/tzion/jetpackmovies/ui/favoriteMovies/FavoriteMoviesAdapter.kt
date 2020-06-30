package com.tzion.jetpackmovies.ui.favoriteMovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.tzion.jetpackmovies.databinding.ItemFavoriteMovieBinding
import com.tzion.jetpackmovies.databinding.ItemMovieBinding
import com.tzion.jetpackmovies.presentation.model.UiFavoriteMovie
import com.tzion.jetpackmovies.presentation.model.UiMovieDetail
import com.tzion.jetpackmovies.ui.Navigator
import javax.inject.Inject

class FavoriteMoviesAdapter @Inject constructor(private val navigator: Navigator)
    : PagedListAdapter<UiFavoriteMovie, FavoriteMoviesViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMoviesViewHolder {
        return FavoriteMoviesViewHolder(ItemFavoriteMovieBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FavoriteMoviesViewHolder, position: Int) {
        val favoriteMovie = getItem(position)
        favoriteMovie?.let { uiFavoriteMovie ->
            holder.apply {
                bind(createOnClickListener(uiFavoriteMovie), uiFavoriteMovie)
                setImage(favoriteMovie.poster)
                itemView.tag = favoriteMovie.title
            }
        }
    }

    private fun createOnClickListener(favoriteMovie: UiFavoriteMovie): View.OnClickListener {
        return View.OnClickListener {
//            navigator.openMovieDetails(it, favoriteMovie)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UiFavoriteMovie>() {
            override fun areItemsTheSame(oldItem: UiFavoriteMovie, newItem: UiFavoriteMovie): Boolean =
                oldItem.movieId == newItem.movieId

            override fun areContentsTheSame(oldItem: UiFavoriteMovie, newItem: UiFavoriteMovie)
                    : Boolean = oldItem == newItem

        }
    }
}