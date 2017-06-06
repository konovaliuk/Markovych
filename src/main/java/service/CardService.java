package service;

import dao.abstraction.CardDao;
import dao.factory.DaoFactory;
import dao.factory.connection.DaoConnection;
import entity.Account;
import entity.Card;
import entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by Zulu Warrior on 5/27/2017.
 */
public class CardService {
    private final DaoFactory daoFactory= DaoFactory.getInstance();

    private CardService() {}

    public static class Singleton {
        private final static CardService INSTANCE = new CardService();

        public static CardService getInstance() {
            return INSTANCE;
        }
    }

    public List<Card> findAllCards() {
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDao cardDao = daoFactory.getCardDao(connection);
            return cardDao.findAll();
        }
    }

    public Optional<Card> findCardByNumber(long cardNumber) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDao cardDao = daoFactory.getCardDao(connection);
            return cardDao.findOne(cardNumber);
        }
    }

    public List<Card> findAllByUser(User user) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDao cardDao = daoFactory.getCardDao(connection);
            return cardDao.findByUser(user);
        }
    }

    public List<Card> findAllByAccount(Account account) {
        try(DaoConnection connection = daoFactory.getConnection()) {
            CardDao cardDao = daoFactory.getCardDao(connection);
            return cardDao.findByAccount(account);
        }
    }


}
