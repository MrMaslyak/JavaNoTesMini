import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NotesPage extends JFrame {

    private JPanel mainPanel;
    private JTextArea notesTextArea;

    public NotesPage() {
        setTitle("PageNotes");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        notesTextArea = new JTextArea(10, 30);
        notesTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(notesTextArea);
        mainPanel.add(scrollPane);

        add(mainPanel);
    }

    public void setNotes(String notes) {
        notesTextArea.setText(notes);
    }
}
