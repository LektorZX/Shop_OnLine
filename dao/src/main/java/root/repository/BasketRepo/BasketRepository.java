package root.repository.BasketRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import root.model.Basket;
import root.model.User;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface BasketRepository extends CrudRepository<Basket, Long>, CustomBasketRepository {
    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Basket basket);

    List<Basket> findBasketsByUserId(Long userId);



    //найти все заказы по айди юзера




//
//
//    Movie findByName(String name);
//
//    Movie findByNameAndDirectorFirstName(String name, String firstName);
//
//    @Query("select m " +
//            "from Movie m " +
//            "join m.director d " +
//            "where m.name = :name and d.firstName = :firstName")
//    Optional<Movie> customMethod(@Param("name") String movieName, @Param("firstName") String directorName);
//
//    @Query(value = "select m.* " +
//            "from movie_storage.movie m " +
//            "join movie_storage.director d " +
//            "   on m.director_id = d.id " +
//            "where m.name = :name and d.first_name = :firstName", nativeQuery = true)
//    Optional<Movie> customMethodNative(@Param("name") String movieName, @Param("firstName") String directorName);
//
//    @Query(value = "select m.name as name, d.id as directorId " +
//            "from movie_storage.movie m " +
//            "join movie_storage.director d " +
//            "   on m.director_id = d.id " +
//            "where m.name = :name and d.first_name = :firstName", nativeQuery = true)
//    Optional<MovieSecondDto> customMethodNative2(@Param("name") String movieName, @Param("firstName") String directorName);
//
//    @Query("select new com.matveyenka.spring.dto.MovieSecondDto(m.name, d.id) " +
//            "from Movie m " +
//            "join m.director d " +
//            "where m.name = :name and d.firstName = :firstName")
//    Optional<MovieSecondDto> customMethodNative3(@Param("name") String movieName, @Param("firstName") String directorName);
//
//
//    List<Movie> findAllByReleaseYearBetweenOrderByName(int startYear, int endYear, Pageable pageable);



//UPDATE!!!!!!!!!!!!!!!

    //////////////////////////////////////

//    @Query("select e from User e join e.company c where e.name = :name and c.name = :firstName")
//    Optional<User> customMethod(@Param("name") String nameEmployee, @Param("firstName") String nameCompany);
    ///////////////////////////////////////////////////////////////////
}


