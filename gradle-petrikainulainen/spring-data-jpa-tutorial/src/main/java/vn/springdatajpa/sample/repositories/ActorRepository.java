package vn.springdatajpa.sample.repositories;

import org.springframework.stereotype.Repository;

import vn.springdatajpa.sample.entities.Actor;

@Repository
public interface ActorRepository extends BaseRepository<Actor, Long> {

}
