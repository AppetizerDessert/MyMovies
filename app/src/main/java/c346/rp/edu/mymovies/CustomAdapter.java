package c346.rp.edu.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id,parent,false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvGenre = rowView.findViewById(R.id.textViewGenre);
        ImageView ivMovie = rowView.findViewById(R.id.imageViewRating);

        Movie currentItem = movieList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvYear.setText(currentItem.getYear());
        tvGenre.setText(" - " + currentItem.getGenre());

        String check = currentItem.getRated();
        if (check.equalsIgnoreCase("g")){
            ivMovie.setImageResource(R.drawable.rating_g);
        } else if (check.equalsIgnoreCase("pg")) {
            ivMovie.setImageResource(R.drawable.rating_pg);
        } else if (check.equalsIgnoreCase("pg13")) {
            ivMovie.setImageResource(R.drawable.rating_pg13);
        } else if (check.equalsIgnoreCase("nc16")) {
            ivMovie.setImageResource(R.drawable.rating_nc16);
        } else if (check.equalsIgnoreCase("m18")){
            ivMovie.setImageResource(R.drawable.rating_m18);
        } else {
            ivMovie.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }
}
