package manager;

import domain.Movies;


public class Posters {
    private Movies[] movies = new Movies[0];
    private int numberOfMovies = 10;

    public Posters() {
    }

    public Posters(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }


    public void add(Movies movie) {
        int length = movies.length + 1;
        Movies[] tmp = new Movies[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movies[] getAll() {
        int resultLength;
        if (movies.length > numberOfMovies) {
            resultLength = numberOfMovies;
        } else {
            resultLength = movies.length;
        }
        Movies[] result = new Movies[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }


}
