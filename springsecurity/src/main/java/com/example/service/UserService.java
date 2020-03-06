package com.example.service;

import com.example.bean.Role;
import com.example.bean.User;
import com.example.mapper.RoleMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Administrator on 2020/3/6.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.getUserByName(s);
        if(user == null){
            return (UserDetails) new User();
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        List<Role> roles = roleMapper.getRoleByUid(user.getId());
        for (Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        user.setRoles(roles);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    public int registUser(User user) {
        String p = encoder.encode(user.getPassword());
        user.setPassword(p);
        userMapper.addUser(user);

        if(user.getUsername().equals("root")){
            roleMapper.setRole(1, user.getId());
        }else {
            roleMapper.setRole(2, user.getId());
        }
        return 1;
    }
}
