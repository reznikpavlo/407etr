package com.example.etr407.controller;

import com.example.etr407.domain.CostOfDistance;
import com.example.etr407.domain.Toll;
import com.example.etr407.exceptions.NotFoundException;
import com.example.etr407.service.TollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("toll")
public class MainRestController {


    @Autowired
    private TollService tollService;


    @GetMapping
    public List<Map<String, Toll>> getToll() {
        return tollService.getLocations();
    }

    @GetMapping("/cost/{from}/{to}")
    public CostOfDistance costOfDistance (@PathVariable String from,
                                          @PathVariable String to) {
        Toll tollFrom = tollService.findByName(from);
        Toll tollTo = tollService.findByName(to);
        CostOfDistance costOfDistance = tollService.getCost(tollFrom, tollTo);
        return costOfDistance;
    }

    @GetMapping("{id}")
    public Toll getOne (@PathVariable String id) {


        List<Map<String, Toll>> locations = tollService.getLocations();
        for (Map location : locations) {
            if (location.keySet().contains(id)) {
                return (Toll) location.get(id);
            }
        }


        throw new NotFoundException();

    }

}

