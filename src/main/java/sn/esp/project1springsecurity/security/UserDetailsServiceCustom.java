package sn.esp.project1springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import sn.esp.project1springsecurity.entities.User;
import sn.esp.project1springsecurity.exceptions.BaseException;
import sn.esp.project1springsecurity.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.ObjectUtils;

import java.util.stream.Collectors;

public class UserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetailsCustom userDetailsCustom = getUserDetails(username);

        if(ObjectUtils.isEmpty(userDetailsCustom)){
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Invalid username or password!");
        }

        return userDetailsCustom;
    }

    private UserDetailsCustom getUserDetails(String username){
        User user = userRepository.findByUsername(username);

        if(ObjectUtils.isEmpty(user)){
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Invalid username or password!");
        }

        return new UserDetailsCustom(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getName()))
                        .collect(Collectors.toList())
        );
    }
}
