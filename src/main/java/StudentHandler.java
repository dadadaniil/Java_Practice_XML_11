import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentHandler extends DefaultHandler {
    private String loginValue = null;
    private boolean bLogin = false;
    private boolean bTest = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("login")) {
            bLogin = true;
        } else if (qName.equalsIgnoreCase("test")) {
            bTest = true;
            String testName = attributes.getValue("name");
            String testDate = attributes.getValue("date");
            String testMark = attributes.getValue("mark");
            Date date = null;
            try {
                date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(testDate).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Result result = new Result(testName, loginValue, date, Double.parseDouble(testMark));
            System.out.println(result);
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (bLogin) {
            loginValue = new String(ch, start, length);
            bLogin = false;
        }
    }
}

