package com.tqs.homework;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private double latitude;
    private double longitude;
    private String timezone;
    @OneToOne
    private Daily daily;

    //Needed for JPA
    public Forecast(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) { this.daily = daily; }

    @Override
    public String toString() {
        return "Forecast{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", timezone='" + timezone + '\'' +
                ", daily=" + daily +
                '}';
    }
}
