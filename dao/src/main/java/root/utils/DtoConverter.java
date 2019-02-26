package root.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import root.DTO.ProductDto;
import root.DTO.UserDto;
import root.model.Product;
import root.model.Role;
import root.model.User;
import root.model.UserDetail;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DtoConverter {
    private static final DtoConverter INSTANCE = new DtoConverter();

    public static DtoConverter getInstance() {
        return INSTANCE;
    }

    public UserDto UserConvertToUserDto(User user) {
        return UserDto.builder().name(user.getName()).
                id(user.getId()).password(user.getPassword())
                .role(user.getRole().getName())
                .email(user.getUserDetail()
                .getEmail()).build();
    }
    public User UserDtoConvertToUser(UserDto userDto) {
        return User.builder().name(userDto.getName())
                .password(userDto.getPassword())
                .role(Role.getByName(userDto.getRole()))
                .userDetail(UserDetail.builder()
                .email(userDto.getEmail()).build())
                .build();
    }
    public Product ProductDtoConvertToProduct(ProductDto productDto){
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .remark(productDto.getRemark())
                .origin(productDto.getOrigin())
                .amount(productDto.getAmount())
                .build();
    }
    public ProductDto ProductConvertToProductDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .remark(product.getRemark())
                .origin(product.getOrigin())
                .amount(product.getAmount())
                .build();
    }


}
