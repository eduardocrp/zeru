package com.eddev.zeru.services;

import com.eddev.zeru.models.User;
import com.eddev.zeru.repositories.UserRepository;
import com.eddev.zeru.securities.UserSpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException(email);

        return new UserSpringSecurity(user.getIdUser(), user.getEmail(), user.getPassword(), user.getProfilesType());
    }

}