package com.morelllcrm.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
public class Users implements UserDetails {

    public Users() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<UserAddresses> userAddresses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<Emails> emails= new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<UsersContactNumbers> usersContactNumbers = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<UsersAttribrutes> usersAttribrutes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<UsersPermissions> usersPermissions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<UserRoles> userRoles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<PasswordHistory> passwordHistories = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<AuditTrail> auditTrails = new ArrayList<>();

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at",nullable = false)
    private LocalDateTime modifiedAt;

    @Column(name = "email_id",unique = true,nullable = false)
    private String emailId;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "require_password_change",nullable = false)
    private Boolean requirePasswordChange;

    @Column(name = "user_salt_value",nullable = false)
    private String userSaltValue;

    public Boolean getLoggedOut() {
        return isLoggedOut;
    }

    public void setLoggedOut(Boolean loggedOut) {
        isLoggedOut = loggedOut;
    }

    private Boolean isLoggedOut;


    @PrePersist
    public void onCreate(){
        this.createdAt= LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = LocalDateTime.now();
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public List<AuditTrail> getAuditTrails() {
        return auditTrails;
    }

    public void setAuditTrails(List<AuditTrail> auditTrails) {
        this.auditTrails = auditTrails;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Boolean getRequirePasswordChange() {
        return requirePasswordChange;
    }

    public void setRequirePasswordChange(Boolean requirePasswordChange) {
        this.requirePasswordChange = requirePasswordChange;
    }

    public String getUserSaltValue() {
        return userSaltValue;
    }

    public void setUserSaltValue(String userSaltValue) {
        this.userSaltValue = userSaltValue;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

//    @Override
//    public String getPassword() {
//        return null;
//    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<UserAddresses> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<UserAddresses> userAddresses) {
        this.userAddresses = userAddresses;
    }

    public List<UsersContactNumbers> getUsersContactNumbers() {
        return usersContactNumbers;
    }

    public void setUsersContactNumbers(List<UsersContactNumbers> usersContactNumbers) {
        this.usersContactNumbers = usersContactNumbers;
    }

    public List<Emails> getEmails() {
        return emails;
    }

    public void setEmails(List<Emails> emails) {
        this.emails = emails;
    }

    public List<UsersAttribrutes> getUsersAttribrutes() {
        return usersAttribrutes;
    }

    public void setUsersAttribrutes(List<UsersAttribrutes> usersAttribrutes) {
        this.usersAttribrutes = usersAttribrutes;
    }

    public List<UsersPermissions> getUsersPermissions() {
        return usersPermissions;
    }

    public void setUsersPermissions(List<UsersPermissions> usersPermissions) {
        this.usersPermissions = usersPermissions;
    }

    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    public List<PasswordHistory> getPasswordHistories() {
        return passwordHistories;
    }

    public void setPasswordHistories(List<PasswordHistory> passwordHistories) {
        this.passwordHistories = passwordHistories;
    }

    @Transient
    private String password;

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
