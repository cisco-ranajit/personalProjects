package com.medibill.main.loginusers;

import java.util.List;

public interface ILoginUserSerivce {
    LoginUsers createUser(LoginUsers users);
    List<LoginUsers> getEntityList();
    LoginUsers getEntityById(String userName);
    void deleteEntity(String userName);
    LoginUsers updateEntity(LoginUsers users, String userName);
}
