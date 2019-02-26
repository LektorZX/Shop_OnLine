package root.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import root.model.Product;
import root.model.Role;
import root.model.User;
import root.model.UserDetail;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

@Component
public class DatabaseHelper {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public DatabaseHelper(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void cleanDatabase() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from UserDetail").executeUpdate();
        entityManager.createQuery("delete from User").executeUpdate();
        entityManager.createQuery("delete from Product").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void prepareData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<User> query;
        List<User> list;
        entityManager.getTransaction().begin();
        for (int i = 0; i < 5; i++) {
            entityManager.persist(User.builder().name("Ivan"+i)
                    .password("12345"+i).role(Role.CLIENT).build());
        }
        for (int i = 0; i <30 ; i++) {
            entityManager.persist(Product.of("product"+i, BigDecimal.valueOf(123.11+i),
                    "Милкавита" ,"RB" ,107l-i ));
        }
        entityManager.flush();
        for (int i = 0; i < 5; i++) {
            query = entityManager.createQuery("select u from User u where u.name = :name", User.class);
            query.setParameter("name", "Ivan"+i);
            list = query.getResultList();
            User user = list.get(0);
            System.out.println();
            entityManager.persist(UserDetail.builder().email("123"+i).user(user).build());
        }
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
