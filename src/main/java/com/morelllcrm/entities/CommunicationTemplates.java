package com.morelllcrm.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "communication_templates")
@Entity
public class CommunicationTemplates {
    @Id
    @GeneratedValue
    @Column(name = "guid")
    private UUID guid;

    @Size(max = 50)
    @Column(name = "short_code",length = 50)
    private String shortCode;

    @Column(name = "description",nullable = false,length = 1024)
    private String description;

    @Column(name = "html_text",nullable = false)
    private String htmlText;

    @Column(name = "metadata",nullable = false)
    private String metadata;

    @Size(max = 50)
    @Column(name = "communication_code",length = 50,nullable = false)
    private  String communicationCode;

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

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getCommunicationCode() {
        return communicationCode;
    }

    public void setCommunicationCode(String communicationCode) {
        this.communicationCode = communicationCode;
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
}
