package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;

public class dataProvider {

	@DataProvider(name = "createTasktestData")
	public Iterator<Object[]> testData() throws IOException {
		return parseCsvData(System.getProperty("user.dir")+"\\testdata.csv");
	}

	private Iterator<Object[]> parseCsvData(String fileName) throws IOException {
		BufferedReader input = null;
		File file = new File(fileName);
		input = new BufferedReader(new FileReader(file));
		String line = null;
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		input.readLine();
		while ((line = input.readLine()) != null) {
			String in = line.trim();
			String[] temp = in.split(",");
			List<Object> arrray = new ArrayList<Object>();
			for (String s : temp) {
				arrray.add(s);
			}
			data.add(arrray.toArray());
		}
		input.close();
		return data.iterator();
	}


}
