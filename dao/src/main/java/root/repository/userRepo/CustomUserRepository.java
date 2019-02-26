package root.repository.userRepo;
import root.model.User;

public interface CustomUserRepository {

    void updateUser(User user) ;
    void updateUserMail(User user,String mail) ;
    User saveCustom(User user) ;


}
