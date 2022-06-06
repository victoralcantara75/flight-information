package main;

import entity.Flight;
import entity.Resume;
import fileUtils.FileUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Main {

    public static ZonedDateTime toZonedDateTime(String stringDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss (z)");
        return ZonedDateTime.parse(stringDateTime, formatter);
    }

    public static List<Resume> getResumes(List<Flight> flightList){
        List<Resume> resumes = new ArrayList<>();

        Map<String, Map<String, List<Flight>>> mapping = flightList.stream()
                .collect(Collectors.groupingBy(Flight::getOrigin, Collectors.groupingBy(Flight::getDestination)));

        for (Map.Entry<String, Map<String, List<Flight>>> origin : mapping.entrySet()){

            for (Map.Entry<String, List<Flight>> destination : origin.getValue().entrySet()){

                List<Flight> groupedFlights = destination.getValue();
                OptionalInt shortest = groupedFlights.stream()
                                                     .mapToInt(item -> Math.toIntExact(item.getDuration()))
                                                     .min();
                OptionalInt longest = groupedFlights.stream()
                                                    .mapToInt(item -> Math.toIntExact(item.getDuration()))
                                                    .max();
                OptionalDouble cheapest = groupedFlights.stream()
                                                        .mapToDouble(item -> item.getPrice())
                                                        .min();
                OptionalDouble mostExpensive = groupedFlights.stream()
                                                             .mapToDouble(item -> item.getPrice())
                                                             .max();
                OptionalDouble avgDuration = groupedFlights.stream()
                                                           .mapToDouble(item -> item.getDuration())
                                                           .average();
                OptionalDouble avgPrice = groupedFlights.stream()
                                                        .mapToDouble(item -> item.getPrice())
                                                        .average();

                Resume resume = new Resume(
                        origin.getKey(),
                        destination.getKey(),
                        shortest.getAsInt(),
                        longest.getAsInt(),
                        cheapest.getAsDouble(),
                        mostExpensive.getAsDouble(),
                        avgDuration.getAsDouble(),
                        avgPrice.getAsDouble()
                );

                resumes.add(resume);
            }
        }

        return resumes;
    }

    public static List<Flight> getFlights() throws IOException {

        List<Flight> flightList = new ArrayList<>();
        BufferedReader bufferedReader = FileUtil.getFileReader("entrada.csv");
        String line;
        String[] splitLine;
        bufferedReader.readLine();

        while((line = bufferedReader.readLine()) != null){
            splitLine = line.split(";");

            Flight flight = new Flight(
                    splitLine[0],
                    splitLine[1],
                    splitLine[2],
                    toZonedDateTime(splitLine[3]),
                    toZonedDateTime(splitLine[4]),
                    Float.parseFloat(splitLine[5])
            );

            flightList.add(flight);
        }
        return flightList;
    }

    public static void main(String[] args) throws IOException {


        List<Flight> flightList = getFlights();
        List<Resume> resumes = getResumes(flightList);

        FileUtil.writeFirstFile("saida1.csv", flightList);
        FileUtil.writeSecondFile("saida2.csv", resumes);

    }

}
