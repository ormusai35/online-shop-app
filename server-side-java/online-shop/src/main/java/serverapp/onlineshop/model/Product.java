package serverapp.onlineshop.model;

public class Product implements Comparable<Product>{

	private long id;
	private String description;
	private double price;
	private String category;
	private String imageUrl;

	public Product(long id, String description, double price, String category, String imageUrl) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.category = category;
		this.imageUrl = imageUrl;
	}
	
	public Product(Product other) {
		this.id = other.id;
		this.description = other.description;
		this.price = other.price;
		this.category = other.category;
		this.imageUrl = other.imageUrl;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int compareTo(Product prod) {
		if (this.category.compareTo(prod.category) == 0 &&
				this.description.compareTo(prod.description) == 0 &&
				this.price == prod.price)
			return 0;
		else return -1;
	}
} 
