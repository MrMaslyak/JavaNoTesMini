import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Notes extends JFrame {
    private int value;
    private JPanel notesPanel;
    private Label label;
    private JLabel valueScroll;
    private ArrayList<Label> labels = new ArrayList<>();


    Notes() {
        setTitle("Notes");
        setSize(500, 700);
        getContentPane().setBackground(new Color(244, 204, 109));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        notesPanel = new JPanel();
        notesPanel.setBounds(0, 500, 500, 200);
        notesPanel.setBackground(new Color(216, 184, 79));
        notesPanel.setLayout(null);
        add(notesPanel);

        RoundedTextField textField = new RoundedTextField(70);
        textField.setBounds(5, 110, 415, 40);
        textField.setColumns(70);
        notesPanel.add(textField);

        RoundColorButton buttonOff = new RoundColorButton(new Color(246, 2, 23), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        buttonOff.setBounds(470, 95, 8, 8);
        notesPanel.add(buttonOff);

        RoundedButton button = new RoundedButton("->");
        button.setBounds(420, 110, 65, 40);
        button.setBackground(new Color(237, 179, 44));
        button.setForeground(Color.white);
        button.setFont(new Font("MV Boli", Font.BOLD, 25));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label = new Label(textField.getText());
                label.setFont(new Font("MV Boli", Font.PLAIN, value));
                label.setBounds(5, 20,  300, value);
                textField.setText("");
                labels.add(label);
                label.addMouseMotionListener(new MouseAdapter() {

                    @Override

                    public void mouseDragged(MouseEvent e) {
                        super.mouseDragged(e);
                        label.setBounds(e.getXOnScreen(), e.getYOnScreen(), 300, 60);
                    }
                });
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            remove(label);
                            labels.remove(label);
                            revalidate();
                            repaint();
                        }
                    }
                });
                add(label);
            }
        });

            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttonOff.setBackground(Color.GREEN);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    buttonOff.setBackground(new Color(246, 2, 23));
                }
            });


        notesPanel.add(button);

        Button clear = new Button("C");
        clear.setBounds(5, 60, 45, 40);
        clear.setFont(new Font("MV Boli", Font.BOLD, 25));
        clear.setBackground(new Color(237, 179, 44));
        clear.setForeground(Color.white);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(label);
            }
        });
        notesPanel.add(clear);

        Button clearAll = new Button("CA");
        clearAll.setBounds(5, 20, 45, 40);
        clearAll.setFont(new Font("MV Boli", Font.BOLD, 25));
        clearAll.setBackground(new Color(237, 179, 44));
        clearAll.setForeground(Color.white);
        clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              labels.forEach(label -> {
                  remove(label);
              });

            }
        });
        notesPanel.add(clearAll);

        Button fontB = new Button("B");
        fontB.setBounds(70, 5, 45, 40);
        fontB.setFont(new Font("MV Boli", Font.BOLD, 25));
        fontB.setBackground(new Color(237, 179, 44));
        fontB.setForeground(Color.white);
        fontB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setFont(new Font("MV Boli", Font.BOLD, value));
            }
        }
        );
        notesPanel.add(fontB);


        Button fontI = new Button("I");
        fontI.setBounds(115, 5, 45, 40);
        fontI.setFont(new Font("MV Boli", Font.BOLD, 25));
        fontI.setBackground(new Color(237, 179, 44));
        fontI.setForeground(Color.white);
        fontI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setFont(new Font("MV Boli", Font.ITALIC, value));
            }
        }
        );
        notesPanel.add(fontI);

        Button fontP = new Button("P");
        fontP.setBounds(160, 5, 45, 40);
        fontP.setFont(new Font("MV Boli", Font.BOLD, 25));
        fontP.setBackground(new Color(237, 179, 44));
        fontP.setForeground(Color.white);
        fontP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setFont(new Font("MV Boli", Font.PLAIN, value));
            }
        }
        );
        notesPanel.add(fontP);

        JLabel labelF = new JLabel("Fonts");
        labelF.setBounds(110, 42, 80, 30);
        labelF.setFont(new Font("MV Boli", Font.ITALIC, 20));
        notesPanel.add(labelF);

        valueScroll = new JLabel("0");
        valueScroll.setBounds(220, 65, 50, 50);
        notesPanel.add(valueScroll);

        JScrollBar  scrollBar = new JScrollBar();
        scrollBar.setBounds(240, 20, 20, 80);
        scrollBar.setBackground(new Color(216, 184, 79));
        scrollBar.setForeground(Color.white);
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                 value = e.getValue();
                 valueScroll.setText(String.valueOf(value));

            }
        });
        notesPanel.add(scrollBar);


        RoundColorButton buttonRed = new RoundColorButton(new Color(255, 0, 0), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setForeground(Color.red);
            }
        });
        buttonRed.setBounds(70, 68, 45, 45);
        notesPanel.add(buttonRed);


        RoundColorButton buttonWhite = new RoundColorButton(new Color(255, 255, 255), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setForeground(Color.WHITE);
            }
        });
        buttonWhite.setBounds(115, 68, 45, 45);
        notesPanel.add(buttonWhite);

        RoundColorButton buttonBlue = new RoundColorButton(new Color(0, 68, 241), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setForeground(Color.BLUE);
            }
        });
        buttonBlue.setBounds(160, 68, 45, 45);
        notesPanel.add(buttonBlue);






        setVisible(true);
    }


}