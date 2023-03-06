package com.example.etr407.domain;

import java.util.List;

public class CostOfDistance {
    List<String> costOfTrip;
    Double distance;
    Double cost;

    public List<String> getCostOfTrip() {
        return costOfTrip;
    }

    public void setCostOfTrip(List<String> costOfTrip) {
        this.costOfTrip = costOfTrip;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "CostOfDistance{" +
                "costOfTrip=" + costOfTrip +
                ", distance=" + distance +
                ", cost=" + cost +
                '}';
    }
}
