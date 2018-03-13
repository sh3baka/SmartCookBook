package lv.shebaka.smartcookbook.logic;

public class Error {

    private String field;
    private String errorMsg;

    public Error(String field, String errorMsg) {
        this.field = field;
        this.errorMsg = errorMsg;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
