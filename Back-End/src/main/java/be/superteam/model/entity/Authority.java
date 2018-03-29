package be.superteam.model.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Authority extends BaseEntity implements GrantedAuthority {

	private static final long serialVersionUID = 3142888807175137493L;
	
	@Column(nullable = false, unique = true)
    private String authority;

    public Authority() {
    }

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
