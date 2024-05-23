package com.example.MusicBlog.SECURITY;

import com.example.MusicBlog.MODELS.UserEntity;
import com.example.MusicBlog.REPOSITORY.UserEntityRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserEntityRepository userEntityRepository;

    public CustomUserDetailsService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userEntityRepository.findFirstByUserName(username);
        if (user != null){
            User authUser = new User(
                    user.getEmail(),
                    user.getPassword(),
                    user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.name()))
                            .collect(Collectors.toList())
            );
            return authUser;
        }else {
            throw new UsernameNotFoundException("Invalid UserName or Password");
        }
    }
}
