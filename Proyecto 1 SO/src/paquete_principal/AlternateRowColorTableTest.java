import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class AlternateRowColorTableTest extends JFrame {
   public AlternateRowColorTableTest() {
      setTitle("AlternateRowColorTable Test");
      JTable table = new JTable(new Object[][] {{"115", "Ramesh"}, {"120", "Adithya"}, {"125", "Jai"}, {"130", "Chaitanya"}, {"135", "Raja"}}, new String[] {"Employee Id", "Employee Name"}) {
         public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
            Component comp = super.prepareRenderer(renderer, row, column);
            Color alternateColor = new Color(200, 201, 210);
            Color whiteColor = Color.WHITE;
            if(!comp.getBackground().equals(getSelectionBackground())) {
               Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
               comp.setBackground(bg);
               bg = null;
            }
            return comp;
         }
      };
      add(new JScrollPane(table));
      setSize(400, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }
   public static void main(String[] args) {
      new AlternateRowColorTableTest();
   }
}