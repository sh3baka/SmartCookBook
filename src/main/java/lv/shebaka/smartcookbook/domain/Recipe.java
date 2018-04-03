package lv.shebaka.smartcookbook.domain;

import javax.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
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
