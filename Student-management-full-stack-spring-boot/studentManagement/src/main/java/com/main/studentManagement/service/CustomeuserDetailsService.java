package com.main.studentManagement.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.main.studentManagement.entity.Role;
import com.main.studentManagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.main.studentManagement.entity.User;
import com.main.studentManagement.repository.UserRepository;
@Service
public class CustomeuserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            user.isEnabled(),
            true,
            true,
            true,
            user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
            .collect(Collectors.toList())
        );
    }

    public User registerAdmin(String userName, String password){
        String encodedPassword = encoder.encode(password);
        Role userRole = roleRepository.findById("ADMIN").get();
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        return userRepository.save(new User(userName,encodedPassword,roles));
    }

    public User registerUser(String userName,String userFirstName,String userLastName, String password){
        String encodedPassword = encoder.encode(password);
        Role userRole = roleRepository.findById("USER").get();
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        return userRepository.save(new User(userName, encodedPassword, roles));
    }

}
