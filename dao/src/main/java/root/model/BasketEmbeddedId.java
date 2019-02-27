package root.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@Embeddable
public class BasketEmbeddedId implements Serializable {

    @Column(name = "order_id")
    private Long id;
}
