package dao.abstraction;

import entity.Account;
import entity.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Zulu Warrior on 5/21/2017.
 */
public interface AccountDao extends GenericDao<Account, Long> {
    List<Account> findByUser(User user);
    List<Account> findByStatus(Account.Status status);

    void increaseBalance(Account account, BigDecimal amount);
    void decreaseBalance(Account account, BigDecimal amount);

    void updateAccountStatus(Account account, Account.Status status);

}
