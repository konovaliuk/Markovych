package dao.abstraction;

import entity.Account;
import entity.Payment;
import entity.User;

import java.util.List;

/**
 * Created by Zulu Warrior on 5/21/2017.
 */
public interface PaymentDao extends GenericDao<Payment, Integer> {

    List<Payment> findByAccount(Account account);

    List<Payment> findByUser(User user);

}
