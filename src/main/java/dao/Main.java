package dao;

import dao.abstraction.AccountDao;
import dao.exception.DaoException;
import dao.factory.DaoFactory;
import dao.factory.connection.DaoConnection;
import entity.Account;
import entity.Card;
import entity.Role;
import entity.User;
import entity.enums.CardType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Zulu Warrior on 5/23/2017.
 */
public class Main {


    public static void main(String[] args) {
        DaoFactory factory = DaoFactory.getInstance();
        Role utilRole = new Role(2, "role2");

        User testUser = User.newBuilder()
                .setId(1)
                .setRole(utilRole)
                .setFirstName("Johnny")
                .setLastName("Cash")
                .setEmail("1234@i.ua")
                .setPassword("86y4hfrhd63u")
                .setPhoneNumber("0-800-88-88-888")
                .build();

        Account accountUtil = new Account(
                223456789L, testUser,
                new BigDecimal(28.56), Account.Status.PENDING
        );

        Card cardUtil = Card.newBuilder().
                setCardNumber(111222333444L).
                setCardHolder(testUser).
                setAccount(accountUtil).
                setPin(1111).
                setCvv(123).
                setExpireDate(new Date()).
                setType(CardType.MASTERCARD).
                build();
        try (DaoConnection connection = factory.getConnection()){
            AccountDao accountDao = factory.getAccountDao(connection);

            List<Account> account = accountDao.findByStatus(Account.Status.PENDING);

            System.out.println(account);

//            CardDao cardDao = factory.getCardDao(connection);
//
//            Optional<Card> card = cardDao.findOne(1111222233334444L);
//
//            card.get().setType(CardType.MASTERCARD);
//
//            cardDao.update(card.get());
        } catch (DaoException e) {
            System.err.print(e.getMessage());
        }



    }

}
