package geco;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LoginServiceTest {

	private String[] loginsExistants = {"Plouf", "blop", "R2D2", "yolo123", "yolo456"};
	private LoginService logs = new LoginService(loginsExistants);

	@Test
	public void loginExists() throws Exception {
		boolean isVide = logs.loginExists("Plouf");
		assertThat(isVide, is(true));

		isVide = logs.loginExists("R2D3");
		assertThat(isVide, is(false));
	}

	@Test
	public void addLogin() throws Exception {
		// On vérifie que l'élément qu'on va ajouter n'est pas déjà présent
		boolean isVide = logs.loginExists("BB8");
		assertThat(isVide, is(false));

		// On l'ajoute
		logs.addLogin("BB8");

		// O, vérifie que l'élément à été ajouté
		isVide = logs.loginExists("BB8");
		assertThat(isVide, is(true));
	}

	@Test
	public void findAllLoginsStartingWith() throws Exception {
		String[] loginsAttendus = {"yolo123", "yolo456"};

		List<String> loginsTrouves = logs.findAllLoginsStartingWith("yolo");
		assertThat(loginsTrouves, hasItems(loginsAttendus));
	}

	@Test
	public void findAllLogins() throws Exception {
		List<String> loginsTrouves = logs.findAllLogins();
		assertThat(loginsTrouves, hasItems(loginsExistants));
	}

}