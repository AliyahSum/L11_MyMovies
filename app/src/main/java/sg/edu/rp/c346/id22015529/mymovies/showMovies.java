package sg.edu.rp.c346.id22015529.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class showMovies extends AppCompatActivity {
    Button btnShowPG13 ;
    ListView lvMovie ;
    ArrayList<Movie> alMovieList ;
    CustomAdapter caMovie ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movies);

        btnShowPG13 = findViewById(R.id.buttonShowAllPG13) ;
        lvMovie = findViewById(R.id.listViewMovie) ;
        Bundle bundle = getIntent().getExtras() ;

        ArrayList<String> movieList = bundle.getStringArrayList("data") ;

        caMovie = new CustomAdapter(this, R.layout.row, alMovieList) ;
        lvMovie.setAdapter(caMovie) ;

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie data = alMovieList.get(position) ;
                Intent intent = new Intent(showMovies.this, modifyMovie.class) ;
                intent.putExtra("data", data) ;
                startActivity(intent) ;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume() ;
        Intent i = new Intent(showMovies.this, showMovies.class) ;
        startActivity(i);
    }
}