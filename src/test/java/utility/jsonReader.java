package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class jsonReader {

	
	private static JSONObject jsonData;

    static {
        try {
            String content = new String(Files.readAllBytes(Paths.get("./JSON/testData.json")));
            jsonData = new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getTestData(String testCaseName) {
        return jsonData.getJSONObject(testCaseName);
    }
}
