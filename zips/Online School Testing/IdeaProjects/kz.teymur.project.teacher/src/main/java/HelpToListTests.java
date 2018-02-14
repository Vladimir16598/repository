/**
 * Created by iww on 24.01.2015.
 */
public class HelpToListTests {

    private int id;
    private int time;

    private int classNumber;


    private String lesson;
    private String name;
    private String status;


    HelpToListTests(int id, String lesson, String name,int classNumber, int time, String status){
        this.id = id;
        this.lesson = lesson;
        this.name = name;
        this.classNumber = classNumber;
        this.time = time;
        this.status = status;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }
}

