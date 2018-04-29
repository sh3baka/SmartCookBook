package lv.shebaka.smartcookbook.logic.addrecipe;

import lv.shebaka.smartcookbook.data.orm.RecipeDatabaseImpl;
import lv.shebaka.smartcookbook.logic.Error;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddRecipeValidatorTest {

    private RecipeDatabaseImpl database;
    private AddRecipeValidator validator;

    @Before
    public void init(){
        database = Mockito.mock(RecipeDatabaseImpl.class);
        validator = new AddRecipeValidator();
    }

    @Test
    public void shouldReturnErrorWhenTitleIsNull(){
        List<Error> errors = validator.validate(null,"description");
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "title");
        assertEquals(errors.get(0).getErrorMsg(),"Must not be empty");
    }

    @Test
    public void shouldReturnListEmpty(){
        List<Error> errors = validator.validate("title", "desc");
        assertEquals(errors.size(), 0);
    }

}