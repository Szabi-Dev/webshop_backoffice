package com.szabidev.webshop_backend.service.impl;

import com.szabidev.webshop_backend.dao.UserRepository;
import com.szabidev.webshop_backend.model.RoleModel;
import com.szabidev.webshop_backend.model.UserModel;
import com.szabidev.webshop_backend.service.UserService;
import com.szabidev.webshop_backend.service.populator.impl.UserPopulator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
         if (userRepository.findByEmail(userModel.getEmail()).isPresent()){
            return Optional.empty();
         }
         return Optional.of(userRepository.save(userModel));
    }

    @Override
    public Optional<UserModel> updateUser(UserModel userModel, Long id) {
        if (!userRepository.existsById(id)){
            return this.createUser(userModel);
        }
        UserModel userToBeUpdated = userRepository.getOne(id);
        userPopulator.populatePut(userToBeUpdated, userModel);
        return createUser(userToBeUpdated);

    }

    @Override
    public Optional<UserModel> patchUser(UserModel userModel, Long id) {
        if (!userRepository.existsById(id)){
            return createUser(userModel);
        }
        UserModel userToBeUpdated = userRepository.getOne(id);
        userPopulator.populatePatch(userToBeUpdated, userModel);
        return createUser(userToBeUpdated);
    }

    @Override
    public List<RoleModel> findAllRolesForUser(Long id) {
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.map(model -> new ArrayList<>(model.getRoles()))
                .orElseGet(ArrayList::new);
    }


}
