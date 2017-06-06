package controller.util.constants;

/**
 * Created by Zulu Warrior on 6/2/2017.
 */
public interface PagesPaths {
    String SITE_PREFIX = "/site";

    String USER_PREFIX = "/user";
    String ADMIN_PREFIX = "/admin";

    String HOME_PATH = "/home";
    String LOGIN_PATH = "/login";
    String SIGNUP_PATH = "/signup";
    String LOGOUT_PATH = "/logout";

    String USER_ACCOUNTS_PATH = USER_PREFIX + "/accounts";
    String USER_CARDS_PATH = USER_PREFIX + "/cards";
    String USER_PAYMENTS_PATH = USER_PREFIX + "/payments";
    String USER_BLOCK_ACCOUNT = USER_ACCOUNTS_PATH + "/block";
    String USER_CREATE_PAYMENT = USER_PREFIX + "/create";



}
