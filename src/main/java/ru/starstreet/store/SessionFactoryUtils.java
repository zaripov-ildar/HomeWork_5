package ru.starstreet.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryUtils {
    private SessionFactory factory;
    @PostConstruct
    public void init(){
        factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
    @PreDestroy
    public void close(){
        if (factory != null){
            factory.close();
        }
    }
    public Session getSession(){
        return factory.getCurrentSession();
    }
}
