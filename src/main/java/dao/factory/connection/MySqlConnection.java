package dao.factory.connection;

import dao.exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Zulu Warrior on 5/21/2017.
 */
public class MySqlConnection implements DaoConnection {
    private final Connection connection;
    private boolean isTransactionActive;

    public MySqlConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void startTransaction() {
        try {
            connection.setAutoCommit(false);
            isTransactionActive = true;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
    @Override
    public void startSerializableTransaction() {
        try {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            isTransactionActive = true;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void commit() {
        try {
            connection.commit();
            connection.setAutoCommit(true);
            isTransactionActive = false;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
            isTransactionActive = false;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Object getSpecificConnection() {
        return connection;
    }

    @Override
    public void close() {
        if(isTransactionActive) {
            rollback();
        }

        try {
            if (connection != null) {
                connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
                connection.close();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
