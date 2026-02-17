package org.example.controller;

import org.example.service.SpaceMissionService;

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
//        task2();
//        task3();
//        task4();
//        task5();
    }

    public void task1() {
        spaceMissionService.loadData();
        System.out.println();
        spaceMissionService.showAstronauts();
        System.out.println("\n");
    }
}
