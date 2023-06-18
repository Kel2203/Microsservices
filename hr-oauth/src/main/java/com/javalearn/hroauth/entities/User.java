package com.javalearn.hroauth.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class User implements Serializable {
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

    public class User implements UserDetails, Serializable {
        private static final long serialVersionUID = 1L;

        private Long id;
        @@ -85,4 +91,35 @@ public boolean equals(Object obj) {
            return false;
            return true;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return roles.stream().map(x -> new SimpleGrantedAuthority(x.getRoleName()))
                    .collect(Collectors.toList());
        }

        @Override
        public String getUsername() {
            return email;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }