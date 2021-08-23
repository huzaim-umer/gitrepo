package com.morelllcrm.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="contact_number_type")
public class ContactNumberType {

    @Id
    @GeneratedValue
    @Column(name = "contact_number_type_id")
    private UUID contactNumberTypeId;
    @Size(max = 50)
    private String contactNumberTypeCode;
    @Size(max = 50)
    private String contactNumberTypeDescription;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private boolean isDeleted;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_number_type_id", referencedColumnName = "contact_number_type_id")
    private List<UsersContactNumbers> usersContactNumbers = new ArrayList<>();

    public UUID getContactNumberTypeId() {
        return contactNumberTypeId;
    }

    public void setContactNumberTypeId(UUID contactNumberTypeId) {
        this.contactNumberTypeId = contactNumberTypeId;
    }

    public String getContactNumberTypeCode() {
        return contactNumberTypeCode;
    }

    public void setContactNumberTypeCode(String contactNumberTypeCode) {
        this.contactNumberTypeCode = contactNumberTypeCode;
    }

    public String getContactNumberTypeDescription() {
        return contactNumberTypeDescription;
    }

    public void setContactNumberTypeDescription(String contactNumberTypeDescription) {
        this.contactNumberTypeDescription = contactNumberTypeDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = LocalDateTime.now();;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<UsersContactNumbers> getUsersContactNumbers() {
        return usersContactNumbers;
    }

    public void setUsersContactNumbers(List<UsersContactNumbers> usersContactNumbers) {
        this.usersContactNumbers = usersContactNumbers;
    }
}
