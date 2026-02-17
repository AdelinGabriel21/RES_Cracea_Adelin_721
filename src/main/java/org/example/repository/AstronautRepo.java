package org.example.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Astronaut;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AstronautRepo {
    private List<Astronaut> astronauts = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();

    public void loadAstronauts() {
        try {
            astronauts = mapper.readValue(new java.io.File("astronauts.json"), mapper.getTypeFactory().constructCollectionType(List.class, Astronaut.class));
            System.out.println("Astronauts loaded: " + astronauts.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Astronaut> getAstronauts() {
        return astronauts;
    }

    public void saveSortedAstronautsToFile(List<Astronaut> astronauts){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sorted_astronauts.txt"))) {
            for (Astronaut a : astronauts) {
                writer.write(a.toString());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
