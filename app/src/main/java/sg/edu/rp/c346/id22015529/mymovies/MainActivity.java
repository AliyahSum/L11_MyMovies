package sg.edu.rp.c346.id22015529.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etGenre, etYear ;
    Spinner spinRating ;
    Button btnInsert, btnShowMovies ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.editTextMovieTitle) ;
        etGenre = findViewById(R.id.editTextMovieTitle) ;
        etYear = findViewById(R.id.editTextMovieTitle) ;
        btnInsert = findViewById(R.id.buttonInsert) ;
        btnShowMovies = findViewById(R.id.buttonShowList) ;
        spinRating = findViewById(R.id.spinnerRating) ;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ratingsArray, android.R.layout.simple_spinner_item) ;
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) ;
        spinRating.setAdapter(adapter) ;

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString() ;
                String genre = etGenre.getText().toString() ;
                int year = Integer.parseInt(etYear.getText().toString());
                String rating = spinRating.getSelectedItem().toString() ;

                DBHelper db = new DBHelper(MainActivity.this) ;
                db.insertMovie(title, genre, year, rating) ;

                String msg = "New movie added!" ;
                Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG) ;
                toast.show();
            }
        });
        btnShowMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this) ;
                ArrayList<String> movieList = db.getMovieContent() ;
                db.close() ;

                Intent intent = new Intent(MainActivity.this, showMovies.class) ;
                intent.putExtra("data", movieList) ;
                startActivity(intent) ;
            }
        });
    }
}