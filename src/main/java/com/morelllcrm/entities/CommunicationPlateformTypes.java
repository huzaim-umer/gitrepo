package com.morelllcrm.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "communication_platform_types")
public class CommunicationPlateformTypes {
    @Id
    @GeneratedValue
    @Column(name = "guid")
    private UUID guid;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "communication_platform_type_id", referencedColumnName = "guid")
    private List<CommunicationTemplates> communicationTemplates = new ArrayList<>();


    @Size(max = 50)
    @Column(name = "comm_code",length = 50,nullable = false)
    private String commCode;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

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

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public String getCommCode() {
        return commCode;
    }

    public void setCommCode(String commCode) {
        this.commCode = commCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
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

    public List<CommunicationTemplates> getCommunicationTemplates() {
        return communicationTemplates;
    }

    public void setCommunicationTemplates(List<CommunicationTemplates> communicationTemplates) {
        this.communicationTemplates = communicationTemplates;
    }
}
