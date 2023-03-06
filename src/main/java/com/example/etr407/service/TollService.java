package com.example.etr407.service;

import com.example.etr407.constants.Constants;
import com.example.etr407.domain.CostOfDistance;
import com.example.etr407.domain.Route;
import com.example.etr407.domain.Toll;
import com.example.etr407.exceptions.NotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class TollService {

    private List<Map<String, Toll>> locations = null;
    private List <Toll> tollList = new ArrayList<>();
    public List<Map<String, Toll>> getLocations () {
        if (locations!= null)
            return locations;
        else {
            locations = new ArrayList<>();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/interchanges.json"));
            JsonNode locationsNode = rootNode.get("locations");
            Iterator<String> stringIterator = locationsNode.fieldNames();
            for (JsonNode locationNode : locationsNode) {
                String id = stringIterator.next();
                HashMap<String, Toll> stringTollMap = new HashMap<>();
                Toll objToll = objectMapper.treeToValue (locationNode, Toll.class);
                objToll.setId(Long.valueOf(id));
                tollList.add(objToll);
                stringTollMap.put(id, objToll);
                locations.add(stringTollMap);
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return locations;
    }

    public List <Toll> getListofToll () {
        if (locations==null) {
            getLocations();
        }
        return tollList;

    }

    public Toll findByName (String name) {
        if (locations==null) {
            getLocations();
        }
        return tollList.stream().filter(n -> name.equals(n.getName())).findFirst().orElseThrow(NotFoundException::new);
    }

    public CostOfDistance getCost (Toll from, Toll to) {
        if (locations==null) {
            getLocations();
        }

        long fromId = from.getId();
        long toId = to.getId();
        double distance = 0;


        if(fromId < toId) {
            for (Toll t : tollList) {
                long id = t.getId();
                if (fromId <= id && toId >= id){
                    Iterator<Route> iterator = t.getRoutes().iterator();
                    while (iterator.hasNext()) {
                        Route route = iterator.next();
                        Long routeToId = route.getToId();
                        if (routeToId.longValue() > t.getId().longValue()) {
                            distance += route.getDistance().doubleValue();
                        }
                    }
                }
            }

        }

        if (fromId > toId) {
            for (int i = tollList.size()-1; i >= 0; i--) {
                long id = tollList.get(i).getId();
                if (fromId >= id && toId<= id) {
                    Iterator<Route> iterator = tollList.get(i).getRoutes().iterator();
                    while (iterator.hasNext()) {
                        Route route = iterator.next();
                        Long routeToId = route.getToId();
                        if (routeToId.longValue() < tollList.get(i).getId().longValue()) {
                            distance += route.getDistance().doubleValue();
                        }
                    }
                }
            }
        }

        CostOfDistance costOfDistance = new CostOfDistance();
        costOfDistance.setDistance(distance);
        costOfDistance.setCost(distance* Constants.RATE);
        costOfDistance.setCostOfTrip(List.of(from.getName(), to.getName()));
        return costOfDistance;
    }
}
