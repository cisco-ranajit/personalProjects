package com.medibill.roleModule;

import java.util.List;

public interface IRoleService {
    Role createEntity(Role role);
    List<Role> getAllRoles();
    Role getRoleById(String roleName);
    void deleteEntity(String roleName);
}
