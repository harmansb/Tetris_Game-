
import java.awt.*;
import java.awt.event.*;

class TextEditor extends Frame {

    private TextArea textArea;

    public TextEditor() {
        // Set layout manager for the frame
        setLayout(new BorderLayout());

        // Create menu bar
        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        // Create File menu
        Menu fileMenu = new Menu("File");
        menuBar.add(fileMenu);

        // Create File menu items
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem printItem = new MenuItem("Print");
        MenuItem newItem = new MenuItem("New");

        // Add action listeners to File menu items
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
        printItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printTextArea();
            }
        });
        newItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createNewFile();
            }
        });

        // Add File menu items to File menu
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(printItem);
        fileMenu.add(newItem);

        // Create Edit menu
        Menu editMenu = new Menu("Edit");
        menuBar.add(editMenu);

        // Create Edit menu items
        MenuItem cutItem = new MenuItem("Cut");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        MenuItem closeItem = new MenuItem("Close");

        // Add action listeners to Edit menu items
        cutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cut();
            }
        });
        copyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                copy();
            }
        });
        pasteItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paste();
            }
        });
        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });

        // Add Edit menu items to Edit menu
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.add(closeItem);

        // Create text area
        textArea = new TextArea();
        add(textArea, BorderLayout.CENTER);

        // Create close button
        Button closeButton = new Button("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        add(closeButton, BorderLayout.SOUTH);

        // Set properties of the frame
        setTitle("Text Editor");
        setSize(800, 600);
        setVisible(true);
    }

    public void openFile() {
        System.out.println("Open File clicked.");
    }

    public void saveFile() {
        System.out.println("Save File clicked.");
    }

    public void printTextArea() {
        System.out.println("Printing text area: " + textArea.getText());
    }

    public void createNewFile() {
        System.out.println("Creating new blank file.");
        textArea.setText("");
    }

    public void cut() {
        System.out.println("Cut selected area and copy to clipboard.");
    }

    public void copy() {
        System.out.println("Copy selected area to clipboard.");
    }

    public void paste() {
        System.out.println("Paste text from clipboard to text area.");
    }
    public void close() {
        System.out.println("Closing the text editor.");
        System.exit(0);
    }
    
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
    }
}