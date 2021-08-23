package com.morelllcrm.services;

import com.morelllcrm.entities.Users;
import com.morelllcrm.exception.UserNotFoundException;
import com.morelllcrm.exception.UserNotVerifiedException;
import com.morelllcrm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email)  {
        Users user = userRepository.findByEmailId(email);
        if (user==null) {
            throw new UserNotFoundException("User not found");
        }
//        if(!user.getEmailVerified())
//            throw new UserNotVerifiedException("User with email "+user.getUsername()+ " is not verified!");
        return (UserDetails) user;
    }

    @Transactional
    public Users loadUserById(long id){
        Users user =userRepository.getById(id);
        if (user==null) {
            assert false;
            throw new UsernameNotFoundException("User with id "+user.getId()+" not found");
        }
        return user;
    }


}
