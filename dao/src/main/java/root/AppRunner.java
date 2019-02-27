package root;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import root.DTO.BasketDto;
import root.DTO.BasketDtoId;
import root.DTO.ProductDto;
import root.DTO.UserDto;
import root.configuration.ApplicationConfiguration;
import root.model.Product;
import root.model.Role;
import root.model.User;
import root.model.UserDetail;
import root.repository.userRepo.CustomUserRepositoryImpl;
import root.service.BasketServiceImpl;
import root.service.UserServiceImpl;
import org.springframework.test.context.ContextConfiguration;
import root.service.ProductServiceImpl;
import root.utils.DatabaseHelper;
import root.utils.DtoConverter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = ApplicationConfiguration.class)
public class AppRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        DatabaseHelper databaseHelper= (DatabaseHelper) context.getBean("databaseHelper");
//        databaseHelper.cleanDatabase();
//        databaseHelper.prepareData();
//        userTest(context);+++
//        ProductTest(context);+++
//        TestConvertDTO(context);+++
//        testBasket(context);



    }

    private static void testBasket(AnnotationConfigApplicationContext context) {
        BasketServiceImpl basketServiceImpl = (BasketServiceImpl) context.getBean("basketServiceImpl");
        //проверка создание ордера+++
//        for (int i = 0; i < 5; i++) {
//            List<Long> productId2=new ArrayList<>();
//            productId2.add(5L);
//            productId2.add(6L);
//            productId2.add(7L);
//            productId2.add(8L);
//            productId2.add(9L);
//            productId2.add(2L);
//            productId2.add(3L);
//            productId2.add(4L);
//            basketServiceImpl.save(BasketDto.builder()
//                    .userId(4L)
//                    .localDate(LocalDate.now())
//                    .sum(BigDecimal.valueOf(999))
//                    .productId(productId2)
//                    .build());
//        }


        //вывод списка товаров по одному оредеру+++
        List<Product> oneListProdutsByOrderId = basketServiceImpl.findOneListProdutsByOrderId(7l);
        for (Product product : oneListProdutsByOrderId) {
            System.out.println(product);
        }

//удаление работает+++
//        basketServiceImpl.deleteById(5l);

        //список всех заказов юзера по айди юзера+++
        List<BasketDtoId> byIdUserInBasket = basketServiceImpl.findByIdUserInBasket(7l);
        for (BasketDtoId basketDtoId : byIdUserInBasket) {
            System.out.println(basketDtoId);
        }
    }

    private static void TestConvertDTO(AnnotationConfigApplicationContext context) {
        DtoConverter instance = DtoConverter.getInstance();
        ProductServiceImpl productServiceImpl = (ProductServiceImpl) context.getBean("productServiceImpl");
        Optional<Product> byId = productServiceImpl.findById(310l);
        Product product = byId.get();
        System.out.println(product);
        ProductDto productDto1 = instance.ProductConvertToProductDto(product);
        System.out.println(productDto1+"+++++++++++++++++++++++++++");

        ProductDto productDto = ProductDto.builder()
                .name("333")
                .price(BigDecimal.valueOf(333))
                .remark("333")
                .origin("333")
                .amount(333l)
                .build();
        System.out.println(productDto);
        Product product1 = instance.ProductDtoConvertToProduct(productDto);
        System.out.println(product1+"+++++++++++++++++++++++++++");

        ////////////////////////////////////
        UserDto clientDto = UserDto.builder()
                .name("333")
                .password("333")
                .role("client")
                .email("333")
                .build();

        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        Optional<User> byId2 = userServiceImpl.findById(63l);
        User user = byId2.get();

        UserDto userDto = instance.UserConvertToUserDto(user);
        System.out.println(userDto);
        User user1 = instance.UserDtoConvertToUser(clientDto);
        System.out.println(user1+"-------------------------------------------");
    }


    private static void ProductTest(AnnotationConfigApplicationContext context) {
        ProductServiceImpl productServiceImpl = (ProductServiceImpl) context.getBean("productServiceImpl");
        Product test = Product.builder().name("111").price(BigDecimal.valueOf(111))
                .remark("111").origin("111").amount(111l).build();
//        productServiceImpl.save(test);
        Optional<Product> byId = productServiceImpl.findById(332l);
        Product product = byId.get();
        System.out.println(product);
        productServiceImpl.deleteById(332l);


//        productServiceImpl.update(test);
//        List<Product> all = productServiceImpl.findAll();
//        for (Product product : all) {
//            System.out.println(product);
//        }
//        productServiceImpl.delete(test);
        System.out.println();
    }

    private static void userTest(AnnotationConfigApplicationContext context) {
        //+++++++++++++++++++ del update user
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
//        Optional<User> byId = userServiceImpl.findById(43l);
//        User user = byId.get();
//        System.out.println();
////        user.setName("11111111111");
//        userServiceImpl.delete(user);
//        System.out.println();


        ///////////// update mail+++
//        Optional<User> byId = userServiceImpl.findById(43l);
//        User user = byId.get();
//        System.out.println();
////        user.setName("11111111111");
//        userServiceImpl.delete(user);
//        System.out.println();


        ///////////// save user+++
        User user=User.of("2223","2223" ,Role.CLIENT ,UserDetail.builder().email("2223").build() );
        User save = userServiceImpl.save(user);
        System.out.println(save);
        System.out.println();
        ////////////////
    }


}
