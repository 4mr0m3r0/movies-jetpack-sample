package com.tzion.jetpackmovies.ui.findMovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tzion.jetpackmovies.databinding.ItemMovieBinding
import com.tzion.jetpackmovies.presentation.model.UiMovie
import com.tzion.jetpackmovies.ui.Navigator
import javax.inject.Inject

class FindMoviesByNameAdapter @Inject constructor(
    private val navigator: Navigator
) : RecyclerView.Adapter<FindMoviesByNameAdapter.ViewHolder>() {

    var movies: List<UiMovie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.apply {
            bind(createOnClickListener(movie.movieId), movie)
            setImage(movie.poster)
            itemView.tag = movie
        }
    }

    private fun createOnClickListener(movieId: String): View.OnClickListener {
        return View.OnClickListener {
            navigator.openMovieDetails(it, movieId)
        }
    }

    fun setData(movies: List<UiMovie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: UiMovie) {
            binding.apply {
                clickListener = listener
                movie = item
                executePendingBindings()
            }
        }

        fun setImage(poster: String?) {
            Glide.with(binding.root)
                .load(poster)
//                .apply(RequestOptions.circleCropTransform())
                .into(binding.acivMovieAvatar)
        }
    }
}
