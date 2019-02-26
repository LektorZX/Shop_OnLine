package root.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "product", schema = "Online_Store")
public class Product extends BaseEntity<Long> {

    private String name;
    private BigDecimal price;
    private String remark;
    private String origin;
    private Long amount;

}
