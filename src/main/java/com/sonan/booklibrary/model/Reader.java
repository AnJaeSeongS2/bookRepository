package com.sonan.booklibrary.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Jaeseong on 2020/07/27
 * Git Hub : https://github.com/AnJaeSeongS2
 */
@Entity
public class Reader implements UserDetails {
    private static final long serialVersionUID = -1L;

    @Id
    private String username;
    private String fullname;
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // READER 권한 부여.
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"));
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        // password formating need.
        // ref: https://blusky10.tistory.com/411
//        return String.format("{%s}%s",username, password);
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정이 만료되지 않았다는 것을 반환.
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정이 락상태이지 않다고 반환.
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 자격이 만료되지 않았는 지 반환.
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 계정이 활성화됐는 지 반환.
        return true;
    }
}
