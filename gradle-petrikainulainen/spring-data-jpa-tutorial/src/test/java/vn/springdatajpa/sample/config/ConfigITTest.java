package vn.springdatajpa.sample.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import vn.springdatajpa.sample.entities.Actor;
import vn.springdatajpa.sample.repositories.ActorRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceContext.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:actor-entries.xml")
@TestPropertySource(properties = {"spring.profiles.active=test"})
public class ConfigITTest {
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Test
    public void findAll_ShouldReturnOneEntry() {
        List<Actor> searchResults = actorRepository.findAll();
        assertThat(searchResults).hasSize(1);
    }
}