package main;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.FilmDaoI;
import model.Film;
import service.FilmServiceI;
import service.impl.FilmServiceImpl;

public class AddFilm {

	@Autowired
	private static FilmServiceI filmService;
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		ac.start();
		filmService = ac.getBean("filmService",FilmServiceI.class);
		Film film = ac.getBean("film",Film.class);
		System.out.println("请输入电影名称(title)：");
		Scanner sc = new Scanner(System.in);
		film.setTitle(sc.nextLine());
		System.out.println("请输入电影描述(description)：");
		film.setDescription(sc.nextLine());
		System.out.println("请输入语言ID(language_id)：");
		film.setLanguage_id(sc.nextInt());
		try {
			filmService.save(film);
			//filmService.save(film);
		} catch (SQLException e) {
			System.out.println("==========添加电影失败！");
			e.printStackTrace();
		}
		ac.stop();
	}
}