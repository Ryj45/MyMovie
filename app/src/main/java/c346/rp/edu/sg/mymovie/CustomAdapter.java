package c346.rp.edu.sg.mymovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects){
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvName = rowView.findViewById(R.id.tvName);
        TextView tvIntro = rowView.findViewById(R.id.tvIntro);
        ImageView ivRate = rowView.findViewById(R.id.ivRate);

        Movie currentItem = movieList.get(position);
        tvName.setText(currentItem.getTitle());
        tvIntro.setText(currentItem.getYear() + " - " + currentItem.getGenre());
        switch (currentItem.getRated()){
            case "g":
                ivRate.setImageResource(R.drawable.rating_g);
                break;
            case "pg":
                ivRate.setImageResource(R.drawable.rating_pg);
                break;
            case "pg13":
                ivRate.setImageResource(R.drawable.rating_pg13);
                break;
            case "nc16":
                ivRate.setImageResource(R.drawable.rating_nc16);
                break;
            case "m18":
                ivRate.setImageResource(R.drawable.rating_m18);
                break;
            case "r21":
                ivRate.setImageResource(R.drawable.rating_r21);
                break;
        }

        return rowView;
    }
}
