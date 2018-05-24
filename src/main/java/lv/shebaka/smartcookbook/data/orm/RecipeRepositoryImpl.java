package lv.shebaka.smartcookbook.data.orm;

import lv.shebaka.smartcookbook.data.RecipeRepository;
import lv.shebaka.smartcookbook.domain.Product;
import lv.shebaka.smartcookbook.domain.Recipe;
import lv.shebaka.smartcookbook.domain.RecipeItem;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Component
public class RecipeRepositoryImpl extends ORMRepository implements RecipeRepository {

    @Override
    public void add(Recipe recipe) {
        session().save(recipe);
    }

    @Override
    public Optional<Recipe> findByTitle(String title) {
        Recipe recipe = (Recipe) session().createCriteria(Recipe.class).add(Restrictions.eq("title", title)).uniqueResult();
        return Optional.ofNullable(recipe);
    }

    @Override
    public void remove(Recipe recipe) {
        session().delete(recipe);
    }

    @Override
    @Transactional
    public List<Recipe> getAllRecipes() {
        return session().createCriteria(Recipe.class).list();
    }

    @Override
    @Transactional
    public List<RecipeItem> getRecipeProducts(Recipe recipe) {
        return session().createCriteria(RecipeItem.class).add(Restrictions.eq("recipes", recipe)).list();
    }
}
