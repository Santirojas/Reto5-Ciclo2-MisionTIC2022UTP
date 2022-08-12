package co.edu.utp.misiontic2022.santiagorojas.controller;

import java.sql.SQLException;
import java.util.List;

import co.edu.utp.misiontic2022.santiagorojas.model.dao.ListaLideresDao;
import co.edu.utp.misiontic2022.santiagorojas.model.dao.ComprasPorProyectoDao;
import co.edu.utp.misiontic2022.santiagorojas.model.dao.ProyectosCasaCampestreDao;
import co.edu.utp.misiontic2022.santiagorojas.model.vo.ListaLideresVo;
import co.edu.utp.misiontic2022.santiagorojas.model.vo.ComprasPorProyectoVo;
import co.edu.utp.misiontic2022.santiagorojas.model.vo.ProyectosCasaCampestreVo;

public class ReportesController {
    private ListaLideresDao listaLideresDao;
    private ComprasPorProyectoDao comprasPorProyectoDao;
    private ProyectosCasaCampestreDao proyectosCasaCampestreDao;


    public ReportesController() {
        proyectosCasaCampestreDao=new ProyectosCasaCampestreDao();
        comprasPorProyectoDao=new ComprasPorProyectoDao();    
        listaLideresDao=new ListaLideresDao();  

    }

    public List<ProyectosCasaCampestreVo> listarProyectos( ) throws SQLException {
       return proyectosCasaCampestreDao.listar();
    }
    public List<ComprasPorProyectoVo> listarCompras( )throws SQLException {
        return comprasPorProyectoDao.listar();
    }
    public List<ListaLideresVo> listarLideres() throws SQLException {
        return listaLideresDao.listar();
    }
}
