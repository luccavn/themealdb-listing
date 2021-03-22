package topi.fullstackdev.javaproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import topi.fullstackdev.javaproject.Meal.MealController;
import topi.fullstackdev.javaproject.Meal.MealService;

@SpringBootTest
class JavaprojectApplicationTests {

	private MealController controller = new MealController();
	private MealService service = new MealService();

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(service).isNotNull();
	}

	/**
	 * Verifica se o retorno não é null, se é uma ArrayList e se possui pelo menos 1
	 * elemento retornado pela API.
	 */
	@Test
	void mealServiceHasValidReturn() {

		assertThat(service.getMealListing()).satisfies(mealList -> {
			assertThat(mealList).isNotNull();
			assertThat(mealList).isExactlyInstanceOf(ArrayList.class);
			assertThat(mealList).size().isGreaterThan(0);
		});
	}

}
