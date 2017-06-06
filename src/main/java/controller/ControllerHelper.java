package controller;

import controller.command.DefaultCommand;
import controller.command.HomeCommand;
import controller.command.ICommand;
import controller.command.authorization.*;
import controller.command.user.*;
import controller.util.constants.PagesPaths;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zulu Warrior on 5/28/2017.
 */
public class ControllerHelper {
    private final static String DELIMITER = ":";
    private final DefaultCommand DEFAULT_COMMAND = new DefaultCommand();
    private Map<String, ICommand> commands = new HashMap<>();

    private ControllerHelper() {
        init();
    }

    private void init() {
        commands.put(buildKey(PagesPaths.HOME_PATH, Method.GET),
                new HomeCommand());
        commands.put(buildKey(PagesPaths.LOGIN_PATH, Method.GET),
                new GetLoginCommand());
        commands.put(buildKey(PagesPaths.SIGNUP_PATH, Method.GET),
                new GetSignupCommand());
        commands.put(buildKey(PagesPaths.LOGIN_PATH, Method.POST),
                new PostLoginCommand());
        commands.put(buildKey(PagesPaths.SIGNUP_PATH, Method.POST),
                new PostSignupCommand());
        commands.put(buildKey(PagesPaths.LOGOUT_PATH, Method.GET),
                new LogoutCommand());
        commands.put(buildKey(PagesPaths.USER_ACCOUNTS_PATH, Method.GET),
                new GetAccountsCommand());
        commands.put(buildKey(PagesPaths.USER_CARDS_PATH, Method.GET),
                new GetCardsCommand());
        commands.put(buildKey(PagesPaths.USER_PAYMENTS_PATH, Method.GET),
                new ShowPaymentsCommand());
        commands.put(buildKey(PagesPaths.USER_BLOCK_ACCOUNT, Method.POST),
                new BlockAccountCommand());
        commands.put(buildKey(PagesPaths.USER_CREATE_PAYMENT, Method.GET),
                new GetCreatePaymentCommand());
    }

    public ICommand getCommand(String path, Method method) {
        return commands.getOrDefault(buildKey(path, method), DEFAULT_COMMAND);
    }

    private String buildKey(String path, Method method) {
        return method.name() + DELIMITER + path;
    }

    public enum Method {
        GET, POST
    }

    public static class Singleton {
        private final static ControllerHelper INSTANCE =
                new ControllerHelper();

        public static ControllerHelper getInstance() {
            return INSTANCE;
        }
    }


}
