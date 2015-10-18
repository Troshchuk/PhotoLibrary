package com.troshchuk.photoLibrary.security;

import com.troshchuk.photoLibrary.domain.Role;
import com.troshchuk.photoLibrary.domain.User;
import com.troshchuk.photoLibrary.service.UserService;
import com.troshchuk.photoLibrary.service.impl.UserServiceImpl;
import org.apache.commons.collections.list.GrowthList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  10.09.14.
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    public UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication)
    throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userService.read(email, password);

        if (user != null) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
            for (Role role : user.getRoles()) {
                GrantedAuthority grantedAuthority = new GrantedAuthorityImpl(role.getRole());
                grantedAuthorities.add(grantedAuthority);
            }

            return new UsernamePasswordAuthenticationToken(email, password, grantedAuthorities);
        }


        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
