package com.morelllcrm.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "provinces")
public class Provinces {
    @Id
    @GeneratedValue
    @Column(name = "province_id")
    private UUID provinceId;

    @Column(name = "province_name",nullable = false)
    private String provinceName;

    public UUID getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(UUID provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
