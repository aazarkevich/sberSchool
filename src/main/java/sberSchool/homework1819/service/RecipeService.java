package sberSchool.homework1819.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sberSchool.homework1819.dao.RecipeDao;
import sberSchool.homework1819.models.Recipe;

import java.util.List;

@Service
public class RecipeService {
    private RecipeDao recipeDao;

    @Autowired
    public RecipeService(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public void addRecipe(Recipe recipe) {
        recipeDao.save(recipe);
    }

    public List allRecipe() {
        return recipeDao.allRecipes();
    }

    public Recipe findId(Long id) {
        return recipeDao.findId(id);
    }
}
