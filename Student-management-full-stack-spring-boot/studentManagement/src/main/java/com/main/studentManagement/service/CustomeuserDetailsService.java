package com.main.studentManagement.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import com.main.studentManagement.entity.Role;
import com.main.studentManagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.main.studentManagement.entity.User;
import com.main.studentManagement.repository.UserRepository;
import com.main.studentManagement.responseHandler.LoginResponse;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomeuserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    
    @Autowired
    public CustomeuserDetailsService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder, TokenService tokenService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }
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
    public LoginResponse loginUser(String userName, String password){
        try{
        Authentication auth =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String token = tokenService.generateJwtToken(auth);
        return new LoginResponse(userRepository.findById(userName).get(), token);
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw new EntityNotFoundException(e.getMessage());
        }
    }

}
