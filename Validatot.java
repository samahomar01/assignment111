package departmentStore;
import javax.xml.crypto.Data;
import java.util.Date;


public interface Validatot {
    public boolean validate(Data today);

    boolean validate(Date today);
}
