package View;

import Modele.Connexion;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * @author gameu
 */
public class PieChartExample extends JFrame {

    private static final long serialVersionUID = 6294689542092367723L;

    public PieChartExample(String title, Admin adm) throws SQLException {
        super(title);
        PieDataset dataset = createDataset(adm);
        JFreeChart chart = ChartFactory.createPieChart("Statistiques selon le prix des commandes clients ", dataset, true, false, false);
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(" {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    public PieChartExample() {

    }

    private PieDataset createDataset(Admin adm) throws SQLException {

        DefaultPieDataset dataset = new DefaultPieDataset();

        Connexion conne = new Connexion();
        ArrayList<Float> stats = new ArrayList();

        int comp1 = 0;
        int comp2 = 0;
        int comp3 = 0;
        int comp4 = 0;

        final DefaultPieDataset pieDataset = new DefaultPieDataset();
        stats = conne.RechercherPrix();

        for (int i = 0; i < stats.size(); i++) {
            if (stats.get(i) <= 100) {
                comp1++;
            } else if (100 < stats.get(i) && stats.get(i) <= 300) {
                comp2++;
            } else if (300 < stats.get(i) && stats.get(i) <= 500) {
                comp3++;
            } else if (stats.get(i) >= 500) {
                comp4++;
            }
        }

        dataset.setValue("Moins de 100€  ", comp1);
        dataset.setValue("Entre 100€ et 300€  ", comp2);
        dataset.setValue("Entre 300€ et 500€  ", comp3);
        dataset.setValue("Plus de 500€  ", comp4);

        return dataset;
    }

    public void Plot(Admin adm) {

        SwingUtilities.invokeLater(() -> {
            PieChartExample example = null;
            try {
                example = new PieChartExample("Statistiques", adm);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            example.setSize(1200, 900);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            example.setVisible(true);
        });
        add(new JButton());
    }
}
