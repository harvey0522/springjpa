package com.example.springjpa.entry;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="product")
public class Product implements Serializable {
    @Id
    private Integer id;

    private String code;

    private Date creDate;

    private String name;

    private byte state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreDate() {
        return creDate;
    }

    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }*/

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", creDate=" + creDate +
                ", name='" + name + '\'' +
                '}';
    }
}
