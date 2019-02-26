package root.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import root.model.User;
import root.repository.userRepo.UserRepository;

import java.util.List;
import java.util.Optional;
@Data
@Service
public class UserServiceImpl implements BaseService<User,Long> {


    @Autowired
    UserRepository userRepository;

    @Override
    public <S extends User> S save(S entity) {
        return (S) userRepository.saveCustom(entity);
    }

    @Override
    public Optional<User> findById(Long primaryKey) {
        return userRepository.findById(primaryKey);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteById(Long primaryKey) {
        userRepository.deleteById(primaryKey);
    }

    public void update(User user){
        userRepository.updateUser(user);
    }

}
