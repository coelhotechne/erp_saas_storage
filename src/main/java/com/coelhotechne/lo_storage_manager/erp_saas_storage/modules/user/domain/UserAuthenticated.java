package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.user.domain;


import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserAuthenticated implements UserDetails {
    private final User user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(user.getRole().name()));
    }

    @Override
    public String getPassword() {
        if (user.getPassword() == null){
            throw new IllegalStateException("User whithout password");
        }
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        if (user.getUsername() == null){
            throw new IllegalStateException("User whithout name");
        }
        return user.getUsername();
    }
    // Metodo para verificar experiação da conta após o periodo atribuido ao AccountExpiration
    @Override
    public boolean isAccountNonExpired() {
        if (user.getAccountExpiration() == null){
            return true;
        }
        return LocalDateTime.now().isBefore(user.getAccountExpiration());
    }
    // Metodo para verificar bloqueio da conta após o periodo atribuido ao LockUntil que faz a verificação de tentativas de Login
    @Override
    public boolean isAccountNonLocked() {
        if(user.getLockUntil() == null){
            return true;
        }
        return LocalDateTime.now().isAfter(user.getLockUntil());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if (user.getCredentialExpiration() == null){
            return true;
        }
        return LocalDateTime.now().isBefore(user.getCredentialExpiration());
    }

    @Override
    public boolean isEnabled() {
        return Boolean.TRUE.equals(user.getStatus());
    }
}
