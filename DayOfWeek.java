package departmentStore;

import javax.xml.crypto.Data;
import java.util.Date;

public class DayOfWeek implements Validatot {
    public String[] daysOfWeek;

    public DayOfWeek(String[] daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    @Override
    public boolean validate(Data today) {
        return false;
    }

    @Override
    public boolean validate(Date today) {
        int dayOfWeek = today.getDay();
        String todayString = getDayString(dayOfWeek);
        for (String day : daysOfWeek) {
            if (day.equalsIgnoreCase(todayString)) {
                return true;
            }
        }
        return false;
    }

    private String getDayString(int dayOfWeek) {
        switch (dayOfWeek) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return "";
        }
    }
}