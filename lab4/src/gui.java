import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui extends JFrame{
    private JPanel JPane;
    private JTextField kursinput;
    private JTextField cenainput;
    private JButton opłacKursButton;
    private JButton wyjscieButton;
    private JTree tree1;

    public static void main(String[] args) {
        gui checkboxAppInstance = new gui();
        checkboxAppInstance.setVisible(true);
    }

    public gui(){
        super("rzycie");
        this.setContentPane(JPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        tree1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree1.getSelectionPath().getLastPathComponent();

                String nazwaKursu = root.getUserObject().toString();

                kursinput.setText(nazwaKursu);

                if(nazwaKursu == "C++") cenainput.setText("2137");
                if(nazwaKursu == "C#") cenainput.setText("2138");
                if(nazwaKursu == "JAVA") cenainput.setText("222");
                if(nazwaKursu == "Python") cenainput.setText("2137");
                if(nazwaKursu == "Adobe Photoshop") cenainput.setText("27");
                if(nazwaKursu == "ColerDRAN") cenainput.setText("21");
                if(nazwaKursu == "Adobe InDesign") cenainput.setText("37");
                if(nazwaKursu == "AutoCAD") cenainput.setText("dupa");

            }
        });
    }

    private void createUIComponents() {
        //root
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Moje kursy");

        //1st level
        DefaultMutableTreeNode KProgramowanie =  new DefaultMutableTreeNode("Programowanie");

        DefaultMutableTreeNode PK1 = new DefaultMutableTreeNode("C++");
        DefaultMutableTreeNode PK2 = new DefaultMutableTreeNode("C#");
        DefaultMutableTreeNode PK3 = new DefaultMutableTreeNode("JAVA");
        DefaultMutableTreeNode PK4 = new DefaultMutableTreeNode("Python");

        KProgramowanie.add(PK1);
        KProgramowanie.add(PK2);
        KProgramowanie.add(PK3);
        KProgramowanie.add(PK4);

        //2nd level
        DefaultMutableTreeNode PGrafika =  new DefaultMutableTreeNode("Grafika komputerowa");

        DefaultMutableTreeNode PP1 = new DefaultMutableTreeNode("Adobe Photoshop");
        DefaultMutableTreeNode PP2 = new DefaultMutableTreeNode("ColerDRAN");
        DefaultMutableTreeNode PP3 = new DefaultMutableTreeNode("Adobe InDesign");
        DefaultMutableTreeNode PP4 = new DefaultMutableTreeNode("AutoCAD");

        PGrafika.add(PP1);
        PGrafika.add(PP2);
        PGrafika.add(PP3);
        PGrafika.add(PP4);

        //add to root
        root.add(KProgramowanie);
        root.add(PGrafika);

        DefaultTreeModel myModel = new DefaultTreeModel(root);

        tree1 = new JTree(myModel);
    }
}
