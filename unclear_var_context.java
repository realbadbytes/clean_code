/* shit code
function is too long
variables are used throughout with no real meaning/context
*/

private void printGuessStatistics(char candidate, int count) {
    String number;
    String verb;
    String pluralModifier;
    if (count == 0) {
        number = "no";
        verb = "are";
        pluralModifier = "s";
    }
    else if (count == 1) {
        number = "1";
        verb = "is";
        pluralModifier = "";
    } 
    else {
        number = Integer.toString(count);
        verb = "are";
        pluralModifier = "s";
    }
    String guessMessage = String.format(
        "There %s %s %s%s verb", number, candidate, pluralModifier);
    print(guessMessage);
}

/* less shit code
create a class to provide context
private methods set the member variables
all the implementation is hidden from user of GuessStatisticsMessage
*/

public class GuessStatisticsMessage {
    private String number;
    private String verb;
    private String pluralModifier;

    public String make(char candidate, int count) {
        createPluralDependentMessageParts(count);
        return String.format("There %s %s %s%s", verb, number, candidate, pluralModifer);
    }

    private void createPluralDependentMessageParts(int count) {
        if (count == 0) {
            thereAreNoLetters();
        }
        else if (count == 1) {
            thereIsOneLetter();
        }
        else {
            thereAreManyLetters(count);
        }
    }

    private void thereAreManyLetters(int count) {
        number = Integer.toString(count);
        verb = "are";
        pluralModifier = "s";
    }

    private void thereIsOneLetter() {
        number = "1";   
        verb = "is";
        pluralModifier = "";
    }

    private void thereAreNoLetters() {
        number = "no";
        verb = "are";
        pluralModifer = "s";
    }
}




















