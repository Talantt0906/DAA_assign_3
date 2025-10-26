import java.io.FileReader;
import java.io.IOException;
import com.google.gson.*;

public class ReadInput {
    public static GraphData read(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            GraphData data = gson.fromJson(reader, GraphData.class);
            return data;
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
            return null;
        } catch (JsonSyntaxException e) {
            System.out.println("Invalid JSON syntax: " + e.getMessage());
            return null;
        }
    }
}

