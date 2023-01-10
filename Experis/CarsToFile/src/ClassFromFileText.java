import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
File Each line represents a different object of the Car,
line 1 details the car. --> Boss 302|Red|3
Line 2 engine details. --> Diesel|3|5
Line 3 wheel type. --> RoadWheel
*/
public final class ClassFromFileText {
    static final Path filePathToRead = Paths.get("c:", "classFile.txt");
    static final String splitter = "\\|";

    public static List<String[]> getListOfCarParts() {
        final List<String[]> listOfCarsObj = new ArrayList<String[]>();
        try {
            //reader = Files.newBufferedReader(filePathToRead);
            // String line = reader.readLine();
            final List<String> listOfLines = Files.readAllLines(filePathToRead);
            for (String line : listOfLines) {
                listOfCarsObj.add(line.split(splitter));
            }
            // reader.close();
            return listOfCarsObj;
        }
        catch (IOException e) {
            throw new FileDoesNotExistException();
            //   throw new FileIsEmptyException();
        }

    }


}
