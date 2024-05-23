package com.example.MusicBlog.SERVICE.impl;

import com.example.MusicBlog.SERVICE.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {
//    private UserRepository userRepository;
//
//
//    public UserServiceImp (UserRepository userRepository){
//        this.userRepository=userRepository;
//    }
//
//    @Override
//    public List<UsersDTO> findAllUsers(){
//        List<Users> users = userRepository.findAll();
//        return users.stream().map((Users) -> MapUserToDTO(Users)).collect(Collectors.toList());
//    }
//
//    @Override
//    public Users save(Users users) {
//         return userRepository.save(users);
//
//    }
//
//    @Override
//    public void UpdateUser(UsersDTO userDTO) {
//        Users users = MapUserDTOToUser(userDTO);
//        userRepository.save(users);
//    }
//
//    @Override
//    public UsersDTO findByUserId(Long userId) {
//        Users users = userRepository.findById(userId).get();
//        return MapUserToDTO(users) ;
//    }
//
//    @Override
//    public List<UsersDTO> searchUser(String query) {
//        List<Users> users = userRepository.searchUsers(query);
//        return users.stream().map(user -> MapUserToDTO(user)).collect(Collectors.toList());
//    }
//
//    @Override
//    public void delete(Long userId) {
//        userRepository.deleteById(userId);
//    }


}
