package controller.util;

import controller.ControllerHelper;
import controller.util.constants.Attributes;
import controller.util.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Zulu Warrior on 6/2/2017.
 */
public class Util {

    public static void redirectTo(HttpServletRequest request,
                                  HttpServletResponse response,
                                  String pageToRedirect) throws IOException {
        response.sendRedirect(request.getServletPath() + pageToRedirect);
    }

    public static boolean isAlreadyLoggedIn(HttpSession session) {
        return session.getAttribute(Attributes.USER) != null;
    }

    public static <T> void validateField(Validator<T> validator,
                                         T field,
                                         List<String> errors) {
        if(!validator.isValid(field)) {
            errors.add(validator.getErrorKey());
        }
    }


}
