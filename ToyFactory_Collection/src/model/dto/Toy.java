package model.dto;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Toy {
	private String toyName;
	private int age;
	private int price;
	private String color;
	private int date;
	private Set<String> ingredient;
	
	
	public Toy() {}

	public Toy(String toyName, int age, int price, String color, int date, Set<String> ingredient) {
		super();
		this.toyName = toyName;
		this.age = age;
		this.price = price;
		this.color = color;
		this.date = date;
		this.ingredient = ingredient;
	}

	public String getToyName() {
		return toyName;
	}

	public void setToyName(String toyName) {
		this.toyName = toyName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Set<String> getIngredient() {
		return ingredient;
	}

	public void setIngredient(Set<String> ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, color, date, ingredient, price, toyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		return age == other.age && Objects.equals(color, other.color) && date == other.date
				&& Objects.equals(ingredient, other.ingredient) && price == other.price
				&& Objects.equals(toyName, other.toyName);
	}

	@Override
	public String toString() {
		return String.format("이름 : %s / 가격 : %d / 색상 : %s / 사용가능연령 : %d / 제조년월일 : %s / 재료 : %s", toyName, price, color, age, date, getIngredients());
	}

	private String getIngredients() {
		return String.join(", ", ingredient);
	}
}
