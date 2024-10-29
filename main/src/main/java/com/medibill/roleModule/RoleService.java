package com.medibill.roleModule;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    private RoleRepository repository;

    @Override
    public Role createEntity(Role role) {
        return repository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    @Override
    public Role getRoleById(String roleName) {
        return repository.findById(roleName).get();
    }

    @Override
    public void deleteEntity(String roleName) {
        return;
    }

}
