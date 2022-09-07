package com.ll.exam.sbb.user.service;

import com.ll.exam.sbb.user.SiteUser;
import com.ll.exam.sbb.user.UserRole;
import com.ll.exam.sbb.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    // 시큐리티가 특정 회원의 username을 받았을 때
    // 그 username에 해당하는 회원정보를 얻는 수단
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SiteUser siteUser = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("사용자를 찾을수 없습니다.")
        );

        // 권한들을 담을 빈 리스트를 만든다.
        List<GrantedAuthority> authorities = new ArrayList<>();

        if ("admin".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }

        return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);
    }
}
