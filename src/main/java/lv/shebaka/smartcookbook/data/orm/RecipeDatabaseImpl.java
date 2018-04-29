package lv.shebaka.smartcookbook.data.orm;

import lv.shebaka.smartcookbook.data.RecipeDatabase;
import lv.shebaka.smartcookbook.data.orm.ORMRepository;
import lv.shebaka.smartcookbook.domain.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class RecipeDatabaseImpl extends ORMRepository implements RecipeDatabase {

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
    public List<Recipe> getAllRecipes() {
        return session().createCriteria(Recipe.class).list();
    }
}
