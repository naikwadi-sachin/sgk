package org.sgk.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

public class UserDaoTest {

	private EmbeddedDatabase database;

	@Before
	public void setUp() throws Exception {
		database = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
//		assertThat(database, is(notNullValue()));
	}

	@After
	public void tearDown() throws Exception {
		database.shutdown();
	}

	@Test
	public void shouldFindUserByUsername() {
		/*UserDao dao = new UserDao();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(database);
		dao.setJdbcTemplate(jdbcTemplate);
		User user = dao.findUserByUsername("shekhar");
		assertThat(user, is(notNullValue()));*/
	}
}
