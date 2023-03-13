package com.example.clotheswarehouse;

import com.example.clotheswarehouse.models.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.clotheswarehouse.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.clotheswarehouse.repositories")
public class ClothesWarehouseApplication implements CommandLineRunner {

	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(ClothesWarehouseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Item item1 = new Item("Hoodie", Brand.STONE_ISLAND, 2021, 120.0);
		Item item2 = new Item("Sneakers", Brand.BALENCIAGA, 2022, 650.0);
		Item item3 = new Item("T-Shirt", Brand.DIOR, 2020, 250.0);

		itemRepository.save(item1);
		itemRepository.save(item2);
		itemRepository.save(item3);
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Item {
		private String name;
		private Brand brand;
		private int year;
		private double price;

		@Override
		public String toString() {
			return "Item{" +
					"name='" + name + '\'' +
					", brand=" + brand +
					", year=" + year +
					", price=" + price +
					'}';
		}
	}
}
