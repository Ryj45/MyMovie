package c346.rp.edu.sg.mymovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.lvMovie);
        alMovieList = new ArrayList<>();
        Movie item1 = new Movie("The Avengers", "2012", "pg13"
        , "Action | Sci-Fi", "15/11/2014", "Golden Village - Bishan"
        , "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        alMovieList.add(item1);
        Movie item2 = new Movie("Planes", "2013", "pg",
                "Animation | Comedy", "15/5/2015", "Cathay - AMK Hub"
        , "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");
        alMovieList.add(item2);

        caMovie = new CustomAdapter(this, R.layout.row, alMovieList);
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), SecondActivity.class);

                intent.putExtra("title", alMovieList.get(position).getTitle());
                intent.putExtra("rate", alMovieList.get(position).getRated());
                intent.putExtra("year", alMovieList.get(position).getYear());
                intent.putExtra("genre", alMovieList.get(position).getGenre());
                intent.putExtra("description", alMovieList.get(position).getDescription());
                intent.putExtra("watch_on", alMovieList.get(position).getWatched_on());
                intent.putExtra("theatre", alMovieList.get(position).getIn_theatre());
                
                startActivity(intent);
            }
        });
    }
}
