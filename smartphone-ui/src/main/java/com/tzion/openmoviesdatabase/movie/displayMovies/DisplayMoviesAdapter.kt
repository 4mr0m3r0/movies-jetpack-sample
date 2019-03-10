package com.tzion.openmoviesdatabase.movie.displayMovies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tzion.openmoviesdatabase.R
import com.tzion.openmoviesdatabase.databinding.ItemMovieBinding
import com.tzion.openmoviesdatabase.movie.model.MovieView
import timber.log.Timber
import javax.inject.Inject

class DisplayMoviesAdapter @Inject constructor(): RecyclerView.Adapter<DisplayMoviesAdapter.ViewHolder>() {

    var movies: List<MovieView> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
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
//            val movieDetail = PlantListFragmentDirections.ActionPlantListFragmentToPlantDetailFragment(plantId)
//            it.findNavController().navigate(direction)
        }
    }

    fun setData(movies: List<MovieView>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: MovieView) {
            binding.apply {
                clickListener = listener
                movie = item
                executePendingBindings()
            }
        }

        fun setImage(poster: String?) {
            try {
                Glide.with(binding.root)
                    .load(poster)
    //                .apply(RequestOptions.circleCropTransform())
                    .into(binding.acivMovieAvatar)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}