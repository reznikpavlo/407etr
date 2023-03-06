package com.example.etr407.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Route {

    @JsonProperty("toId")
    private Long toId;
    private Double distance;
    boolean enter;
    boolean exit;

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toid) {
        this.toId = toid;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public boolean isEnter() {
        return enter;
    }

    public void setEnter(boolean enter) {
        this.enter = enter;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    @Override
    public String toString() {
        return "Route{" +
                "toId=" + toId +
                ", distance=" + distance +
                ", enter=" + enter +
                ", exit=" + exit +
                '}';
    }
}
