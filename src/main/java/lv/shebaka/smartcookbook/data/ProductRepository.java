package lv.shebaka.smartcookbook.data;

import lv.shebaka.smartcookbook.domain.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    @Transactional
    List<Product> getAllProducts();

    @Transactional
    Optional<Product> getProductsByName(String title);


}
