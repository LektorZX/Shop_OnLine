package root.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String role;
    private String email;
}
