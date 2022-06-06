package fileUtils;

import entity.Flight;
import entity.Resume;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;
import java.util.logging.Logger;

public class FileUtil {

    private static final String HEADER_1 = "origin;destination;airline;departure;arrival;price;time\n";
    private static final String HEADER_2 = "origin;destination;shortest_flight(h);longest_fight(h);cheapest_flight;most_expensive_flight;average_time;average_price\n";
    private static final Logger logger = Logger.getLogger("Errors");

    private FileUtil(){ throw new IllegalStateException("Util class"); }

    public static BufferedReader getFileReader(String fileName) throws FileNotFoundException {
        String path = new File(fileName).getAbsolutePath();
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        return new BufferedReader(fileReader);
    }

    public static void writeFirstFile(String fileName, List<Flight> flightList) throws IOException {
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(FileUtil.HEADER_1);

        flightList.stream()
                .map(Flight::toCsvFormat)
                .forEach(item -> {
                    try{
                        fileWriter.write(item);
                    }catch (Exception e){
                        logger.info(e.getMessage());
                    }
                });

        fileWriter.close();
    }

    public static void writeSecondFile(String fileName, List<Resume> resumes) throws IOException {

        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(FileUtil.HEADER_2);
        resumes.stream()
                .map(Resume::toCsvFormat)
                .forEach(item -> {
                    try{
                        fileWriter.write(item);
                    }catch (Exception e){
                        logger.info(e.getMessage());
                    }
                });

        fileWriter.close();
    }


}
