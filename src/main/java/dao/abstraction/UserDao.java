package dao.abstraction;

import entity.User;

import java.util.Optional;

/**
 * Created by Zulu Warrior on 5/21/2017.
 */
public interface UserDao extends GenericDao<User, Integer>{

    Optional<User> findOneByEmail(String email);

    boolean existByEmail(String email);
}
