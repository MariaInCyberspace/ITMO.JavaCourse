package maria.incyberspace.Lesson08.CallCentreTask;

public class CallCentreTask_main {
    public static void main(String[] args) {
        // CallCentre class has a static method that returns an array of lists: a list of dispatchers, a list of managers and a list of superintendents
        // Create a new call conductor that has a functionality of dispatching a call and initiate it with an Array of Lists of employees
        CallConductor callConductor = new CallConductor(CallCentre.seedEmployees());
        // Create a phone call
        PhoneCall phoneCall = new PhoneCall();
        // Call a 'dispatchCall' method of a CallConductor instance and pass the call instance created above as an argument
        callConductor.dispatchCall(phoneCall);
    }
}

