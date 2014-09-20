package com.troshchuk.photoLibrary.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  18.08.14.
 */

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long userId;

    private String email;

    @Column(name = "last_seen")
    private Timestamp  lastSeen;

    public User() {
    }

    public User(String email) {
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
