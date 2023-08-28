package com.bilgeadam.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bilgeadam.jdbc.model.Konu;

import august_28.DBConstants;

public class KonuRepository {
	public LinkedList<Konu> selectAll() throws SQLException {
		Connection c = DBConstants.getConnection();
		Statement stmnt = c.createStatement();
		ResultSet result = stmnt.executeQuery("select * from \"KONU\" order by \"ID\" asc");
		LinkedList<Konu> konular = new LinkedList<>();
		while (result.next()) {
			// result set satılar kümesidir
			long id = result.getLong("ID");
			String name = result.getString("NAME");
			Konu k = new Konu(id, name);
			konular.add(k);
		}
		result.close();
		stmnt.close();
		c.close();
		return konular;
	}

	public boolean insert(String name) throws SQLException {
		boolean isInserted = false;
		Connection c = DBConstants.getConnection();
		String sql = "INSERT INTO \"OBS\".\"KONU\" (\"NAME\") VALUES (?)";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, name);
		isInserted = stmt.executeUpdate() == 1;
		stmt.close();
		c.close();
		return isInserted;
	}

	public static boolean deletebyId(long id) {
		boolean isDeleted = false;
		try {
			Connection c = DBConstants.getConnection();
			String sql = "";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setLong(1, id);
			isDeleted = true;
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}
}