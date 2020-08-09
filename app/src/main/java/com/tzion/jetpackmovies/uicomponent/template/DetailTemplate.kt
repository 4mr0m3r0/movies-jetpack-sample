package com.tzion.jetpackmovies.uicomponent.template

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.common.DefaultValues
import com.tzion.jetpackmovies.uicomponent.template.model.AttrsDetailTemplate
import kotlinx.android.synthetic.main.template_detail.view.*
import timber.log.Timber

class DetailTemplate @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.template_detail, this)
    }

    fun setAttributes(attrsDetailTemplate: AttrsDetailTemplate?) {
        attrsDetailTemplate?.let {
            setPoster(it.poster)
            setTitle(it.title)
            setRuntime(it.runtime)
            setReleased(it.released)
            setRating(it.rating)
            setVotes(it.votes)
            setPlot(it.plot)
            setGenre(it.genre)
            setActors(it.actors)
            setWriter(it.writer)
            setDirector(it.director)
            setLanguage(it.language)
            setCountry(it.country)

            invalidate()
        }
    }

    private fun setPoster(poster: String) {
        try {
            if (poster.isNotEmpty()) {
                Glide.with(this).load(poster).into(iv_poster)
            }
        } catch (e: Exception) {
            Timber.d("template setPoster ERROR: ${e.stackTrace}")
        }
    }

    private fun setTitle(title: String) {
        tv_title.text = title
    }

    fun getTitle(): String = tv_title.text.toString()

    private fun setRuntime(runtime: String) {
        tv_runtime.text = runtime
    }

    private fun setReleased(released: String) {
        tv_released.text = released
    }

    private fun setRating(rating: String) {
        tv_rating.text = rating
    }

    private fun setVotes(votes: String) {
        tv_votes.text = votes
    }

    private fun setPlot(plot: String) {
        tv_plot.text = plot
    }

    private fun setGenre(genre: String) {
        tv_genre.text = genre
    }

    private fun setActors(actors: String) {
        tv_actors.text = actors
    }

    private fun setWriter(writer: String) {
        tv_writer.text = writer
    }

    private fun setDirector(director: String) {
        tv_director.text = director
    }

    private fun setLanguage(language: String) {
        tv_language.text = language
    }

    private fun setCountry(country: String) {
        tv_country.text = country
    }

}