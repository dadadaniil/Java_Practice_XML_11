import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            StudentHandler handler = new StudentHandler();

            saxParser.parse("src/main/resources/results.xml", handler);

            for (Result result : handler.results) {
                System.out.println(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}