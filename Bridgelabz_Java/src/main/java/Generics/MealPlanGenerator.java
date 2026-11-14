
package Generics;

/*
 * Problem: Personalized Meal Plan Generator
 *
 * Design a meal plan generator that supports Vegetarian,
 * Vegan, Keto, and High-Protein meal categories.
 *
 * Use a generic interface and a generic Meal class.
 * Implement a bounded generic method to generate
 * valid personalized meal plans.
 */

public class MealPlanGenerator {

    // Common interface for meal plans
    interface MealPlan {
        String getPlanName();

        String getMealDetails();
    }

    // Vegetarian meal plan
    static class VegetarianMeal implements MealPlan {
        public String getPlanName() {
            return "Vegetarian";
        }

        public String getMealDetails() {
            return "Rice, Dal, Paneer and Salad";
        }
    }

    // Vegan meal plan
    static class VeganMeal implements MealPlan {
        public String getPlanName() {
            return "Vegan";
        }

        public String getMealDetails() {
            return "Brown Rice, Tofu and Vegetables";
        }
    }

    // Keto meal plan
    static class KetoMeal implements MealPlan {
        public String getPlanName() {
            return "Keto";
        }

        public String getMealDetails() {
            return "Eggs, Avocado and Low-Carb Vegetables";
        }
    }

    // High-protein meal plan
    static class HighProteinMeal implements MealPlan {
        public String getPlanName() {
            return "High-Protein";
        }

        public String getMealDetails() {
            return "Paneer, Lentils and Greek Yogurt";
        }
    }

    // Generic Meal class
    static class Meal<T extends MealPlan> {
        T plan;

        Meal(T plan) {
            this.plan = plan;
        }

        void displayMeal() {
            System.out.println("Meal Category: "
                    + plan.getPlanName());

            System.out.println("Meal Details: "
                    + plan.getMealDetails());
        }
    }

    // Generic method to generate a meal plan
    static <T extends MealPlan> Meal<T> generateMealPlan(T plan) {

        if (plan == null) {
            System.out.println("Invalid meal plan!");
            return null;
        }

        System.out.println("Meal plan generated successfully!");

        return new Meal<>(plan);
    }

    public static void main(String[] args) {

        // Generate different personalized meal plans
        Meal<VegetarianMeal> vegetarian =
                generateMealPlan(new VegetarianMeal());

        Meal<VeganMeal> vegan =
                generateMealPlan(new VeganMeal());

        Meal<KetoMeal> keto =
                generateMealPlan(new KetoMeal());

        Meal<HighProteinMeal> highProtein =
                generateMealPlan(new HighProteinMeal());

        System.out.println("\n--- Personalized Meal Plans ---");

        vegetarian.displayMeal();
        System.out.println();

        vegan.displayMeal();
        System.out.println();

        keto.displayMeal();
        System.out.println();

        highProtein.displayMeal();
    }
}
