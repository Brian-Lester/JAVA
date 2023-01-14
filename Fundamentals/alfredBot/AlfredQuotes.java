import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String greeting = String.format("Hello, %s. Lovely to see you", name);
        return greeting;
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        String dateAnnocment = String.format("It is currently %s", date);
        return dateAnnocment;
    }
    
    public String respondBeforeAlexis(String conversation) {
        int a = conversation.indexOf("Alexis");
        int b = conversation.indexOf("Alfred");
        if (a != -1){
            return("Right away, sir. She certainly isn't sophisticated enough for that.");
        }
        if (a == -1 && b == -1 ){
            return("Right, and with that I shall retire");
        }
        else{
            return ("Right away sir");
        }
    }


    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}