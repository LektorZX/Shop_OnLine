package root.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "user_detail", schema = "Online_Store")
public class UserDetail extends BaseEntity<Long> {

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;


    private String email;

//    @OneToOne
//    @JoinColumn(name = "user_id")
//    @PrimaryKeyJoinColumn
//    private User user;
}
