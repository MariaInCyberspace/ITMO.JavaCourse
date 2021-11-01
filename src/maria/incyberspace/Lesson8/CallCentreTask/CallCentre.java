package maria.incyberspace.Lesson8.CallCentreTask;

import java.util.ArrayList;
import java.util.Arrays;

public class CallCentre {

    // A static method that returns an array of lists of employees from dispatchers to superintendents
    public static ArrayList<Employee>[] seedEmployees() {
        ArrayList<Dispatcher> dispatchers = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Superintendent> superintendents = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dispatchers.add(new Dispatcher());
        }
        for (int i = 0; i < 4; i++) {
            managers.add(new Manager());
        }
        for (int i = 0; i < 2; i++) {
            superintendents.add(new Superintendent());
        }

        return new ArrayList[] { dispatchers, managers, superintendents };
    }
}
