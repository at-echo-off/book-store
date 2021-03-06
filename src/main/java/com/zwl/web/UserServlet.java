package com.zwl.web;

import com.google.gson.Gson;
import com.zwl.pojo.User;
import com.zwl.service.UserService;
import com.zwl.service.impl.UserServiceImpl;
import com.zwl.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");

        boolean existsUsername = userService.existsUsername(username);

        Map<String,Object> result = new HashMap<>();
        result.put("existsUsername",existsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(result);

        resp.getWriter().write(json);

    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.login(new User(null, username, password, null));

        if (loginUser == null){

            if ("".equals(username) || "".equals(password)){
                req.setAttribute("msg","请输入用户名和密码");
            }else {
                req.setAttribute("msg","用户名或密码错误！");
            }
            req.setAttribute("username",username);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {

            req.getSession().setAttribute("user",loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");


        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());

//        System.out.println(user);
        if (token.equalsIgnoreCase(code)){
            if (!userService.existsUsername(username)){
                userService.registUser(new User(null,username,password,email));
//                System.out.println("注册成功");
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }else {
//                System.out.println("用户名已存在");

                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }
        }else {
//            System.out.println("验证码错误");

            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath() + "/index.jsp");

    }
}
