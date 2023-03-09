package simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simplilearn.model.Kitchen;
import simplilearn.repository.KitchenRepository;

@Service
public class KitchenService {

	@Autowired private KitchenRepository kitchenRepository;
	
	public List<Kitchen> getFoodItems(){
		List<Kitchen> foodItem = kitchenRepository.findAll();
		return foodItem;
	}
	
	public Kitchen validateFoodInfo(int id) {
		Kitchen getFoodById = kitchenRepository.findById(id).get();
		return getFoodById;
	}
}
