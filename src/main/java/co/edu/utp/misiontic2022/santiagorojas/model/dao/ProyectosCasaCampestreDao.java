package co.edu.utp.misiontic2022.santiagorojas.model.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.santiagorojas.model.vo.ProyectosCasaCampestreVo;
import co.edu.utp.misiontic2022.santiagorojas.util.JDBCUtilities;
import java.sql.Statement;

public class ProyectosCasaCampestreDao {

    public List<ProyectosCasaCampestreVo> listar( ) throws SQLException{
        ArrayList<ProyectosCasaCampestreVo> respuesta=new ArrayList<ProyectosCasaCampestreVo>();
        
        Connection conn=JDBCUtilities.getConnection();
        Statement stmt=null;
        ResultSet rset=null;
        String consulta="select id_proyecto as id, constructora, numero_habitaciones as habitaciones, ciudad from proyecto where clasificacion='Casa Campestre' and ciudad in('Santa Marta','Cartagena','Barranquilla');";
        try{
            stmt=conn.createStatement();
           
            rset=stmt.executeQuery(consulta);
            while(rset.next()){
                ProyectosCasaCampestreVo vo=new ProyectosCasaCampestreVo();
                vo.setId(rset.getInt("id"));
                vo.setConstructora(rset.getString("constructora"));
                vo.setHabitaciones(rset.getInt("habitaciones"));
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
