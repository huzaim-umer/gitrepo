package com.morelllcrm.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="emails")
public class Emails {
    @Id
    @GeneratedValue
    @Column(name = "email_id")
    private UUID emailId;

    private String emailAddress;

    public UUID getEmailId() {
        return emailId;
    }

    public void setEmailId(UUID emailId) {
        this.emailId = emailId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
