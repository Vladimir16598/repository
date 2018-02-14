/**
 * Created by iww on 31.01.2015.
 */
public class GlobalLanguage {

    int CURRENT_LANGUAGE;

    String[] MAIN_WINDOW_BUTTON, TEST_WINDOW_BUTTON, RESULT_WINDOW_BUTTON, STATS_WINDOW_BUTTON,
            HELP_WINDOW_BUTTON, FEEDBACK_WINDOW_BUTTON, EXIT_BUTTON, CHANGE_LANGUAGE_BUTTON,
    TEST_REFRESH_BUTTON, FEEDBACK_WINDOW, RESULT_WINDOW, MAIN_WINDOW, NEXT_QUESTION, PREV_QUESTION,
    DONE_TEST;

    GlobalLanguage(){
        CURRENT_LANGUAGE = 0;

        //MainMenu Window
        CHANGE_LANGUAGE_BUTTON = new String[]{"Change language", "Сменить язык"};
        MAIN_WINDOW_BUTTON = new String[]{"Main", "Главная"};
        TEST_WINDOW_BUTTON = new String[]{"Test", "Тест"};
        RESULT_WINDOW_BUTTON = new String[]{"Results", "Результаты"};
        STATS_WINDOW_BUTTON = new String[]{"Stats", "Статистика"};
        HELP_WINDOW_BUTTON = new String[]{"Help", "Помощь"};
        FEEDBACK_WINDOW_BUTTON = new String[]{"Feedback", "Связь"};
        EXIT_BUTTON = new String[]{"Exit", "Выход"};

        //Test Window
        TEST_REFRESH_BUTTON = new String[]{"Refresh table", "Обновить таблицу"};

        //Feedback Window
        FEEDBACK_WINDOW = new String[]{"<html>If you have any suggestions you can send your ideas to <br><center>teymur@live.ru</center></html>",
        "<html>Если у вас есть какие-либо предложения, вы можете отправить их на <br><center>teymur@live.ru</center></html>"};

        //Result Window
        RESULT_WINDOW = new String[]{"Refresh table", "Обновить таблицу"};

        //Main Window
        MAIN_WINDOW = new String[]{"<html>Hello, it is second version of program. With my program<br> you can provide some test with students " +
                "without wasting<br> any resources. Please check new updates at twitter <br> <center>@shaykemelov</center></html>",
                "<html>Здравствуйте, это вторая версия программы. С моей программой вы <br> можете проводить тесты со студентами, " +
                        "без траты каких-либо ресурсов.<br> Пожалуйста проверьте доступность новой версии программы в twitter <center>@shaykemelov</center></html>"};

        NEXT_QUESTION = new String[]{"Next", "След."};

        PREV_QUESTION = new String[]{"Prev", "Пред."};

        DONE_TEST = new String[]{"Done", "Всё!"};
    }

    public void changeLanguage(){
        if (CURRENT_LANGUAGE == 0) {
            CURRENT_LANGUAGE = 1;
        } else if (CURRENT_LANGUAGE == 1) {
            CURRENT_LANGUAGE = 0;
        }
    }

    public String getDONE_TEST(){
        return DONE_TEST[CURRENT_LANGUAGE];
    }

    public String getPREV_QUESTION(){
        return PREV_QUESTION[CURRENT_LANGUAGE];
    }

    public String getNEXT_QUESTION(){
        return NEXT_QUESTION[CURRENT_LANGUAGE];
    }

    public String getCHANGE_LANGUAGE_BUTTON(){
        return CHANGE_LANGUAGE_BUTTON[CURRENT_LANGUAGE];
    }

    public String getMAIN_WINDOW_BUTTON(){
        return MAIN_WINDOW_BUTTON[CURRENT_LANGUAGE];
    }

    public String getTEST_WINDOW_BUTTON(){
        return TEST_WINDOW_BUTTON[CURRENT_LANGUAGE];
    }

    public String getRESULT_WINDOW_BUTTON(){
        return RESULT_WINDOW_BUTTON[CURRENT_LANGUAGE];
    }

    public String getSTATS_WINDOW_BUTTON(){
        return STATS_WINDOW_BUTTON[CURRENT_LANGUAGE];
    }

    public String getHELP_WINDOW_BUTTON(){
        return HELP_WINDOW_BUTTON[CURRENT_LANGUAGE];
    }

    public String getFEEDBACK_WINDOW_BUTTON(){
        return FEEDBACK_WINDOW_BUTTON[CURRENT_LANGUAGE];
    }

    public String getEXIT_BUTTON(){
        return EXIT_BUTTON[CURRENT_LANGUAGE];
    }

    public String getTEST_REFRESH_BUTTON(){
        return TEST_REFRESH_BUTTON[CURRENT_LANGUAGE];
    }

    public String getFEEDBACK_WINDOW(){
        return FEEDBACK_WINDOW[CURRENT_LANGUAGE];
    }

    public String getRESULT_WINDOW(){
        return RESULT_WINDOW[CURRENT_LANGUAGE];
    }

    public String getMAIN_WINDOW(){
        return MAIN_WINDOW[CURRENT_LANGUAGE];
    }
}
