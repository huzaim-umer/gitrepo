package com.morelllcrm.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "users_passwords_history")
@Entity
public class PasswordHistory {

    @Id
    @GeneratedValue
    @Column(name = "guid")
    private UUID guId;

    @Column(name = "password_id",nullable = false)
    private UUID passwordId;

    @Column(name = "password",nullable = false)
    private String password;

    @JsonInclude()
    @Transient
    private String confirmPassword;

    @Column(name = "access_key",nullable = false)
    private String accessKey;

    @Column(name = "access_secret",nullable = false)
    private String accessSecret;

    @Column(name = "is_active",nullable = false)
    private Boolean isActive;

    @Column(name = "is_validated",nullable = false)
    private Boolean isValidated;

    @Column(name = "activation_token",nullable = false)
    private String activationToken;

    @Column(name = "activation_token_valid_days",nullable = false)
    private Integer activationTokenValidDays;

    @Column(name = "is_activation_token_verified",nullable = false)
    private Boolean isActivationTokenVerified;

    @Column(name = "is_activation_token_expired",nullable = false)
    private Boolean IsActivationTokenExpired;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "updated_by",nullable = false)
    private String updatedBy;

    @Column(name = "created_by",nullable = false)
    private String createdBy;

    @Column(name = "is_deleted",nullable = false)
    private Boolean isDeleted;

    @Column(name = "deleted_at",nullable = true)
    private LocalDateTime deletedAt;

    @Column(name = "deleted_by",nullable = true)
    private String deletedBy;


    public UUID getGuId() {
        return guId;
    }

    public void setGuId(UUID guId) {
        this.guId = guId;
    }

    public UUID getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(UUID passwordId) {
        this.passwordId = passwordId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getValidated() {
        return isValidated;
    }

    public void setValidated(Boolean validated) {
        isValidated = validated;
    }

    public String getActivationToken() {
        return activationToken;
    }

    public void setActivationToken(String activationToken) {
        this.activationToken = activationToken;
    }

    public Integer getActivationTokenValidDays() {
        return activationTokenValidDays;
    }

    public void setActivationTokenValidDays(Integer activationTokenValidDays) {
        this.activationTokenValidDays = activationTokenValidDays;
    }

    public Boolean getActivationTokenVerified() {
        return isActivationTokenVerified;
    }

    public void setActivationTokenVerified(Boolean activationTokenVerified) {
        isActivationTokenVerified = activationTokenVerified;
    }

    public Boolean getActivationTokenExpired() {
        return IsActivationTokenExpired;
    }

    public void setActivationTokenExpired(Boolean activationTokenExpired) {
        IsActivationTokenExpired = activationTokenExpired;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
