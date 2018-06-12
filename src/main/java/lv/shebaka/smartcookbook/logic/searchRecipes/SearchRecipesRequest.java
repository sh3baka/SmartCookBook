package lv.shebaka.smartcookbook.logic.searchRecipes;

import lv.shebaka.smartcookbook.domain.User;

public class SearchRecipesRequest {

    private User user;

    public SearchRecipesRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
