package sg.edu.rp.c346.id22015529.mymovies;

public class Movie {
    private int movieID ;
    private String title ;
    private String genre ;
    private int year ;
    private String rating ;

    public Movie(int movieID, String title, String genre, int year, String rating) {
        this.movieID = movieID ;
        this.title = title ;
        this.genre = genre ;
        this.year = year ;
        this.rating = rating ;
    }

    public int getMovieID() {
        return movieID;
    }
    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
}
