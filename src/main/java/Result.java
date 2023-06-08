import java.sql.Date;
import java.text.DecimalFormat;

public class Result {
    private String test;
    private String login;
    private Date date;
    private int mark;

    public Result(String test, String login, Date date, double mark) {
        this.test = test;
        this.login = login;
        this.date = date;
        this.mark = (int) (mark*10);
    }

    public Result() {
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark/10;
    }

    public void setMark(double mark) {
        this.mark = (int) mark*10;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s", login, test, date, new DecimalFormat("#0.0").format(mark/10.0));
    }
}
