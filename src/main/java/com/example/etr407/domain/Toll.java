package com.example.etr407.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Toll {

    private Long id;
    private String name;
    private Double lat;
    private Double lng;
    private String devcomment;
    List<Route> routes;

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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getDevcomment() {
        return devcomment;
    }

    public void setDevcomment(String devcomment) {
        this.devcomment = devcomment;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toll)) return false;

        Toll toll = (Toll) o;

        if (getId() != null ? !getId().equals(toll.getId()) : toll.getId() != null) return false;
        return getName() != null ? getName().equals(toll.getName()) : toll.getName() == null;
    }

    @Override
    public String toString() {
        return "Toll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", devcomment='" + devcomment + '\'' +
                ", routes=" + routes +
                '}';
    }
}
