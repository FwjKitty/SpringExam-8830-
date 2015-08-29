package main;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Film;
import service.FilmServiceI;
import service.impl.FilmServiceImpl;

public class AddFilm {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		ac.start();
		Film film = ac.getBean("film",Film.class);
		System.out.println("请输入电影名称(title)：");
		Scanner sc = new Scanner(System.in);
		film.setTitle(sc.nextLine());
		System.out.println("请输入电影描述(description)：");
		film.setDescription(sc.nextLine());
		System.out.println("请输入语言ID(language_id)：");
		film.setLanguage_id(sc.nextInt());
		//System.out.println("Before Insert Film Data");
		FilmServiceI filmService = ac.getBean("filmService",FilmServiceImpl.class);
		try {
			filmService.save(film);
		} catch (SQLException e) {
			System.out.println("==========添加电影失败！");
			e.printStackTrace();
		}
		//System.out.println("After Insert Film Data");
		ac.stop();
	}
}