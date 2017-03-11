package com.ms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Entity
@Table(name = "`user`")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Long id;
    @Column(name = "`name`")
    private String name;
    @Column(name = "`password`")
    private String password;
    @Column(name = "`enable`")
    private Boolean enable;
    @Column(name = "`img_path`")
    private String imgPath;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "`user_role`" , joinColumns = @JoinColumn(name = "`user_id`") , inverseJoinColumns = @JoinColumn(name = "`role_id`"))
    private List<Role> roles;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
