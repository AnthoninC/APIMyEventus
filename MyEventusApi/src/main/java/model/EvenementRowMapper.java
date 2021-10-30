package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EvenementRowMapper implements RowMapper<Evenement> {
	
	@Override
    public Evenement mapRow(ResultSet rs, int rowNum) throws SQLException {
		Evenement event = new Evenement();

        event.setUid(rs.getInt("uid"));
        event.setTitre(rs.getString("titre"));
        //employee.setFirstName(rs.getString("FIRST_NAME"));
        //employee.setLastName(rs.getString("LAST_NAME"));
        //employee.setAddress(rs.getString("ADDRESS"));

        return event;
    }
}
