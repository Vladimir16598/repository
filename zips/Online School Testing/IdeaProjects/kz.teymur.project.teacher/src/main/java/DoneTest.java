import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by iww on 23.01.2015.
 */
public class DoneTest {

    private static JPanel panel;

    private static JLabel lessonLabel;

    private static JLabel mark5Label;
    private static JLabel mark4Label;
    private static JLabel mark3Label;

    private static JTextField mark5Text;
    private static JTextField mark4Text;
    private static JTextField mark3Text;

    private static JLabel timeLabel;

    private static JTextField timeText;

    private static JLabel nameLabel;

    private static JTextField nameText;

    private static JCheckBox setActiveCheckButton;

    private static JButton doneButton;
    private static JButton backButton;

    private static Font font;

    private static JLabel classLabel;

    private static JComboBox classesNumberBox;
    private static JComboBox lessonsBox;

    private static eHandler handler;

    private static final String[] CLASSES_NUMBER = {
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11"
    };

    private static final String[] LESSONS = {
            "Algebra",
            "Biology",
            "Chemistry",
            "English",
            "Geography",
            "Geometry",
            "History",
            "Informatics",
            "Physics"
    };


    DoneTest(){

        handler = new eHandler();

        font = new Font("Verdana", Font.PLAIN, 10);

        panel = new JPanel();
        panel.setFont(font);

        lessonLabel = new JLabel("Lesson's name");
        lessonLabel.setFont(font);

        nameLabel = new JLabel("Specify the name of the test");
        nameLabel.setFont(font);

        nameText = new JTextField("Algebra_");

        mark5Label = new JLabel("Minimum points to get 5");
        mark5Label.setFont(font);

        mark4Label = new JLabel("Minimum points to get 4");
        mark4Label.setFont(font);

        mark3Label = new JLabel("Minimum points to get 3");
        mark3Label.setFont(font);

        mark5Text = new JTextField(15);
        mark5Text.setFont(font);

        mark4Text = new JTextField();
        mark4Text.setFont(font);

        mark3Text = new JTextField();
        mark3Text.setFont(font);

        timeLabel = new JLabel("Specify the time for the test(minutes):");
        timeLabel.setFont(font);

        timeText = new JTextField();
        timeText.setFont(font);

        doneButton = new JButton("Done");
        doneButton.setFont(font);
        doneButton.setFocusable(false);
        doneButton.addActionListener(handler);

        backButton = new JButton("Back");
        backButton.setFont(font);
        backButton.setFocusable(false);
        backButton.addActionListener(handler);

        classesNumberBox = new JComboBox(CLASSES_NUMBER);
        lessonsBox = new JComboBox(LESSONS);
        lessonsBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == lessonsBox){
                    nameText.setText(lessonsBox.getSelectedItem().toString() + "_");
                }
            }
        });

        setActiveCheckButton = new JCheckBox("Set test to active");

        classLabel = new JLabel("For which classes, test are");
        classLabel.setFont(font);

        panel.setLayout(new GridBagLayout());

        panel.add(lessonLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(lessonsBox, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(nameLabel, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(nameText, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(mark3Label, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(mark3Text, new GridBagConstraints(1, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(mark4Label, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(mark4Text, new GridBagConstraints(1, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(mark5Label, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(mark5Text, new GridBagConstraints(1, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(timeLabel, new GridBagConstraints(0, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(timeText, new GridBagConstraints(1, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(classLabel, new GridBagConstraints(0, 7, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(classesNumberBox, new GridBagConstraints(1, 7, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(setActiveCheckButton, new GridBagConstraints(0, 8, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(backButton, new GridBagConstraints(0, 9, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(doneButton, new GridBagConstraints(1, 9, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
    }

    public class eHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backButton){
                MainMenu.changeContent(CreateTestWindow.getJPanel());
            }
            if (e.getSource() == doneButton){

                String status;

                if (setActiveCheckButton.isSelected()){
                    status = "active";
                } else status = "inactive";

                Database.addTest(
                        lessonsBox.getSelectedItem().toString(),
                        nameText.getText(),
                        Integer.parseInt(classesNumberBox.getSelectedItem().toString()),
                        CreateTestWindow.getCount(),
                        Integer.parseInt(timeText.getText()),
                        Integer.parseInt(mark3Text.getText()),
                        Integer.parseInt(mark4Text.getText()),
                        Integer.parseInt(mark5Text.getText()),
                        status);
                lessonsBox.setSelectedIndex(0);
                nameText.setText(null);
                classesNumberBox.setSelectedIndex(0);
                timeText.setText(null);
                mark3Text.setText(null);
                mark4Text.setText(null);
                mark5Text.setText(null);
            }
        }
    }

    public static JPanel getJPanel(){
        return panel;
    }
}
