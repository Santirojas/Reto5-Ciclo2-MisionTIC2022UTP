package co.edu.utp.misiontic2022.santiagorojas.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.santiagorojas.model.vo.ComprasPorProyectoVo;
import co.edu.utp.misiontic2022.santiagorojas.util.JDBCUtilities;
import java.sql.Statement;

public class ComprasPorProyectoDao {
    public List<ComprasPorProyectoVo> listar( ) throws SQLException{
        ArrayList<ComprasPorProyectoVo> respuesta=new ArrayList<ComprasPorProyectoVo>();
        
        Connection conn=JDBCUtilities.getConnection();
        Statement stmt=null;
        ResultSet rset=null;
        String consulta="select c.id_compra as id, p.constructora, p.banco_vinculado as banco from proyecto p left join compra c on c.ID_Proyecto =p.id_proyecto where proveedor='Homecenter' and p.ciudad='Salento';";
        try{
            stmt=conn.createStatement();
            rset=stmt.executeQuery(consulta);
            while(rset.next()){
                ComprasPorProyectoVo vo=new ComprasPorProyectoVo();
                vo.setId(rset.getInt("id"));
                vo.setConstructora(rset.getString("constructora"));
                vo.setBanco(rset.getString("banco"));
                respuesta.add(vo);
            }
            
        }
        finally{
            if(rset!=null){
                rset.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
        return respuesta;

    }
    
}
