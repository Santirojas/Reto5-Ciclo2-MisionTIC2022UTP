package co.edu.utp.misiontic2022.santiagorojas.model.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.santiagorojas.model.vo.ListaLideresVo;
import co.edu.utp.misiontic2022.santiagorojas.util.JDBCUtilities;

public class ListaLideresDao {
    public List<ListaLideresVo> listar() throws SQLException{
        ArrayList<ListaLideresVo> respuesta=new ArrayList<ListaLideresVo>();
        
        Connection conn=JDBCUtilities.getConnection();
        Statement stmt=null;
        ResultSet rset=null;
        String consulta="select ID_Lider as id,Nombre,Primer_Apellido as apellido,Ciudad_Residencia as ciudad from lider order by Ciudad_Residencia asc;";
        try{
            stmt=conn.createStatement();
            rset=stmt.executeQuery(consulta);
            while(rset.next()){
                ListaLideresVo vo=new ListaLideresVo();
                vo.setId(rset.getInt("id"));
                vo.setNombre(rset.getString("nombre"));
                vo.setApellido(rset.getString("apellido"));
                vo.setCiudad(rset.getString("ciudad"));
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
