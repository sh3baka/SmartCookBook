package lv.shebaka.smartcookbook.data.orm;

import lv.shebaka.smartcookbook.data.ProductRepository;
import lv.shebaka.smartcookbook.domain.Product;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryImpl extends ORMRepository implements ProductRepository {

    @Override
    public List<Product> getAllProducts() {
        return session().createCriteria(Product.class).list();
    }

    @Override
    public Optional<Product> getProductsByName(String title) {
        Product product = (Product) session().createCriteria(Product.class).
                add(Restrictions.eq("title", title)).uniqueResult();
        return Optional.of(product);

    }
}
