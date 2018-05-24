package lv.shebaka.smartcookbook.domain;

import javax.persistence.*;

@Entity
@Table(name = "recipe_item")
public class RecipeItem {

    @Id
    @Column(name = "id_recipe_item")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*@ManyToOne -  Many recipes to one recipe item
    @OneToMany - One recipe to many recipe items*/

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipes;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipe recipes) {
        this.recipes = recipes;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeItem that = (RecipeItem) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recipes != null ? !recipes.equals(that.recipes) : that.recipes != null) return false;
        return product != null ? product.equals(that.product) : that.product == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (recipes != null ? recipes.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RecipeItem{" +
                "id=" + id +
                ", recipes=" + recipes +
                ", product=" + product +
                '}';
    }
}
