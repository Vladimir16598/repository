import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionWithTest {

    private JPanel panel;

    private JButton backButton;
    private JButton doneButton;

    private JTextField nameText;
    private JTextField timeText;

    private JComboBox statusBox;
    private JComboBox classBox;
    private JComboBox lessonBox;

    ActionWithTest(final int id, String lesson, String name, int classNumber, int time, final String status){

        Font font = new Font("Verdana", Font.PLAIN, 10);

        panel = new JPanel();

        JLabel lessonLabel = new JLabel("Select lesson");
        lessonLabel.setFont(font);

        String[] lessons = {
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
        lessonBox = new JComboBox(lessons);
        lessonBox.setFont(font);
        lessonBox.setSelectedItem(lesson);
        lessonBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == lessonBox){
                    nameText.setText(lessonBox.getSelectedItem().toString() + "_");
                }
            }
        });

        JLabel nameLabel = new JLabel("Set name");
        nameLabel.setFont(font);

        nameText = new JTextField(name);
        nameText.setFont(font);

        JLabel classLabel = new JLabel("Select class");
        classLabel.setFont(font);

        String[] classNumber1 = {
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
        classBox = new JComboBox(classNumber1);
        classBox.setFont(font);
        classBox.setSelectedItem(Integer.toString(classNumber));

        JLabel timeLabel = new JLabel("Set time");
        timeLabel.setFont(font);

        timeText = new JTextField(Integer.toString(time));
        timeText.setFont(font);

        JLabel statusLabel = new JLabel("Select status");
        statusLabel.setFont(font);

        String[] status1 = {
                "Active",
                "Inactive"
        };
        statusBox = new JComboBox(status1);
        statusBox.setFont(font);
        statusBox.setSelectedItem(status);

        backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.setFont(font);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton){
                    MainMenu.changeContent(TestWindow.getJPanel());
                }
            }
        });

        doneButton = new JButton("Done");
        doneButton.setFocusable(false);
        doneButton.setFont(font);
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == doneButton){
                    Database.updateTest(id, lessonBox.getSelectedItem().toString(), nameText.getText(),
                            Integer.parseInt(classBox.getSelectedItem().toString()), Integer.parseInt(timeText.getText()),
                            statusBox.getSelectedItem().toString());
                    Database.getLisTests();
                    MainMenu.changeContent(TestWindow.getJPanel());
                }
            }
        });

        panel.setLayout(new GridBagLayout());

        //String lesson, String name, int classNumber, int time, String status
        panel.add(lessonLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(lessonBox, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(nameLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(nameText, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(classLabel, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(classBox, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(timeLabel, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(timeText, new GridBagConstraints(1, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(statusLabel, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(statusBox, new GridBagConstraints(1, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(backButton, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panel.add(doneButton, new GridBagConstraints(1, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
    }

    public JPanel getPanel(){
        return panel;
    }
}
