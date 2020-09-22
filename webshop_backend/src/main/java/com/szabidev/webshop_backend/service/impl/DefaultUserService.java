package com.szabidev.webshop_backend.service.impl;

import com.szabidev.webshop_backend.dao.UserRepository;
import com.szabidev.webshop_backend.model.UserModel;
import com.szabidev.webshop_backend.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * Default implementation of {@link UserService}
 */
@Service("userService")
public class DefaultUserService implements UserService {

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Override
    public Optional<UserModel> getUserById(Long Id) {
        return userRepository.findById(Id);
    }

    @Override
    public List<UserModel> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> deleteUserById(Long id) {
        Optional<UserModel> userModel = userRepository.findById(id);
        if (userModel.isPresent()){
            userRepository.deleteById(id);
            return userModel;
        }
        return Optional.empty();
    }


}
