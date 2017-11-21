package com.androidmads.kotlinlistrecyclerview.adapters


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.myapplication.R
import models.Movies

/**
 * Created by jeet on 7/1/2017.
 */

class MoviesRecyclerAdapter : RecyclerView.Adapter<MoviesRecyclerAdapter.MyViewHolder> {

    private val moviesList: List<Movies>
    private var mListener: OnItemClickListener? = null


           constructor(moviesList: List<Movies>) : super() {
               this.moviesList = moviesList
           }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById<TextView>(R.id.title)
        var year: TextView = view.findViewById<TextView>(R.id.year)
        var genre: TextView = view.findViewById<TextView>(R.id.genre)
        //var imageView: ImageView = view.findViewById<ImageView>(R.id.img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_list_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val Movies = moviesList[position]
        holder.title.text = Movies.title
        holder.genre.text = Movies.genre
        holder.year.text = Movies.year


       // Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(holder.imageView);


        holder.itemView.setOnClickListener { v ->
            mListener?.onItemClickListener(v, holder.layoutPosition)
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    interface OnItemClickListener {
        fun onItemClickListener(v: View, pos: Int)
    }
}