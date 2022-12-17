package me.nerminsehic.dao;

import me.nerminsehic.dao.MovieDao;
import me.nerminsehic.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieDaoImpl implements MovieDao {

    @Override
    public List<Movie> selectMovies() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public int insertMovie(Movie movie) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public int deleteMovie(int id) {
        throw new UnsupportedOperationException("not implemented");

    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        throw new UnsupportedOperationException("not implemented");
    }
    
}
