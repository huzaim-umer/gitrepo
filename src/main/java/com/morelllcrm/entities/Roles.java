package com.morelllcrm.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "role_id")
    private UUID roleId;

    private String roleName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime modifiedAt;
    private Boolean isDeleted;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private List<RolesPermissions> rolesPermissions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private List<UserRoles> userRoles = new ArrayList<>();

//    @ManyToMany(targetEntity = UserRoles.class)
//    private List<UserRoles>userRoles;


    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public List<RolesPermissions> getRolesPermissions() {
        return rolesPermissions;
    }

    public void setRolesPermissions(List<RolesPermissions> rolesPermissions) {
        this.rolesPermissions = rolesPermissions;
    }
}
