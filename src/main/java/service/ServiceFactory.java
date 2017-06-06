package service;

import dao.factory.DaoFactory;
import entity.Account;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Zulu Warrior on 5/27/2017.
 */
public class ServiceFactory {
    private static ServiceFactory instance;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        if(instance == null) {
            instance = new ServiceFactory();
        }

        return instance;
    }


    public static UserService getUserService() {
        return UserService.Singleton.getInstance();
    }

    public static AccountService getAccountService() {
        return AccountService.Singleton.getInstance();
    }

    public static CardService getCardService() {
        return CardService.Singleton.getInstance();
    }

    public static PaymentService getPaymentService() {
        return PaymentService.Singleton.getInstance();
    }


}
