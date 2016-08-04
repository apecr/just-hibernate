package com.madhusudhan.jh.basics;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.madhusudhan.jh.domain.Movie;

import junit.framework.Assert;

public class VanillaMovieManagerTest {
    
    private VanillaMovieManager manager;
    
    @Before
    public void setUp(){
        this.manager = new VanillaMovieManager();
    }
    
    @Test
    public void testPersistenceWithJdbc(){
        this.manager.init();
        this.manager.persistMovie();
        List<Movie> movies = this.manager.queryMovies();
        Assert.assertEquals("Top Gun", movies.get( 0 ).getTitle());
    }
    
}
