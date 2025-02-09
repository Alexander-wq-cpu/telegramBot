package ru.relex.service;

import ru.relex.entity.AppUser;

public interface AppUserService {
    String registerUser(AppUser user);
    String setEmail(AppUser user,String email);
}
