package topi.fullstackdev.javaproject.Meal;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;

public class MealService {

	private final String MEALDB_API_URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=";
	private String queryString;

	/**
	 * Execute a GET request and return an ArrayList<Meal> with all the meals
	 * avaiable in the meal db.
	 */
	public ArrayList<Meal> getMealListing() {
		ArrayList<Meal> mealList = new ArrayList<Meal>();

		try {
			// Connect to the URL using java's native library
			String connectionUrl = MEALDB_API_URL;

			// Include query string if exists
			if (this.queryString != null)
				connectionUrl += this.queryString;

			// Open connection to URL
			URL url = new URL(connectionUrl);
			URLConnection request = url.openConnection();
			request.connect();

			// Read and parse the JSON response from the connection
			InputStreamReader reader = new InputStreamReader((InputStream) request.getContent());
			JsonElement requestJson = JsonParser.parseReader(reader);

			if (!requestJson.isJsonNull()) {
				JsonElement mealsElement = requestJson.getAsJsonObject().get("meals");

				if (!mealsElement.isJsonNull()) {
					JsonArray mealsArray = mealsElement.getAsJsonArray();

					// Insert all the data into the mealList
					for (int i = 0; i < mealsArray.size(); i++) {
						Meal meal = new Meal();
						meal.setName(mealsArray.get(i).getAsJsonObject().get("strMeal").getAsString());
						meal.setCategory(mealsArray.get(i).getAsJsonObject().get("strCategory").getAsString());
						meal.setArea(mealsArray.get(i).getAsJsonObject().get("strArea").getAsString());
						meal.setInstructions(mealsArray.get(i).getAsJsonObject().get("strInstructions").getAsString());
						meal.setThumbnail(mealsArray.get(i).getAsJsonObject().get("strMealThumb").getAsString());
						mealList.add(meal);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mealList;
	}

	/**
	 * Method overload with queryString param.
	 * 
	 * @param queryString meal name to search for in the meal database.
	 */
	public ArrayList<Meal> getMealListing(String queryString) {
		try {
			// Encodes queryString to avoid errors with spaces and symbols inside it
			this.queryString = URLEncoder.encode(queryString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return getMealListing();
	}
}
