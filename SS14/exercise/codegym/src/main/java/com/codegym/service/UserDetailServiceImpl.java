package com.codegym.service;

import com.codegym.dao.AppRoleDAO;
import com.codegym.dao.AppUserDAO;
import com.codegym.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private AppUserDAO appUserDAO;
    @Autowired
    private AppRoleDAO appRoleDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = this.appUserDAO.findUserAccount(username);

        if (appUser == null) {
            throw new UsernameNotFoundException("User: " + username + " was not found");
        }

        List<String> roleName = this.appRoleDAO.getRoleNames(appUser.getUserId());

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

        if (roleName != null) {
            for (String role : roleName) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantedAuthorities.add(authority);
            }
        }

        UserDetails userDetails = new User(appUser.getUserName(),
                appUser.getEncryptedPassword(), grantedAuthorities);
        return userDetails;
    }
}
