package com.szabidev.webshop_backend.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ROLE_MODEL")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<UserModel> users;

    @ManyToMany
    @JoinTable(name = "roles_privileges",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Collection<PrivilegeModel> privileges;

    public RoleModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<UserModel> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserModel> users) {
        this.users = users;
    }

    public Collection<PrivilegeModel> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<PrivilegeModel> privileges) {
        this.privileges = privileges;
    }
}
