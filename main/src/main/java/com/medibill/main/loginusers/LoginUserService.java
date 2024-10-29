package com.medibill.main.loginusers;

import com.medibill.roleModule.Role;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.medibill.roleModule.RoleRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class LoginUserService implements ILoginUserSerivce, UserDetailsService{
    private final LoginUserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private AuthenticationManager authenticationManager;


    public LoginUserService(LoginUserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public LoginUsers createUser(LoginUsers users) {
        return userRepository.save(users);
    }

    @Override
    public List<LoginUsers> getEntityList() {
        return userRepository.findAll();
    }

    @Override
    public LoginUsers getEntityById(String name) {
        return userRepository.findById(name).orElseThrow(
            ()  -> new UsernameNotFoundException("User not found with id : " + name)
        );
    }

    @Override
    public void deleteEntity(String name) {
        userRepository.deleteById(name);;
    }

    @Override
    public LoginUsers updateEntity(LoginUsers users, String name) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUsers user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
        Set<Role> roles = (Set<Role>) user.getAuthorities();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities);
    }

    public LoginUsers registerAdmin(String userName,String userFirstName,String userLastName, String password){
        String encodedPassword = encoder.encode(password);
        Role userRole = roleRepository.findById(String.valueOf(Long.valueOf("ADMIN"))).get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepository.save(new LoginUsers(userName, userFirstName, userLastName, encodedPassword, authorities));
    }

    public LoginUsers registerUser(String userName,String userFirstName,String userLastName, String password){
        String encodedPassword = encoder.encode(password);
        Role userRole = roleRepository.findById(String.valueOf(Long.valueOf("USER"))).get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepository.save(new LoginUsers(userName, userFirstName, userLastName, encodedPassword, authorities));
    }

    // public LoginResponse loginUser(String userName, String password){
    //     try{
    //     Authentication auth =
    //             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
    //     SecurityContextHolder.getContext().setAuthentication(auth);
    //     // String token = tokenService.generateJwt(auth);
    //     return new LoginResponse(userRepository.findById(userName).get(), token);
    //     } catch (Exception e){
    //         System.out.println(e.getMessage());
    //         throw new EntityNotFoundException(e.getMessage());
    //     }
    // }
    
}