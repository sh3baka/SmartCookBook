package lv.shebaka.smartcookbook.logic.addRecipe;

import lv.shebaka.smartcookbook.data.RecipeRepository;
import lv.shebaka.smartcookbook.domain.Recipe;
import lv.shebaka.smartcookbook.logic.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddRecipeValidator {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Error> validate(String title, String desc) {
        List<Error> errors = new ArrayList<>();
        validateTitle(title).ifPresent(errors::add);
        validateDescription(desc).ifPresent(errors::add);
        validateDuplicateTitle(title).ifPresent(errors::add);
        return errors;
    }

    private Optional<Error> validateTitle(String title) {
        if (title == null || title.isEmpty()) {
            return Optional.of(new Error("title", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateDescription(String desc) {
        if (desc == null || desc.isEmpty()) {
            return Optional.of(new Error("description", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateDuplicateTitle(String title) {
        if (title != null && title.isEmpty()) {
            Optional<Recipe> recipeOptional = recipeRepository.findByTitle(title);
            if (recipeOptional.isPresent()) {
                return Optional.of(new Error("title", "Must not repeat"));
            }
        }
        return Optional.empty();
    }
}
