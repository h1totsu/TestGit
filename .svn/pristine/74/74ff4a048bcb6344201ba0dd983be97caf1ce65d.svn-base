package com.nix.romanenko.tag;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.nix.romanenko.entity.User;

public class UsersTableTag extends SimpleTagSupport {
    private String      cssClass;
    private List<User>  users;

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        JspWriter writer = pageContext.getOut();
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("<table class=\"" + cssClass + "\">");
        sBuilder.append("<tr>");
        sBuilder.append("<th>Login</th><th>E-mail</th>");
        sBuilder.append("<th>First Name</th><th>Last Name</th><th>Age</th>");
        sBuilder.append("<th>Role</th><th>Actions</th>");
        sBuilder.append("</tr>");
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
            User user = iterator.next();
            sBuilder.append("<tr>");
            sBuilder.append("<td>" + user.getLogin() + "</td>");
            sBuilder.append("<td>" + user.getEmail() + "</td>");
            sBuilder.append("<td>" + user.getFirstname() + "</td>");
            sBuilder.append("<td>" + user.getLastname() + "</td>");
            sBuilder.append("<td>" + getAge(user.getBirthday()) + "</td>");
            sBuilder.append("<td>" + cutRole(user.getRole().getName()) + "</td>");
            sBuilder.append("<td>");
            sBuilder.append("<form method=\"post\" action=\"" 
            	+ pageContext.getServletContext().getContextPath() + "/service\">");
            sBuilder.append("<input type=\"hidden\" name=\"login\" value=\"" + 
                user.getLogin()+"\" />");
            sBuilder.append("<input type=\"submit\" value=\"Edit\"/>");
            sBuilder.append("</form>");
            sBuilder.append("<form method=\"post\" action=\"delete\">");    
            sBuilder.append("<input type=\"hidden\" name=\"login\" value=\"" + 
                user.getLogin()+"\" />");
            sBuilder.append("<input type=\"submit\" value=\"Delete\""
                + " onclick=\"return confirm('Are you sure?');\"/>");   
            sBuilder.append("</form>");
            sBuilder.append("</td>");
            sBuilder.append("</tr>");
        }
        sBuilder.append("</table>");      
        writer.println(sBuilder.toString());
    } 
    
    private int getAge(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis() - date.getTime());
        return c.get(Calendar.YEAR) - 1970;
    }
    
    private String cutRole(String role) {
    	return role.substring(5);
    }
}
