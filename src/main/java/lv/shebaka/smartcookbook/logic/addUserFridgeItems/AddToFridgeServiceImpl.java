package lv.shebaka.smartcookbook.logic.addUserFridgeItems;

import lv.shebaka.smartcookbook.data.FridgeRepository;
import lv.shebaka.smartcookbook.domain.UserFridge;
import lv.shebaka.smartcookbook.logic.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static lv.shebaka.smartcookbook.domain.builders.UserFridgeBuilder.createUserFridge;

@Component
public class AddToFridgeServiceImpl implements AddToFridgeService {


    @Autowired
    private AddToFridgeValidator addToFridgeValidator;
    @Autowired
    private FridgeRepository fridgeRepository;

    @Override
    @Transactional
    public AddToFridgeResponse addToFridge(AddToFridgeRequest request) {
        List<Error> validationErrors = addToFridgeValidator.validate(request);
        if (!validationErrors.isEmpty()) {
            return new AddToFridgeResponse(validationErrors);
        }

        UserFridge userFridge = createUserFridge()
                .withUser(request.getUser())
                .withProduct(request.getProduct())
                .build();

        fridgeRepository.addToUserFridge(userFridge);


        return new AddToFridgeResponse(userFridge.getId());
    }

}
