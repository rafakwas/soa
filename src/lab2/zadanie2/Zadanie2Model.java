package lab2.zadanie2;

public class Zadanie2Model {
    String player;

    String computer;

    public Zadanie2Model(String player, String computer) {
        this.player = player;
        this.computer = computer;
    }

    public String getResponse() {
        switch (player) {
            case "papier":
                if (computer.equals("nozyce")) {
                    return "computer";
                }
                break;
            case "kamien":
                if (computer.equals("papier")) {
                    return "computer";
                }
                break;
            case "nozyce":
                if (computer.equals("kamien")) {
                    return "computer";
                }
                break;
        }
        return "player";
    }

}
