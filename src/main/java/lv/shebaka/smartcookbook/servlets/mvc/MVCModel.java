package lv.shebaka.smartcookbook.servlets.mvc;

public class MVCModel {
    private String view;
    private Object data;

    public MVCModel(String view, Object data) {
        this.view = view;
        this.data = data;
    }

    public String getView() {
        return view;
    }

    public Object getData() {
        return data;
    }

    public void setView(String view) {
        this.view = view;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
