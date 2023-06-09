import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StudentHandler extends DefaultHandler {
    protected List<Result> results = new ArrayList<>();
    private String loginValue = null;
    private boolean bLogin = false;
    private boolean bTest = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("login")) {
            bLogin = true;
        } else if (qName.equalsIgnoreCase("test")) {
            bTest = true;
            String testName = attributes.getValue("name");
            String testDate = attributes.getValue("date");
            String testMark = attributes.getValue("mark");
            Date date;
            try {
                date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(testDate).getTime());
            } catch (ParseException e) {
                throw new IllegalArgumentException();
            }
            results.add(new Result(testName, loginValue, date, Double.parseDouble(testMark)));
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (bLogin) {
            loginValue = new String(ch, start, length);
            bLogin = false;
        }
    }
}

