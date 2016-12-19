package ae711;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


/**
 * Created by ae711 on 19.12.2016.
 */
public class lr extends JFrame {
  public lr() {
    super("Resource local loading example");
    JPanel cp = new JPanel(new GridBagLayout());
    cp.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    JLabel icon = new JLabel(new ImageIcon(getClass().getResource("/res/logo.png")));
    JTextArea ta = new JTextArea(loadText());
    ta.setLineWrap(true);
    ta.setWrapStyleWord(true);
    cp.add(icon, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 5), 0, 0));
    cp.add(new JScrollPane(ta), new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    JButton close = new JButton("Close");
    close.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    cp.add(close, new GridBagConstraints(0, 1, 2, 1, 1, 0, GridBagConstraints.LINE_END, GridBagConstraints.NONE,
        new Insets(5, 0, 0, 0), 0, 0));
    cp.setBackground(Color.white);
    setContentPane(cp);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(400,200);
    setLocationRelativeTo(null);
  }
  
  private String loadText() {
    StringBuilder sb = new StringBuilder();
    try {
      InputStream is = getClass().getResourceAsStream("/res/text.txt");  // ��� �������
      BufferedReader br = new BufferedReader(new InputStreamReader(is, "Cp1251"));
      while (true) {
        String line = br.readLine();
        if (line == null)
          break;
        sb.append(line).append("\n");
      }
    } catch (IOException ex) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      ex.printStackTrace(pw);
      pw.flush();
      pw.close();
      sb.append("Error while loading text: ").append("\n\n");
      sb.append(sw.getBuffer().toString());
    }
    return sb.toString();
  }
  
}
