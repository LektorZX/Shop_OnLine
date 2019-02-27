package root.repository.orderRepo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import root.model.Basket;
import root.model.BasketEmbeddedId;
import root.model.Order;
import root.repository.BasketRepo.CustomBasketRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface OrderRepository extends CrudRepository<Order, Long>, CustomBasketRepository {
    @Override
    <S extends Order> S save(S s);

    @Override
    Optional<Order> findById(Long aLong);
//
//    List<Order> findAllByBasket(Long along);

    @Override
    void deleteById(Long aLong);

    @Modifying
    @Query(value = "INSERT INTO online_store.order(order_id, id_product) values (:order,:user)", nativeQuery = true)
    void customSave(@Param("order") Long order, @Param("user") Long user);


    @Modifying
    @Query(value = "delete  from online_store.order where order_id=:id", nativeQuery = true)
    void delete(@Param("id") Long orderId);


    @Query(value ="select m.id_product from online_store.order m where m.order_id= :id", nativeQuery = true)
    List<Long> customFindAllByBasket(@Param("id") Long along);



}


