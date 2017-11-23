package geco;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class PasswordGenerationTest {

	private PasswordGeneration pg = new PasswordGeneration();

	@Test
	public void getRandomPasswordNotNull() throws Exception {
		String pass = pg.getRandomPassword();
		assertThat(pass, is(notNullValue()));
	}

	@Test
	public void getRandomPasswordNotEmpty() throws Exception {
		String pass = pg.getRandomPassword();
		assertThat(pass, is(not("")));
	}

	@Test
	public void getRandomPassword8() throws Exception {
		int taille = (pg.getRandomPassword()).length();
		assertThat(taille, is(8));
	}

}