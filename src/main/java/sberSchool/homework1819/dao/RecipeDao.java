package sberSchool.homework1819.dao;

import sberSchool.homework1819.models.Recipe;

import java.util.List;

public interface RecipeDao {
    void save(Recipe recipe);
    List allRecipes();
    Recipe findId(Long id);

}
