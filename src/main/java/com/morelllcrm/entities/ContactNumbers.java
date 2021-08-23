package com.morelllcrm.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="contact_numbers")
public class ContactNumbers {
    @Id
    @GeneratedValue
    @Column(name = "contact_number_id")
    private UUID contactNumberId;

    private int countryCode;
    private int areaCode;
    private int contactNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private boolean isDeleted;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_number_id", referencedColumnName = "contact_number_id")
    private List<UsersContactNumbers> usersContactNumbers = new ArrayList<>();

    public UUID getContactNumberId() {
        return contactNumberId;
    }

    public void setContactNumberId(UUID contactNumberId) {
        this.contactNumberId = contactNumberId;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
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
