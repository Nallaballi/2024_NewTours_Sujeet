package ReadProperties;
	
import java.io.FileInputStream;
import java.util.Properties;
	
public class ReadProperties
{
		FileInputStream file;
		Properties prop;
		String filePath;
		
				public ReadProperties(String filePath)
				{
					this.filePath = filePath;
				}
			
				// 1.FileInputStream Class from java.io. "Gets the file". It's constructor needs the file path
				// 2.Properties Class from java.util "Loads and Reads the file". To do it has many methods
				// .load()				--> method loads the file
				// .getProperty()	--> method reads the file
				
				public String propertiesFile(String key)
				{
					try {
						file = new FileInputStream(filePath);
						prop = new Properties();
						prop.load(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
					//System.out.println("This is the URL " + prop.getProperty(key));
					return prop.getProperty(key);
				}
}