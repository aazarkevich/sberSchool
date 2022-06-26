package sberSchool.homework1819.dao;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sberSchool.homework1819.models.Product;

import java.util.List;

@Repository
public class IProduct implements ProductDao {
    private SessionFactory sessionFactory;

    @Autowired
    public IProduct(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            return sessionFactory.openSession();
        }
    }

    @Override
    @Transactional
    public void save(Product product) {
        getSession().save(product);
    }

    @Override
    public List allProduct() {
        List from_product = getSession().createQuery("from Product").list();
        return from_product;
    }
}
