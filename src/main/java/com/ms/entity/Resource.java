package com.ms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Entity
@Table(name = "`resource`")
public class Resource implements Serializable {
    @Id
    @Column(name = "`id`")
    private Long id;
    @Column(name = "`url`")
    private String url;
    @ManyToMany
    @JoinTable(name = "`role_resource`" , joinColumns = @JoinColumn(name = "`resource_id`") , inverseJoinColumns = @JoinColumn(name = "`role_id`"))
    private List<Role> roles;

    /**getter、setter方法**/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}