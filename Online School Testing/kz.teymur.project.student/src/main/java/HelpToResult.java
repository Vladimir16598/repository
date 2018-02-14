/**
 * Created by iww on 25.01.2015.
 */
public class HelpToResult {

    private String lesson;
    private String name;
    private int correct;
    private int incorrect;
    private int percentage;
    private int mark;

    HelpToResult(String lesson,String name,int correct, int incorrect, int percentage, int mark){
        this.lesson = lesson;
        this.name = name;
        this.correct = correct;
        this.incorrect = incorrect;
        this.percentage = percentage;
        this.mark = mark;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

}
