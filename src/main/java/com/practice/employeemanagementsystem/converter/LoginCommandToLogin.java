package com.practice.employeemanagementsystem.converter;

import com.practice.employeemanagementsystem.commands.LoginCommand;
import com.practice.employeemanagementsystem.model.Login;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class LoginCommandToLogin implements Converter<LoginCommand, Login> {


    @Nullable
    @Synchronized
    @Override
    public Login convert(LoginCommand source) {
        if (source != null) {
            Login login = new Login();
            login.setId(source.getId());
            login.setUserName(source.getUserName());
            login.setPassword(source.getPassword());
            return login;
        }
        return null;
    }
}
