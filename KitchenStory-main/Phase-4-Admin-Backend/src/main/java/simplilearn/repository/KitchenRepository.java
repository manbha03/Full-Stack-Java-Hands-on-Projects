package simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simplilearn.model.Kitchen;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, Integer> {

}
