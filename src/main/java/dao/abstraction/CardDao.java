package dao.abstraction;

import entity.Account;
import entity.Card;
import entity.User;

import java.util.List;

/**
 * Created by Zulu Warrior on 5/21/2017.
 */
public interface CardDao extends GenericDao<Card, Long> {
    List<Card> findByUser(User user);

    List<Card> findByAccount(Account account);
}
