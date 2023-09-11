package com.bilgeadam.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bilgeadam.jdbc.model.DersOgrenci;

import august_28.DBConstants;

public class DersOgrenciRepository {

	public DersOgrenci selectById(long id) throws SQLException {
		Connection c = DBConstants.DBConnection();
		String sql = "SELECT * FROM \"DERS_OGRENCI\" WHERE \"ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet result = stmt.executeQuery();
		DersOgrenci dersOgrenci = null;
		while (result.next()) {
			long dersId = result.getLong("DERS_ID");
			long ogrId = result.getLong("OGR_ID");
			int devamsizlik = result.getInt("DEVAMSIZLIK");
			int note = result.getInt("NOTE");
			dersOgrenci = new DersOgrenci(id, dersId, ogrId, devamsizlik, note);
		}
		stmt.close();
		c.close();
		return dersOgrenci;
	}
}
