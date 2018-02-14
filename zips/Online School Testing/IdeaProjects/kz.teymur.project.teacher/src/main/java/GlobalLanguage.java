/**
 * Created by Теймур on 19.02.2015.
 */
public class GlobalLanguage {

    private static int CURRENT_LANGUAGE;

    private static String[] TEST_WINDOW_CREATE_TEST_BUTTON, TEST_WINDOW_REFRESH_TABLE_BUTTON,
            RESULT_WINDOW_REFRESH_TABLE_BUTTON, RESULT_WINDOW_SEARCH_BUTTON, CHANGE_LANGUAGE_BUTTON,
            MAIN_WINDOW_BUTTON, TEST_WINDOW_BUTTON, RESULT_WINDOW_BUTTON, STATS_WINDOW_BUTTON, HELP_WINDOW_BUTTON,
            FEEDBACK_WINDOW_BUTTON, EXIT_BUTTON;

    GlobalLanguage(){
        CURRENT_LANGUAGE = 0;

        CHANGE_LANGUAGE_BUTTON = new String[]{"Change language", "Сменить язык"};
        MAIN_WINDOW_BUTTON = new String[]{"Main", "Главная"};
        TEST_WINDOW_BUTTON = new String[]{"Test", "Тест"};
        RESULT_WINDOW_BUTTON = new String[]{"Results", "Результаты"};
        STATS_WINDOW_BUTTON = new String[]{"Stats", "Статистика"};
        HELP_WINDOW_BUTTON = new String[]{"Help", "Помощь"};
        FEEDBACK_WINDOW_BUTTON = new String[]{"Feedback", "Связь"};
        EXIT_BUTTON = new String[]{"Exit", "Выход"};

        TEST_WINDOW_CREATE_TEST_BUTTON = new String[]{"Create test", "Создать тест"};
        TEST_WINDOW_REFRESH_TABLE_BUTTON = new String[]{"Refresh table", "Обновить таблицу"};

        RESULT_WINDOW_REFRESH_TABLE_BUTTON = new String[]{"Refresh table", "Обновить таблицу"};
        RESULT_WINDOW_SEARCH_BUTTON = new String[]{"Search", "Искать"};


    }

    public void changeLanguage(){
        if (CURRENT_LANGUAGE == 0) {
            CURRENT_LANGUAGE = 1;
        } else if (CURRENT_LANGUAGE == 1) {
            CURRENT_LANGUAGE = 0;
        }
    }

    public static String getTestWindowRefreshTableButton() {
        return TEST_WINDOW_REFRESH_TABLE_BUTTON[CURRENT_LANGUAGE];
    }

    public static String getTestWindowCreateTestButton() {
        return TEST_WINDOW_CREATE_TEST_BUTTON[CURRENT_LANGUAGE];
    }

    public static String getResultWindowRefreshTableButton() {
        return RESULT_WINDOW_REFRESH_TABLE_BUTTON[CURRENT_LANGUAGE];
    }

    public static String getResultWindowSearchButton() {
        return RESULT_WINDOW_SEARCH_BUTTON[CURRENT_LANGUAGE];
    }

    public static String getChangeLanguageButton() {
        return CHANGE_LANGUAGE_BUTTON[CURRENT_LANGUAGE];
    }

    public static String getMainWindowButton() {
        return MAIN_WINDOW_BUTTON[CURRENT_LANGUAGE];
    }

    public static String getTestWindowButton() {
        return TEST_WINDOW_BUTTON[CURRENT_LANGUAGE];
    }

    public static String getResultWindowButton() {
        return RESULT_WINDOW_BUTTON[CURRENT_LANGUAGE];
    }

    public static String getStatsWindowButton() {
        return STATS_WINDOW_BUTTON[CURRENT_LANGUAGE];
    }

    public static String getHelpWindowButton() {
        return HELP_WINDOW_BUTTON[CURRENT_LANGUAGE];
    }

    public static String getFeedbackWindowButton() {
        return FEEDBACK_WINDOW_BUTTON[CURRENT_LANGUAGE];
    }

    public static String getExitButton() {
        return EXIT_BUTTON[CURRENT_LANGUAGE];
    }
}

