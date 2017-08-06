package check.checkserver;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

//import net.sf.json.JSON;
//import net.sf.json.xml.XMLSerializer;

public class App11 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger("check.checkserver.App11"); 
		String str ="<root><log4a><id>wrw</id><name>jjhgj</name><time><n></n></time></log4a></root>";
		XMLSerializer xmlSerializer = new XMLSerializer();
		System.out.println("asdfasdfa");
		JSON json = xmlSerializer.read(str);
		log.info("asfad");
		JsonParser parse =new JsonParser();
		JsonObject j1=(JsonObject) parse.parse(json.toString());
		System.out.println(j1.get("log4a"));
		System.out.println((j1.get("log4a")).getAsJsonObject().get("name"));
        System.out.println(xmlSerializer.read(str).toString());
		System.out.println("asdfasdfa");

	}

}
