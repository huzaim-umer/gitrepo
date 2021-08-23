package com.morelllcrm.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="users_contact_numbers")
public class UsersContactNumbers {
    @Id
    @GeneratedValue
    @Column(name = "users_contact_numbers_id")
    private UUID usersContactNumbersId;

    public UUID getUsersContactNumbersId() {
        return usersContactNumbersId;
    }

    public void setUsersContactNumbersId(UUID usersContactNumbersId) {
        this.usersContactNumbersId = usersContactNumbersId;
    }
}
