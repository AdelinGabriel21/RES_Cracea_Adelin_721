package org.example.service;

import org.example.model.Astronaut;
import org.example.model.AstronautStatus;
import org.example.repository.AstronautRepo;
import org.example.repository.MissionEventRepo;
import org.example.repository.SupplyRepo;

import java.util.List;

public class SpaceMissionService {
    private final AstronautRepo astronautRepo;
    private final MissionEventRepo eventRepo;
    private final SupplyRepo supplyRepo;

    public SpaceMissionService(AstronautRepo astronautRepo, MissionEventRepo eventRepo, SupplyRepo supplyRepo) {
        this.astronautRepo = astronautRepo;
        this.eventRepo = eventRepo;
        this.supplyRepo = supplyRepo;
    }


//1. (1 Punkt) Lesen Sie die Daten aus den JSON-Dateien astronauts.json, events.json und supplies.json und speichern Sie diese in Java-Listen. Geben Sie anschließend auf der Konsole aus:
//● Anzahl der Astronauten
//● Anzahl der Ereignisse
//● Anzahl der Supplies
//● alle Astronauten (jeweils eine Zeile) in der Reihenfolge aus der JSON-Datei
//Ausgabeformat (Astronaut): [#id] name | spacecraft | status | exp=<experienceLevel>
//Ausgabe:
//Astronauts loaded: 15 Events loaded: 25 Supplies loaded: 14
//[#1] Ava Ionescu | Orion | ACTIVE | exp=9
//[#2] Mihai Petrescu | Dragon | ACTIVE | exp=8
//[#3] Elena Pop | Orion | INACTIVE | exp=7
//[#4] Radu Stan | Starliner | ACTIVE | exp=6
//[#5] Sofia Marin | Dragon | ACTIVE | exp=7
//[#6] Andrei Dumitru | Orion | ACTIVE | exp=5
//[#7] Clara Neagu | Starliner | INACTIVE | exp=8
//[#8] Victor Iliescu | Orion | ACTIVE | exp=6
//[#9] Ioana Rusu | Dragon | LOST | exp=9
//[#10] Daniel Voicu | Starliner | ACTIVE | exp=7
//[#11] Bianca Tudor | Orion | ACTIVE | exp=8
//[#12] Horia Pascu | Dragon | INACTIVE | exp=6
//[#13] Nadia Ene | Starliner | ACTIVE | exp=5
//[#14] Teodor Matei | Orion | ACTIVE | exp=7
//[#15] Larisa Dobre | Dragon | ACTIVE | exp=6

    public void showAstronauts(){
        astronautRepo.getAstronauts().forEach(System.out::println);
    }

    public void loadData() {
        astronautRepo.loadAstronauts();
        eventRepo.loadMissionEvents();
        supplyRepo.loadSupplies();
    }

//2. (0.5 Punkte) Filtern nach spacecraft und Status
//Lesen Sie von der Tastatur einen String spacecraft. Geben Sie anschließend nur die Astronauten aus, welche folgende Bedingungen erfüllen:
//● spacecraft == input
//● status == ACTIVE
//Die Ausgabe erfolgt im selben Format wie in Aufgabe 1.
//Ausgabe:
//Input Spacecraft: Orion
//[#1] Ava Ionescu | Orion | ACTIVE | exp=9
//[#6] Andrei Dumitru | Orion | ACTIVE | exp=5
//[#8] Victor Iliescu | Orion | ACTIVE | exp=6
//[#11] Bianca Tudor | Orion | ACTIVE | exp=8
//[#14] Teodor Matei | Orion | ACTIVE | exp=7


    public List<Astronaut> getAstronautsBySpacecraftAndStatus(String spacecraft) {
        return astronautRepo.getAstronauts().stream()
                .filter(astronaut -> astronaut.getSpacecraft().equalsIgnoreCase(spacecraft))
                .filter(astronaut -> astronaut.getStatus().equals(AstronautStatus.ACTIVE))
                .toList();
    }

}
