package departmentStore;

import javax.xml.crypto.Data;
import java.util.Date;

public class Period implements Validatot {
    public Date startDate;
    public Date endDate;

    public Period(Date startDate, Date endDate) {
        this.endDate = endDate;
        this.startDate = startDate;
    }

    @Override
    public boolean validate(Data today) {
        return false;
    }

    @Override
    public boolean validate(Date today) {
        return today.after(startDate) && today.before(endDate);
    }
}