import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by iww on 22.01.2015.
 */

public class CreateTestWindow {

    private static JPanel mainPanel;

    private static JPanel questionsPanel;

    private static JScrollPane jScrollPane;

    private static JButton addQuestionButton;

    private static JButton restoreButton;
    private static JButton cancelButton;
    private static JButton nextButton;

    private static eHandler handler;

    private static ArrayList<JPanel> panels = new ArrayList<JPanel>();
    private static ArrayList<String> keys = new ArrayList<String>();
    private static ArrayList<File> images = new ArrayList<File>();

    private static JPanel bottomButtonGroupPanel;

    private static Font font;

    CreateTestWindow(){
        handler = new eHandler();

        font = new Font("Verdana", Font.PLAIN, 10);

        mainPanel = new JPanel();
        mainPanel.setFont(font);

        addQuestionButton = new JButton("Add new question");
        addQuestionButton.setFocusable(false);
        addQuestionButton.setFont(font);
        addQuestionButton.addActionListener(handler);

        restoreButton = new JButton("Clear");
        restoreButton.setFocusable(false);
        restoreButton.setFont(font);
        restoreButton.addActionListener(handler);

        cancelButton = new JButton("Cancel");
        cancelButton.setFocusable(false);
        cancelButton.setFont(font);
        cancelButton.addActionListener(handler);

        nextButton = new JButton("Next");
        nextButton.setFocusable(false);
        nextButton.setFont(font);
        nextButton.addActionListener(handler);

        questionsPanel = new JPanel();
        questionsPanel.setFont(font);

        jScrollPane = new JScrollPane(questionsPanel);
        jScrollPane.setFont(font);

        bottomButtonGroupPanel = new JPanel();

        bottomButtonGroupPanel.setLayout(new GridLayout(1,3));
        bottomButtonGroupPanel.add(cancelButton);
        bottomButtonGroupPanel.add(nextButton);
        bottomButtonGroupPanel.add(restoreButton);

        questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));

        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(addQuestionButton, BorderLayout.NORTH);
        mainPanel.add(jScrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomButtonGroupPanel, BorderLayout.SOUTH);
    }

    public static void addPanelQuestion(JPanel panelQuestion, String key, ArrayList<File> imagesArray){
        panelQuestion.setBorder(BorderFactory.createEtchedBorder());
        panels.add(panelQuestion);
        panelQuestion.setPreferredSize(new Dimension(365, 235));
        questionsPanel.add(panelQuestion);
        jScrollPane.revalidate();
        keys.add(key);
        images.addAll(imagesArray);
    }

    public static void removeQuestion(JPanel rPanel, String rKey, ArrayList<File> rImages){
        panels.remove(rPanel);
        keys.remove(rKey);
        images.removeAll(rImages);

        questionsPanel.remove(rPanel);
        questionsPanel.repaint();
        questionsPanel.revalidate();
    }

    public static void restoreTest(){
        panels.removeAll(panels);
        keys.removeAll(keys);
        images.removeAll(images);
        questionsPanel.removeAll();
        questionsPanel.repaint();
        questionsPanel.revalidate();
    }

    public static int getCount(){
        return questionsPanel.getComponentCount();
    }

    public class eHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addQuestionButton){
                AddQuestion addQuestion = new AddQuestion();
                MainMenu.changeContent(addQuestion.getPanelQuestion());
            }
            if (e.getSource() == restoreButton){
                restoreTest();
            }
            if (e.getSource() == cancelButton){
                restoreTest();
                MainMenu.changeContent(TestWindow.getJPanel());
            }
            if (e.getSource() == nextButton){
                MainMenu.changeContent(DoneTest.getJPanel());
            }
        }
    }

    public static ArrayList<JPanel> getTest(){
        return panels;
    }

    public static ArrayList<String> getKeys(){
        return keys;
    }

    public static ArrayList<File> getImages(){
        return images;
    }

    public static JPanel getJPanel(){
        return mainPanel;
    }
}
