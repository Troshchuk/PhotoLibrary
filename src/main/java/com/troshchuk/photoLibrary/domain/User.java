package com.troshchuk.photoLibrary.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Users_Roles", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id",
                    nullable = false, updatable = false)})
    private Set<Role> roles;

    @Column(name = "last_seen")
    private Timestamp  lastSeen;

    public User() {
    }

    public User(String email) {
        this.email = email;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
