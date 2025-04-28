import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortedListGUI extends JFrame {
    private SortedList sortedList;
    private JTextArea displayArea;
    private JTextField inputField;
    private JButton addButton;
    private JButton searchButton;

    public SortedListGUI() {
        sortedList = new SortedList();

        setTitle("Sorted List GUI");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        inputField = new JTextField(20);
        addButton = new JButton("Add");
        searchButton = new JButton("Search");
        topPanel.add(inputField);
        topPanel.add(addButton);
        topPanel.add(searchButton);
        add(topPanel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                sortedList.add(input);
                displayArea.setText(sortedList.toString());
                inputField.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String result = sortedList.search(input);
                displayArea.setText(result + "\n\n" + sortedList.toString());
                inputField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new SortedListGUI().setVisible(true);
    }
}


