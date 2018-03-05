package lv.shebaka.smartcookbook;

public class Recipe {

    private String title;
    private String desc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (title != null ? !title.equals(recipe.title) : recipe.title != null ) return false;
        return desc != null ? desc.equals(recipe.desc) : recipe.desc == null;
    }
}
