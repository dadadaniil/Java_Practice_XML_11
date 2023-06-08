import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            StudentHandler handler = new StudentHandler();

            saxParser.parse("src/main/resources/results.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
/*        try {
            File inputFile = new File("src/main/resources/results.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String login = eElement.getElementsByTagName("login").item(0).getTextContent();

                    NodeList tests = eElement.getElementsByTagName("test");
                    for (int count = 0; count < tests.getLength(); count++) {
                        Node node1 = tests.item(count);

                        if (node1.getNodeType() == Node.ELEMENT_NODE) {
                            Element test = (Element) node1;
                            String testName = test.getAttribute("name");
                            String testDate = test.getAttribute("date");
                            String testMark = test.getAttribute("mark");

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = new Date(format.parse(testDate).getTime());

                            Result result = new Result(testName, login, date, Double.parseDouble(testMark));
                            System.out.println(result);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        System.out.println();
    }
}