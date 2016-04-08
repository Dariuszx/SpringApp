package com.store.db;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "users")
@Entity
public class User {
    private Integer user_id;
    private String username;
    private String password;
    private Boolean enabled;
    private Timestamp dateRegistered;
    private String role;
    private Integer cart_id;


    @Id
    @Column(name = "user_id")
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer userId) {
        this.user_id = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "date_registered")
    public Timestamp getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Timestamp dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @JoinTable(name = "authorities",
            joinColumns = @JoinColumn(name = "authority", referencedColumnName = "user_id"))
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JoinTable(name = "cart",
            joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "user_id"))
    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (user_id != null ? !user_id.equals(user.user_id) : user.user_id != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (enabled != null ? !enabled.equals(user.enabled) : user.enabled != null) return false;
        if (dateRegistered != null ? !dateRegistered.equals(user.dateRegistered) : user.dateRegistered != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user_id != null ? user_id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (dateRegistered != null ? dateRegistered.hashCode() : 0);
        return result;
    }
}
