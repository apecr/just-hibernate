package com.madhusudhan.jh.basics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.madhusudhan.jh.domain.Movie;

public class BasicMovieManager {
    
    
    private SessionFactory sessionFactory = null;
    
    public BasicMovieManager(String configurationFile) {
        init4x( configurationFile );
        //        init3x();
    }
    
    private void init4x(String configurationFile) {
        Configuration config = null;
        if (configurationFile != null) {
            config = new Configuration().configure( configurationFile );
        } else {
            config = new Configuration().configure( );
        }
        
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                config.getProperties() ).buildServiceRegistry();
        
        sessionFactory = config.buildSessionFactory( serviceRegistry );
        
    }
    
    private void init3x() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    public void persistMovie() {
        Movie movie = new Movie();
        
        movie.setId( 2 );
        movie.setDirector( "Steven Speilberg" );
        movie.setTitle( "Jaws" );
        movie.setSynopsis( "A tale of a white shark!" );
        
        Session session = sessionFactory.getCurrentSession();
        
        session.beginTransaction();
        
        session.save( movie );
        
        session.getTransaction().commit();
    }
    
    public void deleteMovie() {
        Movie movie = new Movie();
        
        movie.setId( 2 );
        movie.setDirector( "Steven Speilberg" );
        movie.setTitle( "Jaws" );
        movie.setSynopsis( "A tale of a white shark!" );
        
        Session session = sessionFactory.getCurrentSession();
        
        session.beginTransaction();
        
        session.delete( movie );
        
        session.getTransaction().commit();
    }
    
    public Movie findMovie(int i) {
        
        Session session = sessionFactory.getCurrentSession();
        
        session.beginTransaction();
        
        Movie movie = (Movie) session.load( Movie.class, i );
        
        System.out.println( "Movie:" + movie );
        
        session.getTransaction().commit();
        
        return movie;
        
    }
    
    public List<Movie> findAll() {
        
        Session session = sessionFactory.getCurrentSession();
        
        session.beginTransaction();
        
        List<Movie> movies = session.createQuery( "from Movie" ).list();
        
        session.getTransaction().commit();
        
        System.out.println( "All Movies:" + movies );
        
        return movies;
        
    }
    
}