package org.example;

import org.example.controller.SpaceMissionController;
import org.example.repository.AstronautRepo;
import org.example.repository.MissionEventRepo;
import org.example.repository.SupplyRepo;
import org.example.service.SpaceMissionService;

public class Main {
    public static void main(String[] args) {
        AstronautRepo astronautRepo = new AstronautRepo();
        MissionEventRepo missionEventRepo = new MissionEventRepo();
        SupplyRepo supplyRepo = new SupplyRepo();

        SpaceMissionService service = new SpaceMissionService(astronautRepo, missionEventRepo, supplyRepo);

        SpaceMissionController controller = new SpaceMissionController(service);

        controller.run();
    }
}
