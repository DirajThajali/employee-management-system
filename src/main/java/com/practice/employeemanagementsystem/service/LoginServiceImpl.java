package com.practice.employeemanagementsystem.service;

import com.practice.employeemanagementsystem.model.Login;
import com.practice.employeemanagementsystem.repositories.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {


    private final LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login saveLogin(Login login) {
        return loginRepository.save(login);
    }
}
