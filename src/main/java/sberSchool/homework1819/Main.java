package sberSchool.homework1819;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import sberSchool.homework1819.models.Product;
import sberSchool.homework1819.models.Recipe;
import sberSchool.homework1819.service.ProductService;
import sberSchool.homework1819.service.RecipeService;

@ComponentScan("sberSchool.homework1819.")
@PropertySource("classpath:application.properties")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        System.out.println("hello world");
        ProductService productService = context.getBean(ProductService.class);
        RecipeService recipeService = context.getBean(RecipeService.class);
//        Recipe recipe = recipeService.findId(18l);
        Product product = new Product();
        
//        System.out.println(recipe);
//        Product product = new Product();
//        product.setId(2);
//        product.setName("Яблоко");
//        productService.addProduct(product);
//        Recipe recipe = new Recipe();
//        recipe.setName("Молочная каша");
//        recipeService.addRecipe(recipe);
//        System.out.println(productService.allProduct());
//        System.out.println(recipeService.allRecipe());
    }
}
