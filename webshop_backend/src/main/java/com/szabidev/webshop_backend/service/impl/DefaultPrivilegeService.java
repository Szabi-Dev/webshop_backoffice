package com.szabidev.webshop_backend.service.impl;

import com.szabidev.webshop_backend.dao.PrivilegeRepository;
import com.szabidev.webshop_backend.model.PrivilegeModel;
import com.szabidev.webshop_backend.service.PrivilegeService;
import com.szabidev.webshop_backend.service.populator.impl.PrivilegePopulator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("privilegeService")
public class DefaultPrivilegeService implements PrivilegeService {

    @Resource(name = "privilegeRepository")
    private PrivilegeRepository privilegeRepository;

    @Resource(name = "privilegePopulator")
    private PrivilegePopulator privilegePopulator;

    @Override
    public Optional<PrivilegeModel> getPrivilegeById(Long id) {
        return privilegeRepository.findById(id);
    }

    @Override
    public List<PrivilegeModel> findAllPrivileges() {
        return privilegeRepository.findAll();
    }

    @Override
    public Optional<PrivilegeModel> deletePrivilegeById(Long id) {
        Optional<PrivilegeModel> privilegeModel = privilegeRepository.findById(id);
        if (privilegeModel.isPresent()) {
            privilegeRepository.deleteById(id);
            return privilegeModel;
        }
        return Optional.empty();
    }

    @Override
    public Optional<PrivilegeModel> createPrivilege(PrivilegeModel privilegeModel) {
        if (privilegeRepository.findByName(privilegeModel.getName()).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(privilegeRepository.save(privilegeModel));
    }

    @Override
    public Optional<PrivilegeModel> updatePrivilege(PrivilegeModel privilegeModel, Long id) {
        if (!privilegeRepository.existsById(id)){
            return Optional.of(privilegeRepository.save(privilegeModel));
        }
        PrivilegeModel privilegeToBeUpdated = privilegeRepository.getOne(id);
        privilegePopulator.populatePut(privilegeToBeUpdated, privilegeModel);
        return Optional.of(privilegeRepository.save(privilegeToBeUpdated));
    }

    @Override
    public Optional<PrivilegeModel> patchPrivilege(PrivilegeModel privilegeModel, Long id) {
        if (!privilegeRepository.existsById(id)){
            return Optional.of(privilegeRepository.save(privilegeModel));
        }
        PrivilegeModel privilegeToBeUpdated = privilegeRepository.getOne(id);
        privilegePopulator.populatePatch(privilegeToBeUpdated, privilegeModel);
        return Optional.of(privilegeRepository.save(privilegeToBeUpdated));
    }
}
