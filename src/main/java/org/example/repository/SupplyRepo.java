package org.example.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Supply;

import java.util.ArrayList;
import java.util.List;

public class SupplyRepo {
    private List<Supply> supplies = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();

    public void loadSupplies() {
        try {
            supplies = mapper.readValue(new java.io.File("supplies.json"), mapper.getTypeFactory().constructCollectionType(List.class, Supply.class));
            System.out.println("Supplies loaded: " + supplies.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Supply> getSupplies() {
        return supplies;
    }
}
