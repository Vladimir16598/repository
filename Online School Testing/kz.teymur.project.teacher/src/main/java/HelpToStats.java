/**
 * Created by Теймур on 10.02.2015.
 */
public class HelpToStats {

    private int id;
    private String name;
    private String surname;
    private int classNumber;
    private String letter;

    public HelpToStats(int id, String name, String surname, int classNumber, String letter) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.classNumber = classNumber;
        this.letter = letter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
