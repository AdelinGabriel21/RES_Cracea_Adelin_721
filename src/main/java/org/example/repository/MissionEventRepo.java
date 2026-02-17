package org.example.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.MissionEvent;

import java.util.ArrayList;
import java.util.List;

public class MissionEventRepo {
    private List<MissionEvent> missionEvents = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();

    public void loadMissionEvents() {
        try {
            missionEvents = mapper.readValue(new java.io.File("events.json"), mapper.getTypeFactory().constructCollectionType(List.class, MissionEvent.class));
            System.out.println("Events loaded: " + missionEvents.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MissionEvent> getMissionEvents() {
        return missionEvents;
    }

//    public void saveMissionReportToFile(List<MissionEvent> missionEvents) {
//        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter("mission_report.txt"))) {
//            for (MissionEvent e : missionEvents) {
//                writer.write(e.toString());
//                writer.newLine();
//            }
//        } catch (java.io.IOException e) {
//            e.printStackTrace();
//        }
//    }
}
