package maria.incyberspace.Lesson8.CallCentreTask;

abstract public class Employee {
    // Fields for the person's name and a flag that would mark their availability for receiving phone calls
    protected String firstName;
    protected String lastName;
    public boolean isAvailable;

    // A constructor without any arguments for testing that only sets availability field
    public Employee() {
        isAvailable = true;
    }
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        isAvailable = true;
    }

    // Getters and setters for the person's name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // A method that changes the availability field and the call's state
    public void answerPhoneCall(PhoneCall phoneCall) {
        isAvailable = false;
        phoneCall.state = CallState.ANSWERED;
        System.out.println("The call was answered.");
    }

}
