package com.morelllcrm.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "iam_audit_trail")
public class AuditTrail {
    @Id
    @GeneratedValue
    @Column(name = "guid")
    private UUID guid;

    @Column(name = "login_timestamp",nullable = false)
    private LocalDateTime loginTimeStamp;

    @Column(name = "logout_timestamp")
    private LocalDateTime logoutTimeStamp;

    @Column(name = "is_session_active",nullable = false)
    private Boolean isSessionActive;

    @Column(name = "reason")
    private String reason;

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public LocalDateTime getLoginTimeStamp() {
        return loginTimeStamp;
    }

    public void setLoginTimeStamp(LocalDateTime loginTimeStamp) {
        this.loginTimeStamp = loginTimeStamp;
    }

    public LocalDateTime getLogoutTimeStamp() {
        return logoutTimeStamp;
    }

    public void setLogoutTimeStamp(LocalDateTime logoutTimeStamp) {
        this.logoutTimeStamp = logoutTimeStamp;
    }

    public Boolean getSessionActive() {
        return isSessionActive;
    }

    public void setSessionActive(Boolean sessionActive) {
        isSessionActive = sessionActive;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
