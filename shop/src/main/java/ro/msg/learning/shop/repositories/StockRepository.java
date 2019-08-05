package ro.msg.learning.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.auxiliar_entities.StockKey;
import ro.msg.learning.shop.entities.Stock;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, StockKey> {
    Optional<List<Stock>> findByProduct_Id(Integer productId);

    @Modifying
    @Query("update Stock s set s.quantity = ?1 where s.id=?2")
    void updateStockById(Integer quantity, StockKey stockKey);
}
