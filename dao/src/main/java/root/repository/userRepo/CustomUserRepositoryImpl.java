package root.repository.userRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import root.model.User;
import root.model.UserDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public CustomUserRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void updateUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateUserMail(User user, String mail) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(UserDetail.builder().email(mail).user(user).build());
        entityManager.getTransaction().commit();
    }

    @Override
    public User saveCustom(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String email = user.getUserDetail().getEmail();
        user.setUserDetail(null);
        TypedQuery<User> query;
        List<User> list;
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.flush();
        query = entityManager.createQuery("select u from User u where u.name = :name", User.class);
        query.setParameter("name", user.getName());
        list = query.getResultList();
        User user1 = list.get(0);
        entityManager.persist(UserDetail.builder().email(email).user(user1).build());
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }


}
