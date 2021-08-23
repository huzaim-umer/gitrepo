package com.morelllcrm.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="permissions")
public class Permissions {

    @Id
    @GeneratedValue
    @Column(name = "permission_id")
    private UUID permissionId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
    private List<ResourcesPermissions> resourcesPermissions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
    private List<UsersPermissions> usersPermissions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
    private List<RolesPermissions> rolesPermissions = new ArrayList<>();

    @Size(max = 50)
    private String permissionCode;
    @Size(max = 50)
    private String permissionType;
    @Size(max = 50)
    private String action;
    @Size(max = 50)
    private String resourceId;

    public UUID getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(UUID permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public List<ResourcesPermissions> getResourcesPermissions() {
        return resourcesPermissions;
    }

    public void setResourcesPermissions(List<ResourcesPermissions> resourcesPermissions) {
        this.resourcesPermissions = resourcesPermissions;
    }

    public List<UsersPermissions> getUsersPermissions() {
        return usersPermissions;
    }

    public void setUsersPermissions(List<UsersPermissions> usersPermissions) {
        this.usersPermissions = usersPermissions;
    }
}
