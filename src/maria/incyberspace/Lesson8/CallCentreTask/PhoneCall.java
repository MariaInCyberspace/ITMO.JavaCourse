package maria.incyberspace.Lesson8.CallCentreTask;

enum CallState {
    ANSWERED, QUEUED
}
public class PhoneCall {
    public CallState state;
    CallConductor myConductor;

    // A method that sets a responder for the call instance that called it
    public void setResponder(Employee employee) {
        employee.answerPhoneCall(this);
    }
}
