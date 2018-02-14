/**
 * Created by iww on 25.01.2015.
 */
public class HelpToListTests {

    private int id;
    private int time;

    private String lesson;
    private String name;

    private int point3;
    private int point4;
    private int point5;

    HelpToListTests(int id, String lesson, String name, int time, int point3, int point4, int point5){
        this.id = id;
        this.lesson = lesson;
        this.name = name;
        this.time = time;
        this.point3 = point3;
        this.point4 = point4;
        this.point5 = point5;
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

    public int getPoint3() {
        return point3;
    }

    public void setPoint3(int point3) {
        this.point3 = point3;
    }

    public int getPoint4() {
        return point4;
    }

    public void setPoint4(int point4) {
        this.point4 = point4;
    }

    public int getPoint5() {
        return point5;
    }

    public void setPoint5(int point5) {
        this.point5 = point5;
    }

}

