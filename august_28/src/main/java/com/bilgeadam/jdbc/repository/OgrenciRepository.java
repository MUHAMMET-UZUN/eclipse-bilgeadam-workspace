package com.bilgeadam.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bilgeadam.jdbc.model.Ogrenci;

import august_28.DBConstants;

public class OgrenciRepository {

	public Ogrenci selectById(long id) throws SQLException {
		Connection c = DBConstants.DBConnection();
		String sql = "SELECT * FROM \"OGRENCI\" WHERE \"ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet result = stmt.executeQuery();
		Ogrenci ogrenci = null;
		while (result.next()) {
			String name = result.getString("Name");
			long ogrNumber = result.getLong("OGR_NUMBER");
			long year = result.getLong("YEAR");
			ogrenci = new Ogrenci(id, name, ogrNumber, year);
		}
		result.close();
		stmt.close();
		c.close();
		return ogrenci;
	}
}
