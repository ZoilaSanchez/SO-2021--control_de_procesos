import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class JTableColumnColorTest extends JFrame {
   private JTable table;
   private TableColumn tColumn;
   public JTableColumnColorTest() {
      setTitle("JTableColumnColor Test");
      table = new JTable(10, 5);
      tColumn = table.getColumnModel().getColumn(1);
      tColumn.setCellRenderer(new ColumnColorRenderer(Color.lightGray, Color.red));
      add(new JScrollPane(table), BorderLayout.CENTER);
      setSize(400, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }
   public static void main(String [] args) {
      new JTableColumnColorTest();
   }
}
// Customize the code to set the background and foreground color for each column of a JTable
class ColumnColorRenderer extends DefaultTableCellRenderer {
   Color backgroundColor, foregroundColor;
   public ColumnColorRenderer(Color backgroundColor, Color foregroundColor) {
      super();
      this.backgroundColor = backgroundColor;
      this.foregroundColor = foregroundColor;
   }
   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,   boolean hasFocus, int row, int column) {
      Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
      cell.setBackground(backgroundColor);
      cell.setForeground(foregroundColor);
      return cell;
   }
}