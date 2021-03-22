package topi.fullstackdev.javaproject.Meal;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MealController {

	MealService mealService = new MealService();

	@GetMapping("/")
	public ModelAndView getMealListing(@RequestParam(value = "search", required = false) String queryString, Model model) {
		model.addAttribute("meals",
				queryString == null ? mealService.getMealListing() : mealService.getMealListing(queryString));
		return new ModelAndView("index", "", model);
	}
}
