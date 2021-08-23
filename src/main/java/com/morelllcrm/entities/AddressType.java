package com.morelllcrm.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="address_type")
public class AddressType {

    @Id
    @GeneratedValue
    @Column(name = "address_type_id")
    private UUID addressTypeId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_type_id", referencedColumnName = "address_type_id")
    private List<UserAddresses> userAddresses= new ArrayList<>();

    @Size(max = 50)
    private String typeCode;
    @Size(max = 50)
    private String typeValue;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private boolean isDeleted;

    public UUID getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(UUID addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
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

    public List<UserAddresses> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<UserAddresses> userAddresses) {
        this.userAddresses = userAddresses;
    }
}
