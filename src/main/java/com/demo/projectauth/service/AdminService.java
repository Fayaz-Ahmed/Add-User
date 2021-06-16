package com.demo.projectauth.service;

import com.demo.projectauth.controller.MailController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import com.demo.projectauth.Repository.UserRepository;
import com.demo.projectauth.entity.User;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Random;

@Service
public class AdminService {
    public UserService userservice;
    public UserRepository repository;
    public MailController mailController;

    public AdminService(UserService userservice, MailController mailController) {
        this.userservice = userservice;
        this.mailController = mailController;
    }

    public User createUser(User user) {
        Random rmd = new Random();
        int r = 100000 + rmd.nextInt(999999);
        user.setPassword(String.valueOf(r));
        User u = userservice.create(user);

        passwordMail(u.getEmail(), u.getPassword());
        return u;
    }

    public void passwordMail(String email, String password) {

        MultiValueMap<String, String> mMap = new LinkedMultiValueMap<>();
        mMap.add("emailTo", email);
        mMap.add("emailFrom", "teamaliens.b18it@gmail.com");
        mMap.add("emailSubject", "Account Credentials");
        mMap.add("emailContent", "Hello from Eagle Eye Tech One "+"\n" + "Please use the following password to log in to the system " + "\n " + password + "\n"
                + "Please be kind to change the password soon after your first login"
        );

        mailController.sendmail(mMap);

    }

}
