package com.tqs.homework;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Daily {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String summary;
    private String icon;
    @OneToMany
    private List<Data> data;

    /**
     * Needed for JPA
     */
    public Daily(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Daily{" +
                "id=" + id +
                ", summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", data=" + data +
                '}';
    }
}
