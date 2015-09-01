import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Film;
import service.FilmServiceI;

public class test {
	
	@Test
	public void testAOP(){
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
		FilmServiceI filmProxy = ac.getBean("filmProxy",FilmServiceI.class);
		try {
			filmProxy.save(film);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ac.stop();
		sc.close();
		ac.close();
	}
}