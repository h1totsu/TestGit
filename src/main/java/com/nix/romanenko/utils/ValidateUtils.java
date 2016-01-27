package com.nix.romanenko.utils;

import java.io.OutputStream;
import java.net.URL;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Named;
import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.nix.romanenko.dao.UserDao;
import com.nix.romanenko.entity.User;
import com.opensymphony.xwork2.ActionContext;

@Named("validateUtils")
public class ValidateUtils {
    @Autowired
    private UserDao userDao;
    
    private final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final String LOGIN_PATTERN = "^[a-zA-Z0-9_-]{3,15}$";  
    private final String PASSWORD_PATTERN = 
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!?@#$%]).{6,20})";
    
    private final String CAPTCHA_URL = "https://www.google.com/recaptcha/api/"
    	+ "siteverify";
    
    private Pattern pattern;
    private Matcher matcher;
    
    public boolean validateFieldsEmpty(String... fields) {
        for (String field : fields) {
            if (field.length() < 1) {
                return false;
            }
        }
        return true;
    }
    
    public boolean validateDate(String dateString) {
        try {
            Date.valueOf(dateString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean checkUserExists(String login) {
        User user = userDao.findByLogin(login);
        if (user != null) {
            return true;
        }
        return false;
    }
    
    public boolean validateEmail(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public boolean validateLogin(String login) {
        pattern = Pattern.compile(LOGIN_PATTERN);
        matcher = pattern.matcher(login);
        return matcher.matches();
    }
    
    public boolean validatePassword(String pass) {
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(pass);
        return matcher.matches();
    }
    
    public boolean checkEmailExists(String email, String login) {
        User user = userDao.findByEmail(email);
        if (user != null) {
            if (login != null) {
                if (!user.getLogin().equals(login)) {
                    return true;
                } 
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkPasswordMatch(String password, String rePass) {
        if (!password.equals(rePass)) {
            return false;
        }
        return true;
    }
    
    public boolean checkRoleChanged(String login, String role) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        GrantedAuthority authority = auth.getAuthorities().iterator().next();
        if (auth.getName().equals(login) 
                && !authority.getAuthority().equals(role)) {
            return true;
        }
        return false;
    }
    
    public boolean validateCaptcha() {
    	String captchaResponse = ((String[]) ActionContext.getContext()
                .getParameters().get("g-recaptcha-response"))[0];
    	if (captchaResponse == null || captchaResponse.length() == 0) {
            return false;
        }
        try {
            URL verifyUrl = new URL(CAPTCHA_URL);

            HttpsURLConnection conn = (HttpsURLConnection) verifyUrl
                    .openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            String postParams = "secret="
                    + "6Lda9xQTAAAAAMOsY3F38DC-y8XbA1BmNJkp-0Is" + "&response="
                    + captchaResponse;
            conn.setDoOutput(true);
            OutputStream outStream = conn.getOutputStream();
            outStream.write(postParams.getBytes());
            outStream.flush();
            outStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
