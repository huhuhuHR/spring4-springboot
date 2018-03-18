package com.huorong.login;

public class LoginServiceImpl implements ILoginService {
    @Override
    public boolean login(String userName, String password) {
        System.out.println("login:" + userName + "," + password);
        return true;
    }

    @Override
    public void login() {
        System.out.println("login");
    }
}
