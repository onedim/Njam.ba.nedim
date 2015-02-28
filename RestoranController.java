import java.nio.file.WatchEvent.Modifier;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
	
	
public class RestoranController  extends Controller{

	static Form<Meal> createForm = new Form<Meal>(Meal.class);
	static Form<Meal> ModifyForm = new Form<Meal>(Meal.class);
	static Form<Meal> DeleteForm = new Form<Meal>(Meal.class);
	
	
	
	// The meal model needs a createMeal function that will return false for a failed attempt to create a meal and true for a successful creation. The create function accepts three parameters Name (string), Description (string) and Price (double), while the ID is created in the function
	public static Result createMeal() {
	String MealName = createForm.bindFromRequest().get().MealName;
	String MealDescription = createForm.bindFromRequest().get().MealDescription;
	double MealPrice = Double.parseDouble(createForm.bindFromRequest().get().MealPrice); // The meal model needs to have 4 parameters: Id (int), Name (string), Desrption (string), Price (double)
	if(Meal.createMeal(MealName,MealDescription,MealPrice) == true){
	return TODO; /*Go to new Meal panel */
	}
	//else return to fail to create panel.
	return null;
	} 
	
	// The meal model needs a DeleteMeal function that will return false for a failed attempt to delete a meal and true for a successful deletion. The deletion is done using the ID as a parameter
	public static Result DeleteMeal(){
	String MealID = DeleteForm.bindFromRequest().get().MealID;
	if(Meal.DeleteMeal(MealID) == true){
	return TODO; //redirect to Previous panel
	}
	return TODO; //Delete failed, return to fail panel.
	}
	}

// The meal model needs a ModifyMeal function that will return false for a failed attempt to modify a meal and true for a success. The modification is done using the ID as a parameter, and modifying the name,description and price
	public static Result ModifyMeal(){
	String MealID = ModifyForm.bindFromRequest().get().MealID;
	String MealName = Modifier.bindFromRequest().get().MealName;
	String MealDescription = ModifyForm.bindFromRequest().get().MealDescription;
	double MealPrice = Double.parseDouble(ModifyForm.bindFromRequest().get().MealPrice);
	if(Meal.ModifyMeal(MealID,MealName,MealDescription,MealPrice)) == true){
		return TODO; //redirect to Meal panel
	}
	return TODO; //Meal modification failed, return to fail panel.
	}
}


}
