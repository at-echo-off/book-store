package com.zwl.filter;

import com.zwl.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        User user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
        if (user == null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        } else if (user.getId() != 1){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        } else{
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
    }
}
