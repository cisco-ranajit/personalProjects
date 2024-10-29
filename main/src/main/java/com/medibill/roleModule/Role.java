package com.medibill.roleModule;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import com.medibill.main.loginusers.LoginUsers;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    
    @Id
    @Column(name = "role_name", length = 50)
    private String roleName;
    
    @Column(name = "role_description")
    private String roleDescription;
    
    // Add the relationship with LoginUsers if you have a many-to-many relationship
    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private Set<LoginUsers> users = new HashSet<>();
    
    public Role() {}
    
    public Role(String roleName) {
        this.roleName = roleName;
    }
    
    public String getRoleName() {
        return roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public String getRoleDescription() {
        return roleDescription;
    }
    
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
    
    public Set<LoginUsers> getUsers() {
        return users;
    }
    
    public void setUsers(Set<LoginUsers> users) {
        this.users = users;
    }
    
    @Override
    public String getAuthority() {
        return this.roleName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleName, role.roleName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(roleName);
    }
    
    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }
}