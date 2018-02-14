import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class ListTests{

    private static ArrayList<HelpToListTests> help_to = new ArrayList<HelpToListTests>();
    private static JTable jtab;
    private static JScrollPane jsp;
    private static Font font;
    private static JPanel jPanel;

    ListTests(){
        font = new Font("Verdana", Font.PLAIN, 10);

        jPanel = new JPanel();
        TableModel model = new MyTableModel(help_to);
        jtab = new JTable(model);
        jtab.setFont(font);
        jtab.setPreferredScrollableViewportSize(new Dimension(100, 100));
        jtab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2){
                    int selectedRows = jtab.getSelectedRow();
                    TableModel model = jtab.getModel();

                    int id = (int) model.getValueAt(selectedRows, 0);
                    String lesson = (String) model.getValueAt(selectedRows, 1);
                    String name = (String) model.getValueAt(selectedRows, 2);
                    int classNumber = (int) model.getValueAt(selectedRows, 3);
                    int time = (int) model.getValueAt(selectedRows, 4);
                    String status = (String) model.getValueAt(selectedRows, 5);

                    MainMenu.changeContent(new ActionWithTest(id, lesson, name, classNumber, time, status).getPanel());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        jsp = new JScrollPane(jtab);
        setColumnsWidth(jtab);
        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.add(jsp);
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

    public static void addTest(int id, String lesson, String name, int classNumber, int time, String status){
        help_to.add(new HelpToListTests(id, lesson, name, classNumber, time, status));
        jtab.revalidate();
    }

    public static void removeAllTest(){
        help_to.removeAll(help_to);
    }

    @SuppressWarnings("serial")
    public class MyTableModel extends AbstractTableModel {
        private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

        private ArrayList<HelpToListTests> beans;

        public MyTableModel(ArrayList<HelpToListTests> beans) {
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
                    return "ID";
                case 1:
                    return "Lesson";
                case 2:
                    return "                                                         Name                                         ";
                case 3:
                    return "Class";
                case 4:
                    return "Time";
                case 5:
                    return "Status";
            }
            return "";
        }

        public int getRowCount() {
            return beans.size();
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            HelpToListTests bean = beans.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return bean.getId();
                case 1:
                    return bean.getLesson();
                case 2:
                    return bean.getName();
                case 3:
                    return bean.getClassNumber();
                case 4:
                    return bean.getTime();
                case 5:
                    return bean.getStatus();
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

    public static JScrollPane getJsp(){
        return jsp;
    }
}
