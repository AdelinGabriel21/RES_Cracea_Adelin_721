package org.example.controller;

import org.example.model.Astronaut;
import org.example.model.MissionEvent;
import org.example.service.SpaceMissionService;

import java.util.List;
import java.util.Scanner;

public class SpaceMissionController {
    private final SpaceMissionService spaceMissionService;
    private final Scanner scanner;

    public SpaceMissionController(SpaceMissionService spaceMissionService) {
        this.spaceMissionService = spaceMissionService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        task1();
        task2();
        task3();
        task4();
//        task5();
//        task6();
    }

    public void task1() {
        spaceMissionService.loadData();
        System.out.println();
        spaceMissionService.showAstronauts();
        System.out.println("\n");
    }

    public void task2() {
        System.out.print("Input Spacecraft: ");
        String spacecraftInput = scanner.nextLine();

        List<Astronaut> astronauts = spaceMissionService.getAstronautsBySpacecraftAndStatus(spacecraftInput);

        for(Astronaut a: astronauts){
            System.out.println(a);
        }
        System.out.println("\n");
    }

    public void task3() {
        List<Astronaut> sorted = spaceMissionService.sortAstronautsByExperienceAndName();
        for(Astronaut a: sorted){
            System.out.println(a);
        }
        System.out.println("\n");
    }


    public void task4() {
        spaceMissionService.saveSortedAstronautsToFile();
    }
}
