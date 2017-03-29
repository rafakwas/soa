package lab3.zadanie6;

public class Movie {
    private String title;
    private String genre;
    private Double income;
    private String year;

    public Movie(String title, String genre, Double income, String year) {
        this.title = title;
        this.genre = genre;
        this.income = income;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
