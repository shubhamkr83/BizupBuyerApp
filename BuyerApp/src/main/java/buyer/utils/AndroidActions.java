package buyer.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AndroidActions {
	

	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		// new File(System.getProperty("user.dir") + "\\src\\test\\java\\Bizupautomation\\testData\\seller.json"

		// Covert json file content to json string
		String jsonContent = FileUtils.readFileToString( new File(jsonFilePath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

}
