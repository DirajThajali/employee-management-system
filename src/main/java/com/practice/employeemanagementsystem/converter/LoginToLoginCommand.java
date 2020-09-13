package com.practice.employeemanagementsystem.converter;

import com.practice.employeemanagementsystem.commands.LoginCommand;
import com.practice.employeemanagementsystem.model.Login;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class LoginToLoginCommand implements Converter<Login, LoginCommand> {

    @Nullable
    @Synchronized
    @Override
    public LoginCommand convert(Login source) {
        if (source != null) {
            LoginCommand loginCommand = new LoginCommand();
            loginCommand.setId(source.getId());
            loginCommand.setUserName(source.getUserName());
            loginCommand.setPassword(source.getPassword());
            return loginCommand;
        }
        return null;
    }
}
