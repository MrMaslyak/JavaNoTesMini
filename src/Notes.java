import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Notes extends JFrame implements MouseMotionListener, MouseListener, ActionListener, AdjustmentListener {
    private int value;
    private JPanel notesPanel;
    private Label label;
    private JLabel valueScroll;
    private ArrayList<Label> labels = new ArrayList<>();
    private RoundColorButton buttonRed, buttonWhite, buttonBlue, buttonOff;
    private Button  fontB, fontI,  fontP, clearAll, clear;
    private RoundedButton button;
    private  RoundedTextField textField;

    Notes() {
        setTitle("Notes");
        setSize(500, 700);
        getContentPane().setBackground(new Color(244, 204, 109));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui();
        setLayout(null);
        setVisible(true);
    }

    public void ui() {
        notesPanel = new JPanel();
        notesPanel.setBounds(0, 500, 500, 200);
        notesPanel.setBackground(new Color(216, 184, 79));
        notesPanel.setLayout(null);
        add(notesPanel);

        textField = new RoundedTextField(70);
        textField.setBounds(5, 110, 415, 40);
        textField.setColumns(70);
        notesPanel.add(textField);

        buttonOff = new RoundColorButton(new Color(246, 2, 23));
        buttonOff.setBounds(470, 95, 8, 8);
        notesPanel.add(buttonOff);

        button = new RoundedButton("->");
        button.setBounds(420, 110, 65, 40);
        button.setBackground(new Color(237, 179, 44));
        button.setForeground(Color.white);
        button.setFont(new Font("MV Boli", Font.BOLD, 25));
        button.addActionListener(this);
        notesPanel.add(button);

        clear = new Button("C");
        clear.setBounds(5, 60, 45, 40);
        clear.setFont(new Font("MV Boli", Font.BOLD, 25));
        clear.setBackground(new Color(237, 179, 44));
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        notesPanel.add(clear);

        clearAll = new Button("CA");
        clearAll.setBounds(5, 20, 45, 40);
        clearAll.setFont(new Font("MV Boli", Font.BOLD, 25));
        clearAll.setBackground(new Color(237, 179, 44));
        clearAll.setForeground(Color.white);
        clearAll.addActionListener(this);
        notesPanel.add(clearAll);

        fontB = new Button("B");
        fontB.setBounds(70, 5, 45, 40);
        fontB.setFont(new Font("MV Boli", Font.BOLD, 25));
        fontB.setBackground(new Color(237, 179, 44));
        fontB.setForeground(Color.white);
        fontB.addActionListener(this);
        notesPanel.add(fontB);


        fontI = new Button("I");
        fontI.setBounds(115, 5, 45, 40);
        fontI.setFont(new Font("MV Boli", Font.BOLD, 25));
        fontI.setBackground(new Color(237, 179, 44));
        fontI.setForeground(Color.white);
        fontI.addActionListener(this);
        notesPanel.add(fontI);

        fontP = new Button("P");
        fontP.setBounds(160, 5, 45, 40);
        fontP.setFont(new Font("MV Boli", Font.BOLD, 25));
        fontP.setBackground(new Color(237, 179, 44));
        fontP.setForeground(Color.white);
        fontP.addActionListener(this);
        notesPanel.add(fontP);

        JLabel labelF = new JLabel("Fonts");
        labelF.setBounds(110, 42, 80, 30);
        labelF.setFont(new Font("MV Boli", Font.ITALIC, 20));
        notesPanel.add(labelF);

        valueScroll = new JLabel("0");
        valueScroll.setBounds(220, 65, 50, 50);
        notesPanel.add(valueScroll);

        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBounds(240, 20, 20, 80);
        scrollBar.setBackground(new Color(216, 184, 79));
        scrollBar.setForeground(Color.white);
        scrollBar.addAdjustmentListener(this);
        notesPanel.add(scrollBar);


        buttonRed = new RoundColorButton(new Color(255, 0, 0));
        buttonRed.setBounds(70, 68, 45, 45);
        buttonRed.addActionListener((ActionListener) this);
        notesPanel.add(buttonRed);


        buttonWhite = new RoundColorButton(new Color(255, 255, 255));
        buttonWhite.setBounds(115, 68, 45, 45);
        buttonWhite.addActionListener((ActionListener) this);
        notesPanel.add(buttonWhite);

        buttonBlue = new RoundColorButton(new Color(0, 68, 241));
        buttonBlue.setBounds(160, 68, 45, 45);
        buttonBlue.addActionListener((ActionListener) this);
        notesPanel.add(buttonBlue);

    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        value = e.getValue();
        valueScroll.setText(String.valueOf(value));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonRed) {
            label.setForeground(Color.red);
        }
        else if (e.getSource() == buttonWhite) {
            label.setForeground(Color.white);
        }
        else if (e.getSource() == buttonBlue) {
            label.setForeground(Color.blue);
        }
        else if (e.getSource() == fontB) {
            label.setFont(new Font("MV Boli", Font.BOLD, value));
        }
        else if (e.getSource() == fontI) {
            label.setFont(new Font("MV Boli", Font.ITALIC, value));
        }
        else if (e.getSource() == fontP) {
            label.setFont(new Font("MV Boli", Font.PLAIN, value));
        }
        else if (e.getSource() == clearAll) {
            labels.forEach(this::remove);
        }
        else if (e.getSource() == clear){
            remove(label);
        }else {
            label = new Label(textField.getText());
            label.setFont(new Font("MV Boli", Font.PLAIN, value));
            label.setBounds(5, 20, 200, value);
            textField.setText("");
            labels.add(label);
            label.addMouseMotionListener(Notes.this);
            button.addMouseListener((MouseListener) Notes.this);
            add(label);
        }






    }


        @Override
        public void mouseClicked(MouseEvent e) {

        }


    @Override
    public void mousePressed(MouseEvent e) {
        buttonOff.setBackground(Color.GREEN);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttonOff.setBackground(new Color(246, 2, 23));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        label.setBounds(e.getXOnScreen(), e.getYOnScreen(), 300, 60);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }



}

