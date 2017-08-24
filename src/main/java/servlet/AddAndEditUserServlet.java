package servlet;

import bean.UserBean;
import entity.ReferenceJeneral;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddAndEditUserServlet extends HttpServlet {

    @EJB
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        // если параметр null, то пользователь
        // пришел на страницу, чтобы создать нового, иначе
        // будет выполнятся редактирование существующего пользователя
        if(req.getParameter("edit") != null){
            long id = Long.valueOf(req.getParameter("edit"));
            ReferenceJeneral user = userBean.get(id);

            req.setAttribute("user", user);
        }

        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");

        // если id есть, то выполняется редактирование
        // а если нет id, то - это значит, что создается новый пользователь
        if(!"".equals(req.getParameter("id"))){
            long id = Long.valueOf(req.getParameter("id"));
            ReferenceJeneral user = userBean.get(id);
            user.setValue(lastName);
            user.setName(name);

            // обновляем пользователя
            userBean.update(user);
        } else{
            // добавляем нового
            //userBean.add(new User(name, lastName, age));
        }

        // перенаправляем на сервлет, который выводит все пользователей
        resp.sendRedirect("list");
    }
}
