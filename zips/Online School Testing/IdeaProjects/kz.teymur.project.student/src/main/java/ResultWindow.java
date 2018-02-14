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
import javax.swing.text.TableView;

/**
 * Created by iww on 25.01.2015.
 */
public class ResultWindow{

    private static ArrayList<HelpToResult> help_to = new ArrayList<HelpToResult>();
    private static JTable jtab;
    private static JScrollPane jsp;
    private static Font font;
    private static JPanel jPanel;
    private static JPanel topPanel;
    private static JButton refreshTableButton;

    ResultWindow(){
        font = new Font("Verdana", Font.PLAIN, 10);

        jPanel = new JPanel();
        TableModel model = new MyTableModel(help_to);
        jtab = new JTable(model);
        jtab.setFont(font);
        jtab.setPreferredScrollableViewportSize(new Dimension(100, 100));
        jsp = new JScrollPane(jtab);

        setColumnsWidth(jtab);

        refreshTableButton = new JButton();
        refreshTableButton.setFont(font);
        refreshTableButton.setFocusable(false);
        refreshTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == refreshTableButton){
                    Database.getResults();
                }
            }
        });

        jPanel.setLayout(new BorderLayout());
        jPanel.add(jsp, BorderLayout.CENTER);
        jPanel.add(refreshTableButton, BorderLayout.SOUTH);
    }

    public final static void setColumnsWidth(JTable table) {
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
            return 6;
        }

        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "Lesson";
                case 1:
                    return "                           Name                           ";
                case 2:
                    return "Correct";
                case 3:
                    return "Incorrect";
                case 4:
                    return "  %  ";
                case 5:
                    return " Mark ";
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
                    return bean.getName();
                case 2:
                    return bean.getCorrect();
                case 3:
                    return bean.getIncorrect();
                case 4:
                    return bean.getPercentage();
                case 5:
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

    public static void addResult(String lesson, String name, int correct, int incorrect, int percentage, int mark){
        help_to.add(new HelpToResult(lesson, name, correct, incorrect, percentage, mark));
        jtab.revalidate();
    }

    public static void removeAllResults(){
        help_to.removeAll(help_to);
    }

    public static JPanel getJPanel(){
        return jPanel;
    }

    public static void getText(){
        refreshTableButton.setText(MainMenu.globalLanguage.getRESULT_WINDOW());
    }
}
