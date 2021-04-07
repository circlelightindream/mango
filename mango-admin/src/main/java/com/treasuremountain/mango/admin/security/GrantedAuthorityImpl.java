package com.treasuremountain.mango.admin.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * 权限封装
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2021/04/05 22:31
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
