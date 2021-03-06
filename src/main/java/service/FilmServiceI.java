package service;

import java.sql.SQLException;
import java.util.List;

import model.Film;

public interface FilmServiceI{
	
	public List<Film> getPageResult() throws SQLException;
	public Film queryById(int id) throws SQLException;
	public boolean save(Film film) throws SQLException;
	public boolean delete(int id) throws SQLException;
	public boolean update(Film film) throws SQLException;
}