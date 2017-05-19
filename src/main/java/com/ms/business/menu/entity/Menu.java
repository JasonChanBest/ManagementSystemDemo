package com.ms.business.menu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Entity
@Table(name = "`menu`")
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Long id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`url`")
    private String url;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "`parent_id`")
    private Menu parent;

    @OneToMany(mappedBy = "parent" , fetch = FetchType.EAGER , cascade = {CascadeType.REMOVE})
    private List<Menu> children;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
