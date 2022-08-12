package co.edu.utp.misiontic2022.santiagorojas;

import co.edu.utp.misiontic2022.santiagorojas.view.ReportesView;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        var reportesView = new ReportesView();//Funciona
        reportesView.setLayout(new FlowLayout());
        reportesView.setSize(600,400);
        reportesView.setVisible(true);
        reportesView.setResizable(false);
        reportesView.setTitle("INFORMES RETO");
        reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportesView.setLocationRelativeTo(null);
    }
}
