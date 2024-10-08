package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
public class Utils {

    public static RequestSpecification req; //static - it runs only once. create instance only once
    public static RequestSpecification requestSpecification() throws IOException {
        if (req == null) { //1st time it will execute, 2nd time it will return req since it is not null(so declared RequestSpecification as static)
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            req = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl")).addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }

    public static String getGlobalValues(String key) throws IOException {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("C:\\Users\\Venkatesh T S\\Downloads\\RestAPI\\src\\test\\java\\resources\\global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }

    //to extract the response body
    public static String getJsonPath(Response response, String key)
    {
        String resp=response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }
}
