package sg.edu.rp.c346.id22015529.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class modifyMovie extends AppCompatActivity {
    EditText etID, etTitle, etGenre, etYear ;
    Spinner spinRate ;
    Button btnUpdate, btnDelete, btnCancel ;
    Movie data ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_movie);

        etID = findViewById(R.id.getETMovieID) ;
        etTitle = findViewById(R.id.getETTitle) ;
        etGenre = findViewById(R.id.getETGenre) ;
        etYear = findViewById(R.id.getETYear) ;
        btnUpdate = findViewById(R.id.buttonUpdate) ;
        btnDelete = findViewById(R.id.buttonDelete) ;
        btnCancel = findViewById(R.id.buttonCancel) ;
        spinRate = findViewById(R.id.spinnerRate) ;

        Intent intent = getIntent() ;
        data = (Movie) intent.getSerializableExtra("data") ;

        etID.setText(data.getMovieID());
        etTitle.setText(data.getTitle());
        etGenre.setText(data.getGenre());
        etYear.setText(data.getYear());
        spinRate.setOnItemSelectedListener(data.getRating());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(modifyMovie.this);
                data.setTitle(etTitle.getText().toString());
                data.setTitle(etTitle.getText().toString());
                data.setTitle(etTitle.getText().toString());
                dbh.updateMovie(data);
                dbh.close();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(modifyMovie.this);
                dbh.deleteMovie(data.getMovieID());
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(modifyMovie.this, showMovies.class) ;
                startActivity(i) ;
            }
        });

    }
}