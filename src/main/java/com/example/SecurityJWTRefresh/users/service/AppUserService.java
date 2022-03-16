package com.example.SecurityJWTRefresh.users.service;

import com.example.SecurityJWTRefresh.users.domain.AppUser;
import com.example.SecurityJWTRefresh.users.domain.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
