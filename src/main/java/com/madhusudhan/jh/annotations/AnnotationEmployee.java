package com.madhusudhan.jh.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class AnnotationEmployee {
    
    private SessionFactory factory = null;
    
    public void init() {
        Configuration config = new Configuration().configure( "annotations/hibernate.cfg.xml" );
        config.addAnnotatedClass( Employee.class );
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings( config.getProperties() )
                .buildServiceRegistry();
        factory = config.buildSessionFactory( registry );
    }
    
    public boolean persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Employee emp = new Employee( "M Konda" );
        
        session.save( emp );
        
        session.getTransaction().commit();
        System.out.println( "Done" );
        return true;
    }
}
