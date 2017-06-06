package controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zulu Warrior on 5/28/2017.
 */
public interface ICommand {
    String REDIRECTED ="REDIRECTED";


    String execute(HttpServletRequest request,
                   HttpServletResponse response)
            throws ServletException, IOException;
}
