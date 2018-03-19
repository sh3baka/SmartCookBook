package lv.shebaka.smartcookbook.logic.addrecipe;

import lv.shebaka.smartcookbook.data.RecipeDatabase;
import lv.shebaka.smartcookbook.data.recipeRealDatabase;
import lv.shebaka.smartcookbook.logic.Error;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddRecipeServiceTest {

    //private RecipeDatabase database;
    private AddRecipeValidator validator;
    private AddRecipeService service;
    private recipeRealDatabase realDatabase;

    @Before
    public void init(){
        realDatabase = Mockito.mock(recipeRealDatabase.class);
        validator = Mockito.mock(AddRecipeValidator.class);
        service = new AddRecipeService(realDatabase, validator);
    }

    @Test
    public void shouldReturnSuccess(){
        List<Error> errors = new ArrayList<>();
        Mockito.when(validator.validate("title","desc")).thenReturn(errors);

        AddRecipeResponse response = service.addRecipe("title","desc");

        assertEquals(response.isSuccess(), true);
        assertEquals(response.getErrors(), null);
    }

    @Test
    public void shouldReturnFalse(){
        List<Error> errors = new ArrayList<>();
        errors.add(new Error("title", "errorMsg"));
        Mockito.when(validator.validate(null, "desc")).thenReturn(errors);

        AddRecipeResponse response = service.addRecipe(null, "desc");

        assertEquals(response.isSuccess(), false);
        assertEquals(response.getErrors(), errors);
    }
}