package com.tmh.aws.solutions.models;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "created_dt")
    private Date createdDt;

    @Column(name = "created_by")
    private String createdBy = "system";

    @Column(name = "updated_dt")
    private Date updatedDt;

    @Column(name = "updated_by")
    private String updatedBy = "system";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseModel baseModel = (BaseModel) o;
        return Objects.equals(id, baseModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @PrePersist
    public void prePersist() {
        if (createdDt == null) {
            createdDt = new Date();
        }

        if(updatedDt == null) {
            updatedDt = new Date();
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedDt = new Date();
    }
}
