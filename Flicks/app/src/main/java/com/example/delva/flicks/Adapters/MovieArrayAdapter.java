package com.example.delva.flicks.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.delva.flicks.Models.Movie;
import com.example.delva.flicks.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by Delva on 7/15/2016.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, ArrayList<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    // Model=> view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movie = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView= inflater.inflate(R.layout.item_movie,parent,false);
        }

        //find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovie);
        // clear out image from convert view
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverView = (TextView) convertView.findViewById(R.id.tvOverView);

        // populate data
        tvTitle.setText(movie.getOriginalTitle());
        tvOverView.setText(movie.getOverView());

       // Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);

        Picasso.with(getContext()).load(movie.getPosterPath()).resize(200,300).transform(new RoundedCornersTransformation(10, 10)).centerCrop().into(ivImage);
        // return the view
        return convertView;

        }
    }