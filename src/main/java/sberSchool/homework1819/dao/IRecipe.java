package sberSchool.homework1819.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sberSchool.homework1819.models.Recipe;

import java.util.List;

@Repository
public class IRecipe implements RecipeDao {

    private SessionFactory sessionFactory;

    @Autowired
    public IRecipe(SessionFactory sessionFactory) {
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
    public void save(Recipe recipe) {
        getSession().save(recipe);
    }

    @Override
    public List allRecipes() {
        List from_recipe = getSession().createQuery("from Recipe").list();
        return from_recipe;
    }

    @Override
    public Recipe findId(Long id) {
        Recipe recipe = getSession().get(Recipe.class, id);
        return recipe;
    }


}
