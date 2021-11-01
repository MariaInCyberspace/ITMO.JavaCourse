package maria.incyberspace.Lesson8.CallCentreTask;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// A class containing 'dispatchCall' method
public class CallConductor {

    // A queue to put the call if there aren't any available employees
    private Queue<PhoneCall> phoneCalls = new ConcurrentLinkedQueue<>();
    // An array of lists of employees
    private ArrayList<Employee>[] employees;

    // A constructor that initiates a private array with the value of an array passed as an argument
    CallConductor(ArrayList<Employee>[] employees) {
        this.employees = employees;
    }

    // A method that looks for an available employee in the lists of different employees
    public Employee getAvailableEmployee(ArrayList<Employee>[] employees) {
        for (ArrayList<Employee> employee : employees) { // An outer loop iterates over the array of lists
            for (Employee value : employee) { // An inner loop iterates over the lists in this array
                if (value.isAvailable) return value;
            }
        }
        // 'Null' if no available employees found
        return null;
    }

    // A method that sets a responder for the call passed as an argument
    public void setResponderForCall(PhoneCall call) {
        // Check whether there are any free employees at the moment
        if (getAvailableEmployee(employees) != null) {
            call.setResponder(getAvailableEmployee(employees));
        } else {
            // Move the call to the queue if not
            call.state = CallState.QUEUED;
            phoneCalls.add(call);
        }
    }

    // A method that dispatches the call passed as a parameter
    public void dispatchCall(PhoneCall call) {
        // Check if there are any calls on hold
        if (phoneCalls.isEmpty()) {
            // Set a responder for this call if there aren't any calls on hold
            setResponderForCall(call);
        } else {
            // Set a responder for the call that's awaiting in the queue
            // Store the queue size in a separate variable
            int length = phoneCalls.size();
            for (int i = 0; i < length; i++) { // Iterate over the queue to deal with any awaiting calls
                setResponderForCall(phoneCalls.element());
                phoneCalls.remove(); // Remove the call we've dealt with
            }
            phoneCalls.add(call); // Add current call that's been passed as an argument to the queue
        }
    }
}
