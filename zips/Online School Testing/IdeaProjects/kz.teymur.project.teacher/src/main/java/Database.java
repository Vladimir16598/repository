import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class Database {

    private static Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/kz.project.database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static final String INSERT_NEW_USER = "INSERT INTO users(name, surname, login, password, email, class_number, class_letter, status, session) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String INSERT_NEW_TEST = "INSERT INTO tests(lesson, name, class, count, time, point3, point4, point5, status) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String INSERT_NEW_QUESTION = "INSERT INTO questions (id, question, question_img," +
            "answer_A, answer_A_img, answer_B, answer_B_img, answer_C, answer_C_img," +
            "answer_D, answer_D_img, answer_E, answer_E_img, trueAnswer)" +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String LOGIN = "SELECT * FROM users WHERE login = ? AND password = ?;";

    private static final String OPEN_SESSION = "UPDATE users set session = 'online' WHERE id = ?;";
    private static final String CLOSE_SESSION = "UPDATE users set session = 'offline' WHERE id = ?";

    private static final String GET_ID_TEST = "SELECT * FROM tests WHERE name = ?";
    private static final String GET_RESULTS = "SELECT * FROM results;";
    private static final String GET_RESULTS_WHERE = "SELECT * FROM results WHERE lesson = ? AND class = ?";
    private static final String GET_LIST_TESTS = "SELECT * FROM tests";

    private static final String GET_ONLINE_USERS = "SELECT * FROM users WHERE session = 'online' AND status = 'student';";

    private static final String UPDATE_TEST = "update tests set lesson = ?, name = ?, class = ?, time = ?, status = ? where id = ?;";
    private static final String TEACHER = "teacher";

    private static int id;
    private static String userLogin;
    private static String userName;
    private static String userSurname;
    private static String userEmail;

    public static void connectToDatabase(){
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getResults(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_RESULTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultWindow.removeAllResults();
            while (resultSet.next()){
                //int id_test = resultSet.getInt("id_test");
                String lesson = resultSet.getString("lesson");
                String name_test = resultSet.getString("name_test");
                String name_user = resultSet.getString("name_user");
                String surname_user = resultSet.getString("surname_user");
                //int id_user = resultSet.getInt("id_user");
                int correct = resultSet.getInt("correct");
                int incorrect = resultSet.getInt("incorrect");
                int percentage = resultSet.getInt("percentage");
                int mark = resultSet.getInt("mark");
                ResultWindow.addResult(lesson, name_test, name_user, surname_user, correct, incorrect, percentage, mark);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getOnlineUsers(){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ONLINE_USERS);
            StatsWindow.removeAll();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int classNumber = resultSet.getInt("class_number");
                String classLetter = resultSet.getString("class_letter");
                StatsWindow.add(id, name, surname, classNumber, classLetter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loginTheProgram(String login, String password){
        try {

            userLogin = login;

            PreparedStatement preparedStatement = connection.prepareStatement(LOGIN);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                if (resultSet.getString("status").equals(TEACHER)){
                    JOptionPane.showMessageDialog(null, "Hi " + resultSet.getString("name") + "! You successfully logged the program.");
                    id = resultSet.getInt("id");
                    userName = resultSet.getString("name");
                    userSurname = resultSet.getString("surname");
                    userEmail = resultSet.getString("email");
                    Main.goToMainMenu();
                    PreparedStatement preparedStatementLogin = connection.prepareStatement(OPEN_SESSION);
                    preparedStatementLogin.setInt(1, id);
                    preparedStatementLogin.execute();
                    preparedStatement.close();
                } else JOptionPane.showMessageDialog(null, "You are not teacher!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed, incorrect login or password! Please try again.");
            }
            Main.classesAfterLogin();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getUserLogin(){
        return userLogin;
    }
    public static String getUserName(){
        return userName;
    }
    public static String getUserSurname(){
        return userSurname;
    }
    public static String getUserEmail(){
        return userEmail;
    }

    public static void getResults(int classNumber, String lesson){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_RESULTS_WHERE);
            preparedStatement.setString(1, lesson);
            preparedStatement.setInt(2, classNumber);

            ResultSet resultSet = preparedStatement.executeQuery();
            ResultWindow.removeAllResults();
            while (resultSet.next()){
                //int id_test = resultSet.getInt("id_test");
                String lessonGot = resultSet.getString("lesson");
                String name_test = resultSet.getString("name_test");
                String name_user = resultSet.getString("name_user");
                String surname_user = resultSet.getString("surname_user");
                //int id_user = resultSet.getInt("id_user");
                int correct = resultSet.getInt("correct");
                int incorrect = resultSet.getInt("incorrect");
                int percentage = resultSet.getInt("percentage");
                int mark = resultSet.getInt("mark");
                ResultWindow.addResult(lessonGot, name_test, name_user, surname_user, correct, incorrect, percentage, mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getLisTests(){
        try {
            ListTests.removeAllTest();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_TESTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String lesson = resultSet.getString("lesson");
                String name = resultSet.getString("name");
                int classNumber = resultSet.getInt("class");
                int time = resultSet.getInt("time");
                String status = resultSet.getString("status");
                ListTests.addTest(id, lesson, name, classNumber, time, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getIDTest(String name){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ID_TEST);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                addQuestions(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addTest(String lesson, String name, int classNumber, int count, int time, int point3,
                               int point4, int point5, String status){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_TEST);
            preparedStatement.setString(1, lesson);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, classNumber);
            preparedStatement.setInt(4, count);
            preparedStatement.setInt(5, time);
            preparedStatement.setInt(6, point3);
            preparedStatement.setInt(7, point4);
            preparedStatement.setInt(8, point5);
            preparedStatement.setString(9, status);
            preparedStatement.execute();
            preparedStatement.close();
            getIDTest(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addQuestions(int id){
        try {
            int k = 0;
            for (int i = 0; i < CreateTestWindow.getTest().size(); i++) {

                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_QUESTION);

                preparedStatement.setInt(1, id);

                preparedStatement.setString(2, ((JLabel) CreateTestWindow.getTest().get(i).getComponent(0)).getText());
                preparedStatement.setBlob(3, new FileInputStream(CreateTestWindow.getImages().get(k))); k++;

                preparedStatement.setString(4, ((JLabel) CreateTestWindow.getTest().get(i).getComponent(1)).getText());
                preparedStatement.setBlob(5, new FileInputStream(CreateTestWindow.getImages().get(k))); k++;

                preparedStatement.setString(6, ((JLabel) CreateTestWindow.getTest().get(i).getComponent(2)).getText());
                preparedStatement.setBlob(7, new FileInputStream(CreateTestWindow.getImages().get(k))); k++;

                preparedStatement.setString(8, ((JLabel) CreateTestWindow.getTest().get(i).getComponent(3)).getText());
                preparedStatement.setBlob(9, new FileInputStream(CreateTestWindow.getImages().get(k))); k++;

                preparedStatement.setString(10, ((JLabel) CreateTestWindow.getTest().get(i).getComponent(4)).getText());
                preparedStatement.setBlob(11, new FileInputStream(CreateTestWindow.getImages().get(k))); k++;

                preparedStatement.setString(12, ((JLabel) CreateTestWindow.getTest().get(i).getComponent(5)).getText());
                preparedStatement.setBlob(13, new FileInputStream(CreateTestWindow.getImages().get(k))); k++;

                preparedStatement.setString(14, CreateTestWindow.getKeys().get(i));

                preparedStatement.execute();
                MainMenu.changeContent(TestWindow.getJPanel());
                getLisTests();
            }
            CreateTestWindow.restoreTest();
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void updateTest(int id, String lesson, String name, int classNumber, int time, String status){
        try {
            //update tests set subject = '?', name = '?', class = ?, time = ?, status = ? where id = ?;
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TEST);
            preparedStatement.setString(1, lesson);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, classNumber);
            preparedStatement.setInt(4, time);
            preparedStatement.setString(5, status);
            preparedStatement.setInt(6, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void registerNewUser(String name, String surname, String login, String password, String email, int class_number, String class_letter){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, email);
            preparedStatement.setInt(6, class_number);
            preparedStatement.setString(7, class_letter);
            preparedStatement.setString(8, "teacher");
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
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

