package view;

import controller.ControllerButtons;
import controller.FileReader;
import controller.FileWriter;
import model.Human;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainFrame {
    private JFrame jFrame;

    private JPanel jPanel = new JPanel();
    private JPanel panelForToolBarAndTable = new JPanel();
    private JPanel panelForPagination = new JPanel();

    private JTable jTable = new JTable();
    private ControllerButtons controllerButtons;
    private List<Human> studentsList = new ArrayList<>();
    private JScrollPane jScrollPane;

    public MainFrame(ControllerButtons controllerButtons) {
        this.controllerButtons = controllerButtons;
        controllerButtons.setStudentsList(studentsList);
        jFrame = new JFrame();
        jFrame.setSize(1100, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panels();
        createToolBar();
        createMenuBar();
        createTable();
        createPagination();
        jFrame.setVisible(true);
    }

    private void panels() {
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        panelForToolBarAndTable.setLayout(new BoxLayout(panelForToolBarAndTable, BoxLayout.X_AXIS));
        jPanel.add(panelForToolBarAndTable);
        jFrame.add(jPanel);
    }

    private void createToolBar() {
        JToolBar jToolBar = new JToolBar();
        jToolBar.setLayout(new BoxLayout(jToolBar, BoxLayout.Y_AXIS));
        jToolBar.setEnabled(false);
        createAddButton(jToolBar);
        createDeleteButton(jToolBar);
        createSearchButton(jToolBar);
        createOpenButton(jToolBar);
        createSaveButton(jToolBar);
        jFrame.add(jToolBar, BorderLayout.WEST);
    }

    private void createMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setBackground(Color.LIGHT_GRAY);
        createFileMenu(jMenuBar);
        createInstrumentMenu(jMenuBar);
        jFrame.setJMenuBar(jMenuBar);
    }

    private void createFileMenu(JMenuBar jMenuBar) {
        JMenu fileMenu = new JMenu("Файл");

        JMenuItem openMenu = new JMenuItem("Открыть");
        JMenuItem saveMenu = new JMenuItem("Сохранить");

        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);

        jMenuBar.add(fileMenu);
    }

    private void createInstrumentMenu(JMenuBar jMenuBar) {
        JMenu instrumentMenu = new JMenu("Интсрументы");

        JMenuItem addMenu = new JMenuItem("Добавить");
        JMenuItem deleteMenu = new JMenuItem("Удалить");
        JMenuItem searchMenu = new JMenuItem("Поиск");

        instrumentMenu.add(addMenu);
        instrumentMenu.add(deleteMenu);
        instrumentMenu.add(searchMenu);

        jMenuBar.add(instrumentMenu);
    }

    private void createAddButton(JToolBar jToolBar) {
        JButton addButton = new JButton(new ImageIcon("images/add.png"));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButtons.createNewStudent();
            }
        });
        jToolBar.add(addButton);
    }

    private void createDeleteButton(JToolBar jToolBar) {
        JButton deleteButton = new JButton(new ImageIcon("images/delete.png"));
        jToolBar.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButtons.deleteStudent();
            }
        });
    }

    private void createSearchButton(JToolBar jToolBar) {
        JButton searchButton = new JButton(new ImageIcon("images/search.png"));
        jToolBar.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButtons.setjScrollPane(jScrollPane);
                controllerButtons.searchStudent();
            }
        });
    }

    private void createOpenButton(JToolBar jToolBar) {
        JButton openButton = new JButton(new ImageIcon("images/open.png"));
        jToolBar.add(openButton);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("C:\\Users\\1o\\Desktop"));
                int result = fileChooser.showDialog(null, "open");
                if (result == JFileChooser.APPROVE_OPTION)
                    if (fileChooser.getSelectedFile().getName().contains(".xml")) {
                        new FileReader(studentsList, fileChooser.getSelectedFile().getPath(), jTable, controllerButtons);
                    }
                jTable.updateUI();
            }
        });
    }

    private void createSaveButton(JToolBar jToolBar) {
        JButton saveButton = new JButton(new ImageIcon("images/save.png"));
        jToolBar.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("C:\\Users\\1o\\Desktop"));
                int result = fileChooser.showDialog(null, "xml");
                if (result == JFileChooser.APPROVE_OPTION) {
                    new FileWriter(studentsList, fileChooser.getSelectedFile().getPath());
                }
            }
        });
    }

    private void createTable() {
        controllerButtons.setjTable(jTable);
        jScrollPane = new JScrollPane(jTable);
        panelForToolBarAndTable.add(jScrollPane);
    }

    private void createPagination() {
        Pagenation pagenation = new Pagenation(studentsList, controllerButtons);
        jPanel.add(pagenation);
    }
//
    public void addTableModel(TableModel tableModel) {
        jTable.setModel(tableModel);
    }

    public JPanel getPanelForToolBarAndTable() {
        return panelForToolBarAndTable;
    }

    public JTable getjTable() {
        return jTable;
    }
}

