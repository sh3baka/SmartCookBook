package lv.shebaka.smartcookbook.logic.addUserFridgeItems;

import lv.shebaka.smartcookbook.domain.Product;
import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.logic.Error;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddToFridgeValidatorImpl implements AddToFridgeValidator {

    public List<Error> validate(AddToFridgeRequest request) {
        List<Error> errors = new ArrayList<>();
        validationUserExists(request.getUser()).ifPresent(errors::add);
        validationProductExists(request.getProduct()).ifPresent(errors::add);

        return errors;
    }

    private Optional<Error> validationUserExists(User user) {
        if (user == null) {
            return Optional.of(new Error("user", "User is null"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validationProductExists(Product product) {
        if (product == null) {
            return Optional.of(new Error("product", "Product is null"));
        } else {
            return Optional.empty();
        }
    }


}
