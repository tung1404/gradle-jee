package vn.tungnt.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tungnt.jpa.domain.Actor;
import vn.tungnt.service.repositories.ActorRepository;

@Service
@Transactional
public class ActorService {
	
	private static final Logger logger = LoggerFactory.getLogger(ActorService.class);
	
	@Autowired
	private ActorRepository actorRepository;

	public Collection<Actor> getActors() {
		return actorRepository.findAll();
	}
	
	public Actor getActor(Integer id) {
		return actorRepository.findOne(id);
	}
	
	public Actor addUser(Actor actor) {
		return actorRepository.save(actor);
	}

	@Transactional(rollbackFor = { ServiceException.class })
	public void updateActor(Actor actor) throws Exception {
		try {
			actorRepository.save(actor);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new ServiceException("Update has error", e);
		}
	}
}
