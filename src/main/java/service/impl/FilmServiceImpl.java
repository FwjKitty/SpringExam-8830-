package service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.FilmDaoI;
import model.Film;
import service.FilmServiceI;

@Service("filmService")
public class FilmServiceImpl implements FilmServiceI {
	
	@Autowired
	private FilmDaoI filmDao;

	public List<Film> getPageResult() throws SQLException {
		List<Film> list = filmDao.getPageResult();
		return list;
	}

	public Film queryById(int id) throws SQLException {
		Film film = filmDao.queryById(id);
		return film;
	}

	public boolean save(Film film) throws SQLException {
		boolean flag = filmDao.save(film);
		return flag;
	}

	public boolean delete(int id) throws SQLException {
		boolean flag = filmDao.delete(id);
		return flag;
	}

	public boolean update(Film film) throws SQLException {
		boolean flag = filmDao.update(film);
		return flag;
	}
	
}