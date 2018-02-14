import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by iww on 18.01.2015.
 */
public class StatsWindow {

    private static JPanel panel;

    private static Font font;

    private static TableModel tableModel;
    private static JTable jTable;
    private static JScrollPane jScrollPane;

    private static ArrayList<HelpToStats> helpToStats;

    StatsWindow(){
        font = new Font("Verdana", Font.PLAIN, 10);

        helpToStats = new ArrayList<>();

        panel = new JPanel();
        panel.setFont(font);

        tableModel = new MyTableModel(helpToStats);

        jTable = new JTable(tableModel);
        jTable.setPreferredScrollableViewportSize(new Dimension(100, 100));
        jScrollPane = new JScrollPane(jTable);

        panel.setLayout(new BorderLayout());
        panel.add(jScrollPane, BorderLayout.CENTER);
    }

    public static void removeAll(){
        helpToStats.removeAll(helpToStats);
    }

    public static void add(int id, String name, String surname, int classNumber, String letter){
        helpToStats.add(new HelpToStats(id, name, surname, classNumber, letter));
        jTable.revalidate();
    }

    public class MyTableModel extends AbstractTableModel {
        private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

        private ArrayList<HelpToStats> beans;

        public MyTableModel(ArrayList<HelpToStats> beans) {
            this.beans = beans;
        }

        public void addTableModelListener(TableModelListener listener) {
            listeners.add(listener);
        }

        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        public int getColumnCount() {
            return 4;
        }

        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "    Name    ";
                case 1:
                    return "    Surname     ";
                case 2:
                    return "Class";
                case 3:
                    return "Letter";
            }
            return "";
        }

        public int getRowCount() {
            return beans.size();
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            HelpToStats bean = beans.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return bean.getName();
                case 1:
                    return bean.getSurname();
                case 2:
                    return bean.getClassNumber();
                case 3:
                    return bean.getLetter();
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
        return panel;
    }
}
