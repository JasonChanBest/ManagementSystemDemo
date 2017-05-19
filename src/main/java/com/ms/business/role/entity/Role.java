package com.ms.business.role.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author Jason
 * @since v1.0
 */
@Entity
@Table(name = "`role`")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Long id;
    @Column(name = "`name`")
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }

    /**getter、setter方法**/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
