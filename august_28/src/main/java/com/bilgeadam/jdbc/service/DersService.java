package com.bilgeadam.jdbc.service;

import java.sql.SQLException;

import com.bilgeadam.jdbc.model.Ders;
import com.bilgeadam.jdbc.model.DersDTO;
import com.bilgeadam.jdbc.model.Konu;
import com.bilgeadam.jdbc.model.Ogretmen;
import com.bilgeadam.jdbc.repository.DersRepository;
import com.bilgeadam.jdbc.repository.KonuRepository;

public class DersService {
	private DersRepository dersRepository = new DersRepository();
	private KonuRepository konuRepository = new KonuRepository();
	// dependency injection olabilir ama jakartada görcez
	private DersRepository ogretmenRepository = new DersRepository();

	public DersDTO getDersDTOById(long id) {
		DersDTO dersDTO = null;
		try {
			Ders ders = dersRepository.selectById(id);
			if (ders == null) {
				return null;
			}
			Konu konu = konuRepository.selectById(ders.getKONU_ID());
			Ogretmen ogretmen = ogretmenRepository.selectById(ders.getOGR_ID());
			dersDTO = new DersDTO(ogretmen, konu);
		} catch (SQLException e) {
			return null;
		} catch (Exception e) {
			throw e;
		}
		return dersDTO;
	}

	public Ders selectById(long id) throws SQLException {
		return dersRepository.selectById(id);
	}
}
