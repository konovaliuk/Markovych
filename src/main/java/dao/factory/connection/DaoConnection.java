package dao.factory.connection;

/**
 * Created by Zulu Warrior on 5/21/2017.
 */
public interface DaoConnection extends AutoCloseable{

    void startTransaction();

    void startSerializableTransaction();

    void commit();

    void rollback();

    Object getSpecificConnection();

    @Override
    void close();

}
