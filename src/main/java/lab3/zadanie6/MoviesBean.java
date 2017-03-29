package lab3.zadanie6;

import java.util.ArrayList;
import java.util.List;

public class MoviesBean {
    List<Movie> movies = new ArrayList<>();

    {
        movies.add(new Movie("Ojciec chrzestny","dramat",120000000.00,"1972"));
        movies.add(new Movie("Pluton","wojenny",50000000.00,"1986"));
        movies.add(new Movie("Nagi instynkt","thriller",100000000.00,"1992"));
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
