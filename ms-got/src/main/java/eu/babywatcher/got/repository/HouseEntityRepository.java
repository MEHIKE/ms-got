package eu.babywatcher.got.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import eu.babywatcher.got.entity.HouseEntity;


public interface HouseEntityRepository extends JpaRepository<HouseEntity, Long> {

	@Transactional(readOnly = true)
	@Query("select e from HouseEntity e")
	Stream<HouseEntity> streamAll();

	@Transactional(readOnly = true)
	boolean existsByName(String name);
	
}