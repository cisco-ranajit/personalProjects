package com.main.studentManagement.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;

@Entity
public
class Role implements GrantedAuthority {

    @Id
    private String roleName;
    private String roleDescription;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    @Override
    public String getAuthority() {
        return this.roleName;
    }
}

