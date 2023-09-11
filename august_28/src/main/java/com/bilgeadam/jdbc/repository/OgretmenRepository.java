package com.bilgeadam.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bilgeadam.jdbc.model.Ogretmen;

import august_28.DBConstants;

public class OgretmenRepository {

	public boolean insert(String name, boolean isGicik) throws SQLException {
		boolean isInserted = false;
		Connection c = DBConstants.DBConnection();
		String sql = "INSERT INTO \"OGRETMEN\" (\"NAME\", \"IS_GICIK\") VALUES (?, CAST(? AS bit))";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setObject(2, isGicik ? 1 : 0);
		isInserted = stmt.executeUpdate() == 1;
		stmt.close();
		c.close();
		return isInserted;
	}

	public Ogretmen getById(long id) throws SQLException {
		Connection c = DBConstants.DBConnection();
		String sql = "";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet result = stmt.executeQuery();
		Ogretmen ogretmen = null;
		while (result.next()) {
			if (id != result.getLong("ID"))
				continue;
			// long id = result.getLong("ID");
			String name = result.getString("NAME");
			boolean isGicik = result.getBoolean("IS_GICIK");
			ogretmen = new Ogretmen(id, name, isGicik);
		}
		stmt.close();
		c.close();
		return ogretmen;
	}

	public Ogretmen selectById(long id) throws SQLException {
		Connection c = DBConstants.DBConnection();
		String sql = "SELECT * FROM \"OGRETMEN\" WHERE \"ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet result = stmt.executeQuery();
		Ogretmen ogretmen = null;
		while (result.next()) {
			long ogr_id = result.getLong("ID");
			String name = result.getString("Name");
			boolean isGicik = result.getBoolean("IS_GICIK");
			ogretmen = new Ogretmen(ogr_id, name, isGicik);
		}
		stmt.close();
		c.close();
		return ogretmen;
	}
}
