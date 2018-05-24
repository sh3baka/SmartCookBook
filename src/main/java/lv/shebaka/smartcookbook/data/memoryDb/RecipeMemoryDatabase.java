//package lv.shebaka.smartcookbook.data;
//
//import lv.shebaka.smartcookbook.domain.Recipe;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class RecipeMemoryDatabase implements RecipeRepository {
//
//
//    private List<Recipe> recipes = new ArrayList<>();
//
//    @Override
//
//    public void add(Recipe recipe) {
//        recipes.add(recipe);
//    }
//
//    @Override
//
//    public void remove(Recipe recipe) {
//        recipes.remove(recipe);
//    }
//
//    @Override
//
//    public List<Recipe> getAllRecipes() {
//        List<Recipe> allRecipes = new ArrayList<>();
//        allRecipes.addAll(recipes);
//        return allRecipes;
//    }
//
//    @Override
//
//    public Optional<Recipe> findByTitle(final String title) {
//        return recipes.stream()
//                .filter(p -> p.getTitle().equals(title)).findFirst();
//    }
//}
