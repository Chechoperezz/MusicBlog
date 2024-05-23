package com.example.MusicBlog.REPOSITORY;

import com.example.MusicBlog.MODELS.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByUserName(String userName);
    UserEntity findByEmail(String Email);
    UserEntity findFirstByUserName(String username);
}
