package root.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import root.DTO.BasketDto;
import root.DTO.BasketDtoId;
import root.model.Basket;
import root.model.BasketEmbeddedId;
import root.model.Order;
import root.model.Product;
import root.repository.BasketRepo.BasketRepository;
import root.repository.orderRepo.OrderRepository;
import root.repository.productRepo.ProductRepository;
import root.utils.DtoConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
@Data
@Service
public class BasketServiceImpl implements BaseService<BasketDto, Long> {
    @Autowired
    BasketRepository basketRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductServiceImpl productService;


    @Override
    public <S extends BasketDto> S save(S entity) {
        Basket basket = DtoConverter.getInstance().BasketDtoConvertToBasket(entity);
        List<Long> productId = entity.getProductId();
        basketRepository.saveCustom(basket);
        for (Long aLong : productId) {
            orderRepository.customSave(basket.getId(),aLong);
        }
        return null;
    }


    @Override
    public void deleteById(Long primaryKey) {
        orderRepository.delete(primaryKey);
        basketRepository.deleteById(primaryKey);
    }


    //поиск всех заказов юзера
    public List<BasketDtoId> findByIdUserInBasket(Long primaryKey) {
        List <BasketDtoId> basketDtoIds=new ArrayList<>();
        List<Basket> basketsByUserId = basketRepository.findBasketsByUserId(primaryKey);//нашли заказы юзера
        System.out.println();
        for (Basket basket : basketsByUserId) {
            System.out.println(basket.getId());
            List<Long> productId = orderRepository.customFindAllByBasket(basket.getId());//нашли продукты по заказам
            basketDtoIds.add(DtoConverter.getInstance().BasketConvertToBasketDtoId(basket, productId));
        }
        return basketDtoIds;
    }

//поиск продуктов одного заказа
    public List<Product>findOneListProdutsByOrderId(Long idOrder){
        List<Long> productId =orderRepository.customFindAllByBasket(idOrder);
        List<Product> products=new ArrayList<>();


        for (int i = 0; i < productId.size(); i++) {
            Optional<Product> byId = productService.findById(productId.get(i));
            products.add(byId.get());
        }
        return products;
    }






    @Override
    public List<BasketDto> findAll() {
        return null;
    }




    @Override
    public void delete(BasketDto entity) {
    }

    @Override
    public Optional<BasketDto> findById(Long primaryKey) {
        return Optional.empty();
    }
}
