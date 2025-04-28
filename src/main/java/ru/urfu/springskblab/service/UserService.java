package ru.urfu.springskblab.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.urfu.springskblab.dto.UserInfoResponse;

@Service
public class UserService {

    public UserInfoResponse getUserInfo(UserDetails user) {
        return new UserInfoResponse(
                user.getUsername(),
                user.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .toList()
        );
    }

}
