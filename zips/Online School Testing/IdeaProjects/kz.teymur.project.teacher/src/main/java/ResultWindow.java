import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
/**
 * Created by iww on 18.01.2015.
 */
public class ResultWindow{

    private static ArrayList<HelpToResult> help_to = new ArrayList<HelpToResult>();
    private static JTable jtab;
    private static JScrollPane jsp;
    private static Font font;
    private static JPanel jPanel;
    private static JPanel topPanel;

    private static JButton refreshButton;

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

    private static JComboBox classesNumberBox;
    private static JComboBox lessonsBox;

    private static JButton searchButton;

    ResultWindow(){
        font = new Font("Verdana", Font.PLAIN, 10);

        handler = new eHandler();

        jPanel = new JPanel();
        TableModel model = new MyTableModel(help_to);
        jtab = new JTable(model);
        jtab.setFont(font);
        jtab.setPreferredScrollableViewportSize(new Dimension(100, 100));
        jsp = new JScrollPane(jtab);
        setColumnsWidth(jtab);

        refreshButton = new JButton();
        refreshButton.setFont(font);
        refreshButton.setFocusable(false);
        refreshButton.addActionListener(handler);

        topPanel = new JPanel();
        topPanel.setFont(font);
        topPanel.setFocusable(false);

        classesNumberBox = new JComboBox(CLASSES_NUMBER);
        classesNumberBox.setFont(font);

        lessonsBox = new JComboBox(LESSONS);
        lessonsBox.setFont(font);

        searchButton = new JButton();
        searchButton.setFont(font);
        searchButton.setFocusable(false);
        searchButton.addActionListener(handler);

        topPanel.setLayout(new GridLayout(1, 3));
        topPanel.add(classesNumberBox);
        topPanel.add(lessonsBox);
        topPanel.add(searchButton);

        jPanel.setLayout(new BorderLayout());
        jPanel.add(topPanel, BorderLayout.NORTH);
        jPanel.add(jsp, BorderLayout.CENTER);
        jPanel.add(refreshButton, BorderLayout.SOUTH);
    }

    public static void setColumnsWidth(JTable table) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JTableHeader th = table.getTableHeader();
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            int prefWidth =
                    Math.round(
                            (float) th.getFontMetrics(
                                    th.getFont()).getStringBounds(th.getTable().getColumnName(i),
                                    th.getGraphics()
                            ).getWidth()
                    );
            column.setPreferredWidth(prefWidth + 10);
        }
    }

    public class eHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == refreshButton){
                Database.getResults();
            }
            if (e.getSource() == searchButton){
                Database.getResults(Integer.parseInt(classesNumberBox.getSelectedItem().toString()), lessonsBox.getSelectedItem().toString());
            }
        }
    }

    public static void addResult(String lesson, String test, String name, String surname, int correct, int incorrect, int percentage, int mark){
        help_to.add(new HelpToResult(lesson, test, name, surname, correct, incorrect, percentage, mark));
        jtab.revalidate();
    }

    public static void removeAllResults(){
        help_to.removeAll(help_to);
        jtab.removeAll();
        jtab.revalidate();
        jtab.repaint();
    }

    @SuppressWarnings("serial")
    public class MyTableModel extends AbstractTableModel {
        private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

        private ArrayList<HelpToResult> beans;

        public MyTableModel(ArrayList<HelpToResult> beans) {
            this.beans = beans;
        }

        public void addTableModelListener(TableModelListener listener) {
            listeners.add(listener);
        }

        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        public int getColumnCount() {
            return 8;
        }

        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "Lesson";
                case 1:
                    return "                    Test                   ";
                case 2:
                    return "Name       ";
                case 3:
                    return "Surname           ";
                case 4:
                    return "Correct";
                case 5:
                    return "Incorrect";
                case 6:
                    return "  %  ";
                case 7:
                    return "Mark";
            }
            return "";
        }

        public int getRowCount() {
            return beans.size();
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            HelpToResult bean = beans.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return bean.getLesson();
                case 1:
                    return bean.getTest();
                case 2:
                    return bean.getName();
                case 3:
                    return bean.getSurname();
                case 4:
                    return bean.getCorrect();
                case 5:
                    return bean.getIncorrect();
                case 6:
                    return bean.getPercentage();
                case 7:
                    return bean.getMark();
            }
            return "";
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        public void removeTableModelListener(TableModelListener listener) {
            listeners.remove(listener);
        }

        public void setValueAt(Object value, int rowIndex, int columnIndex) {

            fireTableCellUpdated(getRowCount(), getColumnCount());
            fireTableDataChanged();
            fireTableStructureChanged();
        }
    }

    public static JPanel getJPanel(){
        return jPanel;
    }

    public static void getText(){
        refreshButton.setText(GlobalLanguage.getResultWindowRefreshTableButton());
        searchButton.setText(GlobalLanguage.getResultWindowSearchButton());
    }
}
