package com.troshchuk.photoLibrary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  18.08.14.
 */

@Entity
public class Password {
    @Id
    @Column(name = "user_id")
    private long userId;

    private String password;

    public Password(User user, String password) {
        userId = user.getUserId();
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
