package geco;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LoginGeneratorTest {

	private LoginService loginService;
	private LoginGenerator loginGen;

	@Before
	public void setUp() throws Exception {
		loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
		loginGen = new LoginGenerator(loginService);
	}

	@Test
	public void generateLoginForNomAndPrenom1() throws Exception {
		String login = loginGen.generateLoginForNomAndPrenom("Durand" , "Paul");
		assertThat(login, is("PDUR"));
	}

	@Test
	public void generateLoginForNomAndPrenomVerifIncr() throws Exception {
		String login = loginGen.generateLoginForNomAndPrenom("Ralling" , "John");
		assertThat(login, is("JRAL2"));
	}

	@Test
	public void generateLoginForNomAndPrenom2() throws Exception {
		String login = loginGen.generateLoginForNomAndPrenom("Rolling" , "Jean");
		assertThat(login, is("JROL1"));
	}

	@Test
	public void generateLoginForNomAndPrenom3() throws Exception {
		String login = loginGen.generateLoginForNomAndPrenom("Dùrand" , "Paul");
		assertThat(login, is("PDUR"));
	}

}