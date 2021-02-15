package com.eddev.zeru.securities;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.eddev.zeru.models.enums.ProfileType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserSpringSecurity implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Getter
    private BigInteger id;
    private String email;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserSpringSecurity(BigInteger id, String email, String password, Set<ProfileType> profiles) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = profiles.stream().map(p -> new SimpleGrantedAuthority(p.getIdProfileType()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}