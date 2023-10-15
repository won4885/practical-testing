package sample.cafekiosk.spring.domain.product;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * SELECT * FROM `product` WHERE `selling_type` in ('SELLING', 'HOLD');
     */
    List<Product> findAllBySellingStatusIn(List<ProductSellingStatus> sellingStatuses);

    List<Product> findAllByProductNumberIn(List<String> productNumbers);

    @Query(value = "SELECT p.`product_number` "
            + "FROM `product` p "
            + "ORDER BY `id` "
            + "DESC "
            + "LIMIT 1 ", nativeQuery = true)
    String findLatestProductNumber();
}
