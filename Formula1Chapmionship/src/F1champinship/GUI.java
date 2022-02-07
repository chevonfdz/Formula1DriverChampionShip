/**
 * Name: Chevon Fernando
 * Westminster no: w1839044
 * IIT no: 20200970
 */

package F1champinship;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class GUI {
    static Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager(); //creating object

    static JFrame jFrame = new JFrame("Formula 1 Championship Driver Statistic Table");
    static Font font = new Font("Roboto", Font.BOLD, 14);

    static JPanel panel1;
    static JPanel panel2;
    static JPanel panel3;
    static JPanel panel4;
    static JPanel panel5;

    static JLabel label1;
    static JLabel label2;
    static JLabel label3;
    static JLabel label4;
    static JLabel label5;

    static JTable table1;
    static JTable table2;
    static JTable table3;
    static JTable table4;
    static JTable table5;

    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JButton button4;
    static JButton button5;
    static JButton button6;
    static JButton button7;
    static JButton button8;
    static JButton button9;
    static JButton button10;

    static JTextField textField1;

    static JScrollPane scrollPane1;
    static JScrollPane scrollPane2;
    static JScrollPane scrollPane3;
    static JScrollPane scrollPane4;
    static JScrollPane scrollPane5;

    static JLayeredPane layeredPane;
    static JLayeredPane layeredPane1;

    static DefaultTableModel jtModel1;
    static DefaultTableModel jtModel2;
    static DefaultTableModel jtModel3;
    static DefaultTableModel jtModel4;
    static DefaultTableModel jtModel5;

    /**
     * First, create a Jframe and add 2panels named panel 1, panel 2.
     * panel 1 is not movable and pane 2 is movable.
     * For panel 2 again added Layeredpanel and add the background photo and after the button is pressed it will swap.
     */
    public static void main(String[] args) throws IOException
    {
        BufferedImage myPicture = ImageIO.read(new File("190218_Alfa-Romeo-Racing_f1car.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        buttons();
        picLabel.setBounds(0, 0, 1000, 450);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1000, 450);

        layeredPane1 = new JLayeredPane();
        layeredPane1.setBounds(0, 0, 920, 450);

        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBounds(0, 0, 1000, 450);
        panel4.setBackground(Color.black);
        panel4.add(picLabel);
        layeredPane.add(panel4);
        panelSwitcher(panel4);

        label1 = new JLabel();
        label1.setText("Formula 1 Championship");
        label1.setFont(new Font("Roboto", Font.ITALIC, 44));
        label1.setForeground(Color.red);
        label1.setBounds(0, 0, 1000, 100);
        label1.setHorizontalAlignment(JLabel.CENTER);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.BLACK);
        panel1.setPreferredSize(new Dimension(1000, 150));
        panel1.add(label1);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.BLACK);
        panel2.setPreferredSize(new Dimension(1000, 450));
        panel2.add(layeredPane);

        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BorderLayout());
        jFrame.setSize(1000, 600);
        jFrame.setBackground(Color.BLACK);
        jFrame.setVisible(true);
        jFrame.add(panel1, BorderLayout.NORTH);
        jFrame.add(panel2, BorderLayout.CENTER);

    }


    /**
     *When the GUI is displayed there are main 3 buttons,
     * and it will display 3 different sections and under this method,
     * it will call all the following methods.
     */
    public static void buttons()
    {
        //heading button
        button1 = new JButton("SORT TABLE");
        button1.setBounds(100, 110, 200, 25);
        button1.setFont(font);
        button1.setForeground(Color.ORANGE);
        button1.setBackground(Color.black);
        button1.addActionListener(e -> {
            sortTable();
            panel3.add(label3);
            panel3.add(scrollPane1);
        });

        button2 = new JButton("RANDOM RACE");
        button2.setBounds(400, 110, 200, 25);
        button2.setFont(font);
        button2.setForeground(Color.ORANGE);
        button2.setBackground(Color.black);
        button2.setOpaque(true);
        button2.addActionListener(e -> {
            randomRace();
            panel4.add(label4);
        });

        button3 = new JButton("SEARCH DRIVER");
        button3.setBounds(700, 110, 200, 25);
        button3.setFont(font);
        button3.setForeground(Color.ORANGE);
        button3.setBackground(Color.black);
        button3.setOpaque(true);
        button3.addActionListener(e -> {
            searchDriver();
            panel5.add(label5);
        });
    }

    /**
     * When the user enters the sorting table it will display another panel and in that panel again there are 3buttons.
     * For the table, data is loaded from the Formula1Championship.txt text file
     */
    public static void sortTable()
    {
        //sort table settings
        panel3 = new JPanel();
        panel3.setBounds(10, 10, 960, 420);
        panel3.setLayout(null);
        panel3.setBackground(Color.BLACK);
        layeredPane.add(panel3);
        panelSwitcher(panel3);

        label3 = new JLabel();
        label3.setBounds(20, 10, 920, 35);
        label3.setBackground(Color.RED);
        label3.setOpaque(true);

        button4 = new JButton("SORT BY POINTS");
        button4.setFont(font);
        button4.setBounds(74, 7, 200, 25);
        button4.setForeground(Color.ORANGE);
        button4.setBackground(Color.black);
        button4.addActionListener(e -> sortByPoints());
        label3.add(button4);

        button5 = new JButton("SORT BY 1ST POSITIONS");
        button5.setFont(font);
        button5.setBounds(345, 7, 260, 25);
        button5.setForeground(Color.ORANGE);
        button5.setBackground(Color.black);
        button5.addActionListener(e -> sortByPosition());
        label3.add(button5);

        button6 = new JButton("SORT BY RACES");
        button6.setFont(font);
        button6.setBounds(675, 7, 200, 25);
        button6.setForeground(Color.ORANGE);
        button6.setBackground(Color.black);
        button6.addActionListener(e -> sortByRaces());
        label3.add(button6);

        //creating the table
        String[] column = {" Name ", " Location ", " Team ", " 1st ", " 2nd ", " 3rd ", " Points ", " Races "};
        jtModel1 = new DefaultTableModel(column, 0);  //creating the Default Table Model
        table1 = new JTable(jtModel1);

        //loading the data
        formula1ChampionshipManager.readInformationInFile();
        for (int i = 0; i < Formula1ChampionshipManager.formula1DriverList.size(); i++) {
            String driverName = Formula1ChampionshipManager.formula1DriverList.get(i).getDriverName();
            String location = Formula1ChampionshipManager.formula1DriverList.get(i).getDriverLocation();
            String teamName = Formula1ChampionshipManager.formula1DriverList.get(i).getTeamNames();
            int firstPosi = Formula1ChampionshipManager.formula1DriverList.get(i).getFirstPosition();
            int secondPosi = Formula1ChampionshipManager.formula1DriverList.get(i).getSecondPosition();
            int thirdPosi = Formula1ChampionshipManager.formula1DriverList.get(i).getThirdPosition();
            int numOfPoints = Formula1ChampionshipManager.formula1DriverList.get(i).getNumberOfPoints();
            int numOfRaces = Formula1ChampionshipManager.formula1DriverList.get(i).getNumberOfRaces();

            Object[] dataColumn = {driverName, location, teamName, firstPosi, secondPosi, thirdPosi, numOfPoints, numOfRaces};
            jtModel1.addRow(dataColumn);
        }
        scrollPane1 = new JScrollPane(table1);
        scrollPane1.setBounds(20, 70, 920, 300);
    }


    /**
     * Display the random race and random race with probability, and Race logs(with dates).
     * race log is sorted by the data.
     */
    public static void randomRace()
    {
        //random race table settings
        panel4 = new JPanel();
        panel4.setBounds(10, 10, 960, 420);
        panel4.setLayout(null);
        panel4.setBackground(Color.BLACK);
        layeredPane.add(panel4);
        panelSwitcher(panel4);
        panel4.add(layeredPane1);

        label4 = new JLabel();
        label4.setBounds(20, 10, 920, 35);
        label4.setBackground(Color.RED);
        label4.setOpaque(true);

        button7 = new JButton("RANDOM RACE");
        button7.setFont(font);
        button7.setBounds(74, 7, 200, 25);
        button7.setForeground(Color.ORANGE);
        button7.setBackground(Color.black);

        //
        String[] column = {" Date ", "1st ", " 2nd ", " 3rd ", " 4th ", " 5th ", " 6th ", " 7th ", " 8th ", " 9th ", " 10th "};
        jtModel2 = new DefaultTableModel(column, 0);  //creating the Default Table Model
        table2 = new JTable(jtModel2);

        button7.addActionListener(e -> {
            addRandomRace();
            scrollPane2 = new JScrollPane(table2);
            scrollPane2.setBounds(20, 70, 920, 300);
            layeredPane1.add(scrollPane2);
            tableSwitcher(scrollPane2);

        });
        label4.add(button7);

        button8 = new JButton("RANDOM RACE (PROBABILITY)");
        button8.setFont(font);
        button8.setBounds(345, 7, 260, 25);
        button8.setForeground(Color.ORANGE);
        button8.setBackground(Color.black);

        String[] column2 = {"Date", "Name ", " Team ", " Start Position ", " Finish Position "};
        jtModel4 = new DefaultTableModel(column2, 0);  //creating the Default Table Model
        table4 = new JTable(jtModel4);

        button8.addActionListener(e -> {
            addRandomRaceProbability();
            scrollPane4 = new JScrollPane(table4);
            scrollPane4.setBounds(20, 70, 920, 300);
            layeredPane1.add(scrollPane4);
            tableSwitcher(scrollPane4);
        });
        label4.add(button8);

        button10 = new JButton("RACE LOG (DATES)");
        button10.setFont(font);
        button10.setBounds(675, 7, 200, 25);
        button10.setForeground(Color.ORANGE);
        button10.setBackground(Color.black);

        String[] column3 = {" Date ", "Name", "Location", "Teams", "1st ", " 2nd ", " 3rd ", "Points", "Races"};
        jtModel5 = new DefaultTableModel(column3, 0);  //creating the Default Table Model
        table5 = new JTable(jtModel5);

        button10.addActionListener(e -> {
            raceLogDates();
            scrollPane5 = new JScrollPane(table5);
            scrollPane5.setBounds(20, 70, 920, 300);
            layeredPane1.add(scrollPane5);
            tableSwitcher(scrollPane5);
        });
        label4.add(button10);
    }

    /**
     * Display the driver statistics when the user entered the specific driver name.
     */
    public static void searchDriver()
    {
        //search driver
        panel5 = new JPanel();
        panel5.setBounds(10, 10, 960, 420);
        panel5.setBackground(Color.BLACK);
        panel5.setLayout(null);
        layeredPane.add(panel5);
        panelSwitcher(panel5);

        label5 = new JLabel();
        label5.setBounds(20, 10, 920, 35);
        label5.setBackground(Color.RED);
        label5.setOpaque(true);

        label2 = new JLabel("Enter Drivers' Name: ");
        label2.setFont(font);
        label2.setForeground(Color.ORANGE);
        label2.setBackground(Color.black);
        label2.setOpaque(true);
        label2.setBounds(74, 7, 200, 25);
        label5.add(label2);

        textField1 = new JTextField(2);
        textField1.setFont(font);
        textField1.setBounds(345, 7, 260, 25);
        label5.add(textField1);

        button9 = new JButton("SEARCH");
        button9.setFont(font);
        button9.setBounds(675, 7, 200, 25);
        button9.setForeground(Color.ORANGE);
        button9.setBackground(Color.black);

        String[] column = {"Date", " Name ", " Location ", " Team ", " 1st ", " 2nd ", " 3rd ", " Points ", " Races "};
        jtModel3 = new DefaultTableModel(column, 0);  //creating the Default Table Model
        table3 = new JTable(jtModel3);

        button9.addActionListener(e -> {
            search();
            scrollPane3 = new JScrollPane(table3);
            scrollPane3.setBounds(20, 70, 920, 300);
            panel5.add(scrollPane3);
        });
        label5.add(button9);
    }

    /**
     * Using table row sorter it sorts by race.
     */
    public static void sortByRaces()
    {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
        table1.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int columnIndexToSort = 7;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    /**
     * Using table row sorter it sorts by position.
     */
    public static void sortByPosition()
    {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
        table1.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int columnIndexToSort = 3;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    /**
     *  Using table row sorter it sorts by points.
     */
    public static void sortByPoints()
    {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
        table1.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int columnIndexToSort = 6;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }


    public static void addRandomRaceProbability()
    {
        String date;
        int finish = 0;
        formula1ChampionshipManager.readInformationInFile();
        for (int i = 0; i < Formula1ChampionshipManager.formula1DriverList.size(); i++) {
            date = GenRandomDate();
            int numRandom = (int) (Math.random() * 10) + 1;
            String driverName = Formula1ChampionshipManager.formula1DriverList.get(i).getDriverName();
            String teamName = Formula1ChampionshipManager.formula1DriverList.get(i).getTeamNames();
            //check winning possibility according to the percentages
            if (numRandom ==1 || numRandom ==2) { //40 out of 100 chance
                finish = 1;
            }else if(numRandom == 3) {//30 out of 100 chance
                finish = 2;
            }else if(numRandom == 4 ) {//10 out of 100 chance
                finish = 2;
            }else if(numRandom == 5) {//10 out of 100 chance
                finish = 3;
            }else if(numRandom == 6){//2 out of 100 chance
                finish = 4;
            }else if(numRandom == 7){//2 out of 100 chance
                finish = 4;
            }else if(numRandom == 8){//2 out of 100 chance
                finish = 4;
            }else if(numRandom == 9){//2 out of 100 chance
                finish = 4;
            }else if(numRandom == 10){//2 out of 100 chance
                finish = 5;
            }

            Object[] dataColumn = {date, driverName, teamName, numRandom , finish};
            jtModel4.addRow(dataColumn);
        }
    }

    public static void raceLogDates()
    {
        String date;
        formula1ChampionshipManager.readInformationInFile();
        for (int i = 0; i < Formula1ChampionshipManager.formula1DriverList.size(); i++) {
            date = GenRandomDate();

            String driverName = Formula1ChampionshipManager.formula1DriverList.get(i).getDriverName();
            String location = Formula1ChampionshipManager.formula1DriverList.get(i).getDriverLocation();
            String teamName = Formula1ChampionshipManager.formula1DriverList.get(i).getTeamNames();
            int firstPosi = Formula1ChampionshipManager.formula1DriverList.get(i).getFirstPosition();
            int secondPosi = Formula1ChampionshipManager.formula1DriverList.get(i).getSecondPosition();
            int thirdPosi = Formula1ChampionshipManager.formula1DriverList.get(i).getThirdPosition();
            int numOfPoints = Formula1ChampionshipManager.formula1DriverList.get(i).getNumberOfPoints();
            int numOfRaces = Formula1ChampionshipManager.formula1DriverList.get(i).getNumberOfRaces();

            Object[] dataColumn = {date, driverName, location, teamName, firstPosi, secondPosi, thirdPosi, numOfPoints, numOfRaces};
            jtModel5.addRow(dataColumn);

            TableRowSorter<TableModel> sorter = new TableRowSorter<>(table5.getModel());
            table5.setRowSorter(sorter);
            List<RowSorter.SortKey> sortKeys = new ArrayList<>();

            int columnIndexToSort = 0;
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

            sorter.setSortKeys(sortKeys);
            sorter.sort();
        }
    }

    public static void addRandomRace()
    {
        String date = null;
        String first = null;
        String second = null;
        String third = null;
        String fourth = null;
        String fifth = null;
        String sixth = null;
        String seventh = null;
        String eight = null;
        String ninth = null;
        String tenth = null;

        for (Formula1Driver driver : Formula1ChampionshipManager.formula1DriverList) {
            date = GenRandomDate();

            int numRandom = (int) (Math.random() * 10) + 1;
            switch (numRandom) {
                case 1 -> first = driver.getDriverName();
                case 2 -> second = driver.getDriverName();
                case 3 -> third = driver.getDriverName();
                case 4 -> fourth = driver.getDriverName();
                case 5 -> fifth = driver.getDriverName();
                case 6 -> sixth = driver.getDriverName();
                case 7 -> seventh = driver.getDriverName();
                case 8 -> eight = driver.getDriverName();
                case 9 -> ninth = driver.getDriverName();
                case 10 -> tenth = driver.getDriverName();
            }
        }
        Object[] dataColumn = {date, first, second, third, fourth, fifth, sixth, seventh, eight, ninth, tenth};
        jtModel2.addRow(dataColumn);
    }

    /**
     * create a method to call random date generator
     */
    public static String GenRandomDate()
    {
        Random random = new Random();
        int minDay = (int) LocalDate.of(2020, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2021, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate localDate = LocalDate.ofEpochDay(randomDay);
        return localDate.toString();
    }

    public static void search()
    {
        String date;
        formula1ChampionshipManager.readInformationInFile();
        for (int i = 0; i < Formula1ChampionshipManager.formula1DriverList.size(); i++) {
            if(Formula1ChampionshipManager.formula1DriverList.get(i).getDriverName().equals(textField1.getText())) {
                date = GenRandomDate();
                String driverName = Formula1ChampionshipManager.formula1DriverList.get(i).getDriverName();
                String location = Formula1ChampionshipManager.formula1DriverList.get(i).getDriverLocation();
                String teamName = Formula1ChampionshipManager.formula1DriverList.get(i).getTeamNames();
                int firstPosi = Formula1ChampionshipManager.formula1DriverList.get(i).getFirstPosition();
                int secondPosi = Formula1ChampionshipManager.formula1DriverList.get(i).getSecondPosition();
                int thirdPosi = Formula1ChampionshipManager.formula1DriverList.get(i).getThirdPosition();
                int numOfPoints = Formula1ChampionshipManager.formula1DriverList.get(i).getNumberOfPoints();
                int numOfRaces = Formula1ChampionshipManager.formula1DriverList.get(i).getNumberOfRaces();

                Object[] dataColumn = {date, driverName, location, teamName, firstPosi, secondPosi, thirdPosi, numOfPoints, numOfRaces};
                jtModel3.addRow(dataColumn);
            } else {
                String b = "Enter correct name";
                textField1.setText(b);
                textField1.repaint();
            }
        }
    }

    /**
     *  Using table row sorter it sorts by points.
     */
    public static void panelSwitcher(JPanel panel)
    {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    /**
     *  Using table row sorter it sorts by points.
     */
    public static void tableSwitcher(JScrollPane scrollPane)
    {
        layeredPane1.removeAll();
        layeredPane1.add(scrollPane);
        layeredPane1.repaint();
        layeredPane1.revalidate();
    }

/**
 * Referred sites:
 * @https://www.youtube.com/watch?v=dPaUazOJOBc&list=PLsyeobzWxl7pVZdyDXj0arOdTzo4MYekh
 * @https://www.javatpoint.com/java-jpanel
 * @https://stackoverflow.com/questions/27459783/using-jlayeredpane-to-add-multiple-jpanels-to-a-jpanel
 * @https://www.youtube.com/watch?v=CQMpXGwHeYQ
 * @https://www.javatpoint.com/java-jtable
 * @https://stackoverflow.com/questions/26762324/swing-how-to-close-jpanel-programmatically
 * @https://stackoverflow.com/questions/31516531/how-to-print-string-on-jtextfield
 * @https://stackoverflow.com/questions/18027833/adding-image-to-jframe
 * @https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
 */
}