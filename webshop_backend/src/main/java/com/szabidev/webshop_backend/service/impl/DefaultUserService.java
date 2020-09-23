package com.szabidev.webshop_backend.service.impl;

import com.szabidev.webshop_backend.dao.UserRepository;
import com.szabidev.webshop_backend.model.UserModel;
import com.szabidev.webshop_backend.service.UserService;
import com.szabidev.webshop_backend.service.populator.impl.UserPopulator;
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

    @Resource(name = "userPopulator")
    private UserPopulator userPopulator;

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

    @Override
    public Optional<UserModel> createUser(UserModel userModel) {
        return Optional.of(userRepository.save(userModel));
    }

    @Override
    public Optional<UserModel> updateUser(UserModel userModel, Long id) {
        if (!userRepository.existsById(id)){
            return this.createUser(userModel);
        }
        UserModel userToBeUpdated = userRepository.getOne(id);
        userPopulator.populatePut(userToBeUpdated, userModel);
        return Optional.of(userRepository.save(userToBeUpdated));

    }

    @Override
    public Optional<UserModel> patchUser(UserModel userModel, Long id) {
        if (!userRepository.existsById(id)){
            return Optional.empty();
        }
        UserModel userToBeUpdated = userRepository.getOne(id);
        userPopulator.populatePatch(userToBeUpdated, userModel);
        return Optional.of(userRepository.save(userToBeUpdated));
    }


}
