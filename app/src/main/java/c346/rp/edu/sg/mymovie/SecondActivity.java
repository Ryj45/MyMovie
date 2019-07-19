package c346.rp.edu.sg.mymovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ImageView ivRate;
    TextView tvName, tvIntro, tvDecription, tvWatchOn, tvTheatre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivRate = findViewById(R.id.ivRate);
        tvName = findViewById(R.id.tvName);
        tvIntro = findViewById(R.id.tvIntro);
        tvDecription = findViewById(R.id.tvDecription);
        tvWatchOn = findViewById(R.id.tvWatchOn);
        tvTheatre = findViewById(R.id.tvTheatre);

        Intent intentReceived = getIntent();
        String title = intentReceived.getStringExtra("title");
        String rate = intentReceived.getStringExtra("rate");
        String year = intentReceived.getStringExtra("year");
        String genre = intentReceived.getStringExtra("genre");
        String description = intentReceived.getStringExtra("description");
        String watch_on = intentReceived.getStringExtra("watch_on");
        String theatre = intentReceived.getStringExtra("theatre");

        tvName.setText(title);
        tvIntro.setText(year + " - " +genre);
        tvDecription.setText(description);
        tvWatchOn.setText(watch_on);
        tvTheatre.setText(theatre);
        switch (rate){
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
    }
}

