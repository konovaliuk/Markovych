package dao.impl.mysql.converter;

import entity.Account;
import entity.Card;
import entity.User;
import entity.enums.CardType;
import dao.util.time.TimeConverter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Zulu Warrior on 5/22/2017.
 */
public class DtoCardConverter implements DtoConverter<Card> {

    private final DtoConverter<Account> accountConverter;
    private final DtoConverter<User> userConverter;

    public DtoCardConverter() {
        this(new DtoAccountConverter(),
                new DtoUserConverter());
    }

    public DtoCardConverter(DtoConverter<Account> accountConverter,
                            DtoConverter<User> userConverter) {
        this.accountConverter = accountConverter;
        this.userConverter = userConverter;
    }

    @Override
    public Card convertToObject(ResultSet resultSet, String tablePrefix)
            throws SQLException {

        Account cardAccount = accountConverter.
                convertToObject(resultSet);

        User cardHolder = userConverter.
                convertToObject(resultSet);

        Card card = Card.newBuilder().
                setCardNumber(resultSet.getLong(
                        tablePrefix + "card_number")).
                setCardHolder(cardHolder).
                setAccount(cardAccount).
                setPin(resultSet.getInt(
                        tablePrefix + "pin")).
                setCvv(resultSet.getInt(
                        tablePrefix + "cvv")).
                setExpireDate(TimeConverter.toDate(
                        resultSet.getTimestamp(
                                tablePrefix + "expire_date"))).
                setType(CardType.valueOf(
                        resultSet.getString(
                                tablePrefix + "type"))).
                build();

        return card;
    }
}
