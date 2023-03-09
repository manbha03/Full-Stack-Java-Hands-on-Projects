package simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import simplilearn.model.Kitchen;
import simplilearn.service.KitchenService;

@RestController
@CrossOrigin("http://localhost:4200")
public class KitchenController {

	@Autowired private KitchenService kitchenService;
	
	@RequestMapping(value = "/menu")
	public List<Kitchen> getMenu(){
		List<Kitchen> menuItems = kitchenService.getFoodItems();
		return menuItems;
	}
	
}
