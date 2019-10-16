package learning.coding.interviewtop50;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaFileReader {

	public static void main(String[] args) {

		try {
			Map<String,Double> yearMap = new HashMap<>();
			double sum =0.0;
			String year = "";
			List<String> allLines = Files.readAllLines(Paths.get("/Users/ashok/Desktop/transfers.txt"));
			for (String line : allLines) {
				
				 if(line.contains("2018")){
					 year = "2018";
				 }
				 else if(line.contains("2019")){
					 year = "2019";
				 }
				 else if(line.contains("2020")) {
					 year = "2020";
				 }
				 else if(line.contains("2021")) {
					 year = "2021";
				 }
				 if(line.contains("INR")) {
					 String a = line.substring(0,line.length()-4).replace(",", "");
					 System.out.println(a);
					 sum = sum+ Double.parseDouble(a);
					 if(yearMap.containsKey(year))
					 yearMap.put(year,yearMap.get(year)+Double.parseDouble(a));
					 else
					   yearMap.put(year, Double.parseDouble(a));
				 }
			}
			
			System.out.println("Total sum "+sum);
			
			yearMap.entrySet().stream().forEach(System.out::println);
			
			System.out.println(yearMap.values().stream().mapToDouble(Double::doubleValue).sum());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
