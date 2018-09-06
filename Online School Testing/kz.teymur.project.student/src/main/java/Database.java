import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

public class Database {

    private static Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/kz.project.database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static final String GET_LIST_TESTS = "SELECT * FROM tests WHERE status = ? AND class = ?;";
    private static final String GET_QUESTIONS = "SELECT * FROM questions WHERE id = ?;";
    private static final String GET_RESULTS = "SELECT * FROM results WHERE id_user = ?;";

    private static final String LOGIN = "SELECT * FROM users WHERE login = ? AND password = ?;";
    private static final String OPEN_SESSION = "UPDATE users set session = 'online' WHERE id = ?;";
    private static final String CLOSE_SESSION = "UPDATE users set session = 'offline' WHERE id = ?";
    private static final String INSERT_NEW_USER = "INSERT INTO users(name, surname, login, password, email, class_number, class_letter, status, session) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String INSERT_NEW_RESULT = "INSERT INTO results(id_test, name_test, id_user, name_user, surname_user, correct, incorrect, percentage, mark, lesson, class) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String STUDENT = "student";

    private static int idUser;
    private static int class_Number;

    private static String userLogin;
    private static String name;
    private static String surname;
    private static String email;
    private static ArrayList<Integer> results_id = new ArrayList<>();

    private static final Font font = new Font("Verdana", Font.PLAIN, 15);

    public static String getLogin(){
        return userLogin;
    }
    public static String getName(){
        return name;
    }
    public static String getSurname(){
        return surname;
    }
    public static String getEmail(){
        return email;
    }
    public static int getIdUser(){
        return idUser;
    }

    public static void connectToDatabase(){
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loginTheProgram(String login, String password){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LOGIN);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, getMD5(password));

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                if (resultSet.getString("status").equals(STUDENT)){
                    JOptionPane.showMessageDialog(null, "Hi " + resultSet.getString("name") + "! You successfully logged the program.");
                    idUser = resultSet.getInt("id");
                    name = resultSet.getString("name");
                    surname = resultSet.getString("surname");
                    email = resultSet.getString("email");
                    class_Number = resultSet.getInt("class_number");
                    userLogin = login;
                    PreparedStatement preparedStatementLogin = connection.prepareStatement(OPEN_SESSION);
                    preparedStatementLogin.setInt(1, idUser);
                    preparedStatementLogin.execute();
                    preparedStatement.close();
                    Main.goToMainMenu();
                    Main.classesAfterLogin();
                } else JOptionPane.showMessageDialog(null, "You are not student!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed, incorrect login or password! Please try again.");
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getLisTests(){
        try {
            ListTests.removeAllTest();

            PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_TESTS);
            preparedStatement.setString(1, "active");
            preparedStatement.setInt(2, class_Number);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                boolean t = false;
                int id_test = resultSet.getInt("id");
                for (Integer i:results_id){
                    if (i == id_test){
                        t = true;
                    }
                }
                if (!t){
                    String lesson = resultSet.getString("lesson");
                    String name = resultSet.getString("name");
                    int classNumber = resultSet.getInt("class");
                    int time = resultSet.getInt("time");
                    int point3 = resultSet.getInt("point3");
                    int point4 = resultSet.getInt("point4");
                    int point5 = resultSet.getInt("point5");
                    String status = resultSet.getString("status");
                    ListTests.addTest(id_test, lesson, name, classNumber, time, point3, point4, point5, status);
                }
            }

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getQuestions(int id, OpenTest openTest){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_QUESTIONS);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(6, 1));

                ButtonGroup buttonGroup = new ButtonGroup();

                JLabel questionLabel = new JLabel(resultSet.getString("question"));
                questionLabel.setFont(font);
                panel.add(questionLabel);

                JRadioButton answer_A = new JRadioButton(resultSet.getString("answer_A"));
                answer_A.setFont(font);
                panel.add(answer_A);

                JRadioButton answer_B = new JRadioButton(resultSet.getString("answer_B"));
                answer_B.setFont(font);
                panel.add(answer_B);

                JRadioButton answer_C = new JRadioButton(resultSet.getString("answer_C"));
                answer_C.setFont(font);
                panel.add(answer_C);

                JRadioButton answer_D = new JRadioButton(resultSet.getString("answer_D"));
                answer_D.setFont(font);
                panel.add(answer_D);

                JRadioButton answer_E = new JRadioButton(resultSet.getString("answer_E"));
                answer_A.setFont(font);
                panel.add(answer_E);

                buttonGroup.add(answer_A);
                buttonGroup.add(answer_B);
                buttonGroup.add(answer_C);
                buttonGroup.add(answer_D);
                buttonGroup.add(answer_E);

                panel.setBorder(BorderFactory.createEtchedBorder());

                String key = resultSet.getString("trueAnswer");

                openTest.addQuestion(panel, key);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addResult(int idTest, String nameTest, int idUser, String nameUser, String surnameUser,
                                 int correct, int incorrect, int percentage, int mark, String lesson){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_RESULT);
            preparedStatement.setInt(1, idTest);
            preparedStatement.setString(2, nameTest);
            preparedStatement.setInt(3, idUser);
            preparedStatement.setString(4, nameUser);
            preparedStatement.setString(5, surnameUser);
            preparedStatement.setInt(6, correct);
            preparedStatement.setInt(7, incorrect);
            preparedStatement.setInt(8, percentage);
            preparedStatement.setInt(9, mark);
            preparedStatement.setString(10, lesson);
            preparedStatement.setInt(11, class_Number);
            preparedStatement.execute();
            preparedStatement.close();
            MainMenu.changeContent(ResultWindow.getJPanel());
            getResults();
            getLisTests();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getResults(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_RESULTS);
            preparedStatement.setInt(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultWindow.removeAllResults();
            while (resultSet.next()){
                int id_test = resultSet.getInt("id_test");
                String lesson = resultSet.getString("lesson");
                String name_test = resultSet.getString("name_test");
                int correct = resultSet.getInt("correct");
                int incorrect = resultSet.getInt("incorrect");
                int percentage = resultSet.getInt("percentage");
                int mark = resultSet.getInt("mark");
                ResultWindow.addResult(lesson, name_test, correct, incorrect, percentage, mark);

                int id_user = resultSet.getInt("id_user");

                if (idUser == id_user){
                    results_id.add(id_test);
                }
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerNewUser(String name, String surname, String login, String password, String email, int class_number, String class_letter){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, getMD5(password));
            preparedStatement.setString(5, email);
            preparedStatement.setInt(6, class_number);
            preparedStatement.setString(7, class_letter);
            preparedStatement.setString(8, "student");
            preparedStatement.setString(9, "offline");
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            RegisterWindow.endRegister();
        }
    }

    public static void closeConnection(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CLOSE_SESSION);
            preparedStatement.setInt(1, idUser);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

