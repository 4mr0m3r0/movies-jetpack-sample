package com.tzion.jetpackmovies.uicomponent.template

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.uicomponent.template.model.AttrsDetailTemplate
import kotlinx.android.synthetic.main.template_detail.view.*

class DetailTemplate @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.template_detail, this)
    }

    fun setAttributes(attrsDetailTemplate: AttrsDetailTemplate?) {
        attrsDetailTemplate?.apply {
            if (poster.isNotEmpty()) {
                Glide.with(context).load(poster).into(iv_poster)
            }
            tv_title.text = title
            tv_runtime.text = runtime
            tv_released.text = released
            tv_rating.text = rating
            tv_votes.text = votes
            tv_plot.text = plot
            tv_genre.text = genre
            tv_actors.text = actors
            tv_writer.text = writer
            tv_director.text = director
            tv_language.text = language
            tv_country.text = country

            invalidate()
        }
    }

    fun getTitle(): String = tv_title.text.toString()
}
