package com.troshchuk.photoLibrary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.sql.Timestamp;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  18.08.14.
 */

@Entity
public class User {
    @Id
    @Column(name = "user_id")
    private long userId;

    private String email;

    @Column(name = "last_seen")
    private Timestamp  lastSeen;

    @JoinColumn(name = "user_id")
    private Password password;

    public User() {
    }

    public User(String email, Timestamp lastSeen) {
        this.email = email;
        this.lastSeen = lastSeen;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Timestamp lastSeen) {
        this.lastSeen = lastSeen;
    }
}
