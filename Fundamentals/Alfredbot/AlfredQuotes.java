import java.util.Date;
public class AlfredQuotes {

    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name, String dayPeriod) {
        return String.format("Good %s, How is your day going %s?", dayPeriod, name);
    }

    public String dateAnnouncement() {
        Date someDate = new Date();
        return String.format("Today is currently %s", someDate);
    }
    

    public String respondBeforeAlexis(String conversation) {
        if (conversation.indexOf("Alexis") > - 1){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        if (conversation.indexOf("Alfred") > - 1){
            return "At your service. As you wish, naturally.";
        }
        return "place holder for snarky response return string";
    }
    // NINJA BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

