package utils;

import com.google.gson.Gson;
import models.ConfigModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataHelper {

    private final static String TEST_DATA_FOLDER = "src/test/resources/testData/";
    private final static String CONFIG_FILES_FOLDER = "src/test/resources/configs/";
    private final static String USERS_DATA_FILE = "users.json";


    private static Object getDataByItemName(String dataPath, Class classType, String itemName) {

        JSONParser parser = new JSONParser();

        try {
            JSONObject allItems = (JSONObject) (parser.parse(new FileReader(dataPath)));
            JSONObject user = (JSONObject) allItems.get(itemName);
            return new Gson().fromJson(user.toJSONString(), classType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private static Object getData(String dataPath, Class classType) {

        try {
            return new Gson().fromJson(new FileReader(dataPath), classType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ConfigModel getConfigData(String fileName) {

        return (ConfigModel) getData(CONFIG_FILES_FOLDER + fileName + ".json", ConfigModel.class);
    }
}
