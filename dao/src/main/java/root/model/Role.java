package root.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Arrays;

@Getter
@NoArgsConstructor
public enum Role {
    ADMIN("admin"),CLIENT ("client");

    private String name;

    Role(String name){
        this.name = name;
    }

    public static Role getByName(String name) {
        return Arrays.stream(values())
                .filter(it -> it.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
    public static int getIntStatus(Role status) {
        int result;
        if(status.name.equals("client"))
            return 1;
        else return 2;
    }
    public static Role getIntToStringStatus(String status) {
        if(status.equals("1")){
            return Role.getByName("client");
        }
        else return Role.getByName("admin");
    }
    public static String getStringStatus(Role status) {
        if(status.name.equals("client"))
            return "client";
        else return "admin";
    }

}
