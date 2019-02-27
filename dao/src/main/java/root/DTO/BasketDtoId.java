package root.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
public class BasketDtoId {
    private Long id;
    private Long userId;
    private LocalDate localDate;
    private BigDecimal sum;
    private List<Long> productId;
}
