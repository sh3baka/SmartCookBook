package lv.shebaka.smartcookbook.logic.addUserFridgeItems;

import lv.shebaka.smartcookbook.logic.Error;

import java.util.List;

public class AddToFridgeResponse {

    private Long fridgeId;
    private boolean success;
    private List<Error> errors;

    public AddToFridgeResponse(Long fridgeId) {
        this.fridgeId = fridgeId;
        this.success = true;
        this.errors = null;
    }

    public AddToFridgeResponse(List<Error> errors) {
        this.errors = errors;
        this.fridgeId = null;
        this.success = false;
    }

    public Long getFridgeId() {
        return fridgeId;
    }

    public void setFridgeId(Long fridgeId) {
        this.fridgeId = fridgeId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
