package com.ms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Entity
@Table("`menu`")
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("`id`")
    private Long id;

    @Column("`name`")
    private String name;

    @ManyToOne
    @JoinColumn(name = "`resource_id`")
    private Resource resource;

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

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
