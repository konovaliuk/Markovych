package controller.command.user;

import controller.command.ICommand;
import controller.util.Util;
import controller.util.constants.Attributes;
import controller.util.constants.PagesPaths;
import controller.util.constants.Views;
import entity.Account;
import entity.User;
import service.AccountService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Zulu Warrior on 6/5/2017.
 */
public class BlockAccountCommand implements ICommand {
    private final static String ACCOUNT_PARAM = "account";
    private final static String ACCOUNT_BLOCKED = "account.successfully.blocked";

    private final AccountService accountService = ServiceFactory.getAccountService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Optional<Account> account = getAccountFromRequest(request);

        if(account.isPresent()) {
            blockAccount(account.get());
            addSuccessMessageToRequest(request);

            User user = getUserFromSession(request.getSession());
            List<Account> accounts = accountService.findAllByUser(user);
            request.setAttribute(Attributes.ACCOUNTS, accounts);
            
            return Views.ACCOUNTS_VIEW;
        }

        Util.redirectTo(request, response, PagesPaths.HOME_PATH);
        return REDIRECTED;
    }

    private Optional<Account> getAccountFromRequest(HttpServletRequest request) {
        long accountNumber = Long.valueOf(request.getParameter(ACCOUNT_PARAM));
        return accountService.findAccountByNumber(accountNumber);
    }

    private void blockAccount(Account account) {
        accountService.updateAccountStatus(account, Account.Status.BLOCKED);
    }

    private void addSuccessMessageToRequest(HttpServletRequest request) {
        List<String> messages = new ArrayList<>();
        messages.add(ACCOUNT_BLOCKED);
        request.setAttribute(Attributes.MESSAGES, messages);
    }

    private User getUserFromSession(HttpSession session) {
        return (User) session.getAttribute(Attributes.USER);
    }
}
