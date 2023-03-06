package com.example.etr407.service;

import com.example.etr407.domain.Route;
import com.example.etr407.domain.Toll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;


@SpringBootTest
public class TollServiceTest {

    @Autowired
    private TollService tollService;

    @Test
    public void findByNameTest () {
        Toll qewToll = new Toll();
        qewToll.setId(Long.valueOf(1));
        qewToll.setName("QEW");
        qewToll.setLat(Double.valueOf(43.336962));
        qewToll.setLng(Double.valueOf(-79.830394));
        Route route = new Route();
        route.setDistance(Double.valueOf(6.062));
        route.setToId(Long.valueOf(2));
        qewToll.setRoutes(List.of(route));
        Toll qew = tollService.findByName("QEW");

        Assert.isTrue(qewToll.getName().equals(qew.getName()), "check name of object");
        Assert.isTrue(qewToll.getId().equals(qew.getId()), "Check id in object");

    }

    @Test
    public void findByName () {
        String name = "Dundas Street";
        Toll t = tollService.findByName(name);
        Assert.isTrue(t.getName().equals(name),"Check for name");
        Assert.isTrue(t.getId().equals(Long.valueOf("2")), "check id, must be 2");


    }

    @Test
    void getListofToll() {
        List<Toll> listofToll = tollService.getListofToll();
        int size = listofToll.size();
        Assert.isTrue(size==44, "size of Collections of Locations");
    }
}
