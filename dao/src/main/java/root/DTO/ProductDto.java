package root.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String remark;
    private String origin;
    private Long amount;

}
