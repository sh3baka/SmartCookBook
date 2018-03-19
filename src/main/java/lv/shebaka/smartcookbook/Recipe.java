package lv.shebaka.smartcookbook;

public class Recipe {

    private Long id;
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

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (id != null ? !id.equals(recipe.id) : recipe.id != null) return false;
        if (title != null ? !title.equals(recipe.title) : recipe.title != null ) return false;
        return desc != null ? desc.equals(recipe.desc) : recipe.desc == null;
    }
}
