package lv.shebaka.smartcookbook.logic.addrecipe;

import lv.shebaka.smartcookbook.data.RecipeORMDatabase;
import lv.shebaka.smartcookbook.data.RecipeRealDatabase;
import lv.shebaka.smartcookbook.logic.AddResponse;
import lv.shebaka.smartcookbook.logic.Error;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AddRecipeServiceTest {

    @Mock
    private AddRecipeValidator validator;
    @Mock
    private RecipeORMDatabase database;

    @InjectMocks
    private AddRecipeService service = new AddRecipeService();

    @Test
    public void shouldReturnSuccess() {
        List<Error> errors = new ArrayList<>();
        Mockito.when(validator.validate("title", "desc")).thenReturn(errors);

        AddResponse response = service.addRecipe("title", "desc");

        assertEquals(response.isSuccess(), true);
        assertEquals(response.getErrors(), null);
    }

    @Test
    public void shouldReturnFalse() {
        List<Error> errors = new ArrayList<>();
        errors.add(new Error("title", "errorMsg"));
        Mockito.when(validator.validate(null, "desc")).thenReturn(errors);

        AddResponse response = service.addRecipe(null, "desc");

        assertEquals(response.isSuccess(), false);
        assertEquals(response.getErrors(), errors);
    }
}