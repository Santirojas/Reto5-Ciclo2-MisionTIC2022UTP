package co.edu.utp.misiontic2022.santiagorojas.view;

import java.util.List;

import co.edu.utp.misiontic2022.santiagorojas.controller.ReportesController;
import co.edu.utp.misiontic2022.santiagorojas.model.vo.ListaLideresVo;
import co.edu.utp.misiontic2022.santiagorojas.model.vo.ComprasPorProyectoVo;
import co.edu.utp.misiontic2022.santiagorojas.model.vo.ProyectosCasaCampestreVo;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReportesView extends JFrame implements ActionListener {
    public static ReportesController controller;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem inf1,inf2,inf3;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTitulo,lblConsulta;
         
            
    public ReportesView(){
        controller=new ReportesController();
        menu();
        etiqueta1();
        etiqueta2();
        tabla();
    }
    public void tabla(){
        tabla=new JTable();
        tabla.setPreferredScrollableViewportSize(new Dimension(500,200));
        JScrollPane pane=new JScrollPane(tabla);
        add(pane);
    }
    public void etiqueta1(){
        lblTitulo=new JLabel("INFORME RETO 5");
        lblTitulo.setPreferredSize(new Dimension(500,30));
        lblTitulo.setFont(new Font("Arial",Font.BOLD,20));
        add(lblTitulo);
        
        
    }
    public void etiqueta2(){
       lblConsulta=new JLabel ();
        lblConsulta.setPreferredSize(new Dimension(500,30));
       lblConsulta.setFont(new Font("Arial",Font.BOLD,14));
       add(lblConsulta);
    }
    
public void menu(){
    menuBar=new JMenuBar();
    setJMenuBar(menuBar);
    menu=new JMenu("INFORMES");
    menuBar.add(menu);
    inf1=new JMenuItem("Primer Informe");
    inf2=new JMenuItem("Segundo Informe");
    inf3=new JMenuItem("Tercer Informe");
    menu.add(inf1);
    menu.add(inf2);
    menu.add(inf3);
    inf1.addActionListener(this);
    inf2.addActionListener(this);
    inf3.addActionListener(this);
}



    public void segundoInforme() {
           try{
                List<ProyectosCasaCampestreVo> proyectos = controller.listarProyectos();
            modelo=new DefaultTableModel();
            modelo.addColumn("Id Proyecto");
            modelo.addColumn("Constructora");
            modelo.addColumn("Habitaciones");
            modelo.addColumn("Ciudad");
            for (ProyectosCasaCampestreVo proyecto : proyectos) {
                Object[] fila=new Object[4];
                fila[0]=proyecto.getId();
                fila[1]=proyecto.getConstructora();
                fila[2]=proyecto.getHabitaciones();
                fila[3]=proyecto.getCiudad();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
                
                }   
                
                
            catch(Exception e){
                System.out.println("Error: "+e.getMessage());

            }
        
    }

    public void tercerInforme( ) {
       try{
                List<ComprasPorProyectoVo> compras=controller.listarCompras();
            modelo=new DefaultTableModel();
            modelo.addColumn("Id Compra");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco");
         
            for (ComprasPorProyectoVo compra : compras) {
                Object[] fila=new Object[4];
                fila[0]=compra.getId();
                fila[1]=compra.getConstructora();
                fila[2]=compra.getBanco();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
            }
            catch(Exception e) {
                System.out.println("Error: " + e.getMessage());

            }
    
    }
    public void primerInforme() {
       try {
            List<ListaLideresVo> lideres = controller.listarLideres();
            modelo=new DefaultTableModel();
            modelo.addColumn("Id Lider");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");
            for (ListaLideresVo lider : lideres) {
                Object[] fila=new Object[4];
                fila[0]=lider.getId();
                fila[1]=lider.getNombre();
                fila[2]=lider.getApellido();
                fila[3]=lider.getCiudad();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==inf1){
        primerInforme();
        lblConsulta.setText("Informe de líderes"); 
    }
    if(e.getSource()==inf2){
        segundoInforme();
        lblConsulta.setText("Informe de Proyectos Campestres "); 
    }
    if(e.getSource()==inf3){
        tercerInforme();
        lblConsulta.setText("Informe de Compras por Proyecto "); 
}
    }
}
