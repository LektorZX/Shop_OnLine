package root.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.OneToOne;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@Entity
@Table(schema = "Online_Store", name = "user")
public class User extends BaseEntity<Long> {

    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

//    @OneToOne(mappedBy = "user")
    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
    @Cascade({CascadeType.ALL})
    private UserDetail userDetail;

    public User(String name) {
        this.name = name;
    }
}
