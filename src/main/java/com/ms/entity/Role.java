package com.ms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Jason
 * @since v1.0
 */
@Entity
@Table(name = "`role`")
public class Role implements Serializable {
    @Id
    @Column(name = "`id`")
    private Long id;
    @Column(name = "`name`")
    private String name;

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
