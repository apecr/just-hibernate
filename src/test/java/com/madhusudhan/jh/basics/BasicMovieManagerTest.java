package com.madhusudhan.jh.basics;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.madhusudhan.jh.domain.Movie;

import junit.framework.Assert;

public class BasicMovieManagerTest {
    
    
    private BasicMovieManager basicMovieManager;
    
    @Before
    public void setUp(){
        
    }
    
    @Test
    public void testPersistMovieMySQl(){
        this.basicMovieManager = new BasicMovieManager(null);
        this.basicMovieManager.deleteMovie();
        this.basicMovieManager.persistMovie();
        Movie movie = this.basicMovieManager.findMovie( 2 );
        List<Movie> movies = this.basicMovieManager.findAll();
        Assert.assertEquals(2,  movie.getId() );
        Assert.assertEquals( 2, movies.size() );
    }
    
    @Test
    public void testPersistMovieDerby(){
        this.basicMovieManager = new BasicMovieManager("/hibernate-derby.xml"); 
        this.basicMovieManager.deleteMovie();
        this.basicMovieManager.persistMovie();
        Movie movie = this.basicMovieManager.findMovie( 2 );
        List<Movie> movies = this.basicMovieManager.findAll();
        Assert.assertEquals(2,  movie.getId() );
        Assert.assertEquals( 1, movies.size() );
    }
}
