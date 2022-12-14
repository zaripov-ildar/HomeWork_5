package ru.starstreet.store;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDaoImpl implements iProductDao {
    private SessionFactoryUtils factoryUtils;


    @Autowired
    public void setFactoryUtils(SessionFactoryUtils factoryUtils) {
        this.factoryUtils = factoryUtils;
    }

    @Override
    public Product findById(Long id) {
        Session session = factoryUtils.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    @Override
    public List<Product> findAll() {
        Session session = factoryUtils.getSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product").getResultList();
        session.getTransaction().commit();
        return products;
    }

    @Override
    public void deleteById(Long id) {
        Session session = factoryUtils.getSession();
        session.beginTransaction();
        session.createQuery("delete Product p where p.id = :prodId")
                .setParameter("prodId", id)
                .executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        Session session = factoryUtils.getSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        return null;
    }
}
