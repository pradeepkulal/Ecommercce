
package org.pk.Ecommerce.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	public List<HashMap<String,String>> getJsonDataToMap() throws IOException {
		//reading json to string 
		String jsonContent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"/Ecommerce/src/test/java/org/pk/Ecommerce/data/PurchaseOrder.json"),
				"UTF-8");
		 // String to hashmap usind jackson databind
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String,String>> data= mapper.readValue(jsonContent,new TypeReference<List<HashMap<String, String>>>(){
		});
		return data;
	}
}
