import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * Created by iww on 23.01.2015.
 */
public class AddQuestion {

    private JPanel panelQuestion;

    private JLabel questionLabel;

    private JLabel answerALabel;
    private JLabel answerBLabel;
    private JLabel answerCLabel;
    private JLabel answerDLabel;
    private JLabel answerELabel;

    private JButton imageQuestionButton;

    private JButton imageAnswerAButton;
    private JButton imageAnswerBButton;
    private JButton imageAnswerCButton;
    private JButton imageAnswerDButton;
    private JButton imageAnswerEButton;

    private JButton completeQuestionButton;
    private JButton cancelButton;

    private JTextField questionText;

    private JTextField answerAText;
    private JTextField answerBText;
    private JTextField answerCText;
    private JTextField answerDText;
    private JTextField answerEText;

    private ButtonGroup buttonGroup;

    private JCheckBox answerACheck;
    private JCheckBox answerBCheck;
    private JCheckBox answerCCheck;
    private JCheckBox answerDCheck;
    private JCheckBox answerECheck;

    private eHandler handler;

    private ArrayList<File> images;

    private File imgQuestion;
    private File imgA;
    private File imgB;
    private File imgC;
    private File imgD;
    private File imgE;

    private Font font;

    AddQuestion(){

        images = new ArrayList<File>();

        imgQuestion = new File("default.png");

        imgA = new File("default.png");
        imgB = new File("default.png");
        imgC = new File("default.png");
        imgD = new File("default.png");
        imgE = new File("default.png");

        font = new Font("Verdana", Font.PLAIN, 10);

        panelQuestion = new JPanel();
        panelQuestion.setFont(font);

        handler = new eHandler();

        questionLabel = new JLabel("Question:");
        questionLabel.setFont(font);

        answerALabel = new JLabel("A");
        answerALabel.setFont(font);

        answerBLabel = new JLabel("B");
        answerBLabel.setFont(font);

        answerCLabel = new JLabel("C");
        answerCLabel.setFont(font);

        answerDLabel = new JLabel("D");
        answerDLabel.setFont(font);

        answerELabel = new JLabel("E");
        answerELabel.setFont(font);

        questionText = new JTextField(15);
        questionText.setFont(font);

        answerAText = new JTextField();
        answerAText.setFont(font);

        answerBText = new JTextField();
        answerBText.setFont(font);

        answerCText = new JTextField();
        answerCText.setFont(font);

        answerDText = new JTextField();
        answerDText.setFont(font);

        answerEText = new JTextField();
        answerEText.setFont(font);

        imageQuestionButton = new JButton("IMG");
        imageQuestionButton.setFocusable(false);
        imageQuestionButton.setFont(font);
        imageQuestionButton.addActionListener(handler);

        imageAnswerAButton = new JButton("IMG");
        imageAnswerAButton.setFocusable(false);
        imageAnswerAButton.setFont(font);
        imageAnswerAButton.addActionListener(handler);

        imageAnswerBButton = new JButton("IMG");
        imageAnswerBButton.setFocusable(false);
        imageAnswerBButton.setFont(font);
        imageAnswerBButton.addActionListener(handler);

        imageAnswerCButton = new JButton("IMG");
        imageAnswerCButton.setFocusable(false);
        imageAnswerCButton.setFont(font);
        imageAnswerCButton.addActionListener(handler);

        imageAnswerDButton = new JButton("IMG");
        imageAnswerDButton.setFocusable(false);
        imageAnswerDButton.setFont(font);
        imageAnswerDButton.addActionListener(handler);

        imageAnswerEButton = new JButton("IMG");
        imageAnswerEButton.setFocusable(false);
        imageAnswerEButton.setFont(font);
        imageAnswerEButton.addActionListener(handler);

        buttonGroup = new ButtonGroup();

        answerACheck = new JCheckBox("A");
        answerACheck.setFont(font);

        answerBCheck = new JCheckBox("B");
        answerBCheck.setFont(font);

        answerCCheck = new JCheckBox("C");
        answerCCheck.setFont(font);

        answerDCheck = new JCheckBox("D");
        answerDCheck.setFont(font);

        answerECheck = new JCheckBox("E");
        answerECheck.setFont(font);

        buttonGroup.add(answerACheck);
        buttonGroup.add(answerBCheck);
        buttonGroup.add(answerCCheck);
        buttonGroup.add(answerDCheck);
        buttonGroup.add(answerECheck );

        completeQuestionButton = new JButton("Make");
        completeQuestionButton.setFocusable(false);
        completeQuestionButton.setFont(font);
        completeQuestionButton.addActionListener(handler);

        cancelButton = new JButton("Cancel");
        cancelButton.setFocusable(false);
        cancelButton.setFont(font);
        cancelButton.addActionListener(handler);

        panelQuestion.setLayout(new GridBagLayout());

        //Question
        panelQuestion.add(questionLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(questionText, new GridBagConstraints(1, 0, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(imageQuestionButton, new GridBagConstraints(4, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        //A
        panelQuestion.add(answerALabel, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(answerAText, new GridBagConstraints(1, 1, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(imageAnswerAButton, new GridBagConstraints(4, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        //B
        panelQuestion.add(answerBLabel, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(answerBText, new GridBagConstraints(1, 2, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(imageAnswerBButton, new GridBagConstraints(4, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));


        //C
        panelQuestion.add(answerCLabel, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(answerCText, new GridBagConstraints(1, 3, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(imageAnswerCButton, new GridBagConstraints(4, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));


        //D
        panelQuestion.add(answerDLabel, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(answerDText, new GridBagConstraints(1, 4, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(imageAnswerDButton, new GridBagConstraints(4, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        // E
        panelQuestion.add(answerELabel, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(answerEText, new GridBagConstraints(1, 5, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(imageAnswerEButton, new GridBagConstraints(4, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        //Answer's checkBOX
        panelQuestion.add(answerACheck, new GridBagConstraints(0, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(answerBCheck, new GridBagConstraints(1, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(answerCCheck, new GridBagConstraints(2, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(answerDCheck, new GridBagConstraints(3, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(answerECheck, new GridBagConstraints(4, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(completeQuestionButton, new GridBagConstraints(0, 7, 5, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        panelQuestion.add(cancelButton, new GridBagConstraints(0, 8, 5, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
    }

    public class eHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == completeQuestionButton){
                completedQuestion();
            }
            if (e.getSource() == cancelButton){
                cancelQuestion();
            }
            if (e.getSource() == imageQuestionButton){
                try {
                    imgQuestion = new File( new AddImage().getImage());
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource() == imageAnswerAButton){
                try {
                    imgA = new File( new AddImage().getImage());
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource() == imageAnswerBButton){
                try {
                    imgB = new File( new AddImage().getImage());
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource() == imageAnswerCButton){
                try {
                    imgC = new File( new AddImage().getImage());
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource() == imageAnswerDButton){
                try {
                    imgD = new File( new AddImage().getImage());
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource() == imageAnswerEButton){
                try {
                    imgE = new File( new AddImage().getImage());
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public void completedQuestion(){
        final JPanel panel = new JPanel();
        panel.setFont(font);

        JLabel questionLabel = new JLabel("Question." + this.questionText.getText());
        questionLabel.setBorder(BorderFactory.createEtchedBorder());
        questionLabel.setFont(font);

        JLabel answerALabel = new JLabel("A. " + this.answerAText.getText());
        answerALabel.setFont(font);

        JLabel answerBLabel = new JLabel("B. " + this.answerBText.getText());
        answerBLabel.setFont(font);

        JLabel answerCLabel = new JLabel("C. " + this.answerCText.getText());
        answerCLabel.setFont(font);

        JLabel answerDLabel = new JLabel("D. " + this.answerDText.getText());
        answerDLabel.setFont(font);

        JLabel answerELabel = new JLabel("E. " + this.answerEText.getText());
        answerELabel.setFont(font);

        final JButton editQuestion = new JButton("Edit");
        editQuestion.setFocusable(false);
        editQuestion.setFont(font);

        editQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == editQuestion){
                    JOptionPane.showMessageDialog(null, "Now you can not edit questions!");
                }
            }
        });

        final JButton removeQuestion = new JButton("Remove");
        removeQuestion.setFocusable(false);
        removeQuestion.setFont(font);

        panel.setLayout(new GridLayout(8, 1));
        panel.add(questionLabel);
        panel.add(answerALabel);
        panel.add(answerBLabel);
        panel.add(answerCLabel);
        panel.add(answerDLabel);
        panel.add(answerELabel);
        panel.add(editQuestion);
        panel.add(removeQuestion);

        final StringBuffer key = new StringBuffer();

        if (answerACheck.isSelected()){
            key.append("A");
        } else if (answerBCheck.isSelected()){
            key.append("B");
        } else if (answerCCheck.isSelected()){
            key.append("C");
        } else if (answerDCheck.isSelected()){
            key.append("D");
        } else if (answerECheck.isSelected()){
            key.append("E");
        }

        removeQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == removeQuestion){
                    CreateTestWindow.removeQuestion(panel, key.toString(), images);
                }
            }
        });

        images.add(imgQuestion);
        images.add(imgA);
        images.add(imgB);
        images.add(imgC);
        images.add(imgD);
        images.add(imgE);

        CreateTestWindow.addPanelQuestion(panel, key.toString(), images);
        MainMenu.changeContent(CreateTestWindow.getJPanel());
    }

    public void cancelQuestion(){
        MainMenu.changeContent(CreateTestWindow.getJPanel());
    }

    public JPanel getPanelQuestion(){
        return  panelQuestion;
    }
}
