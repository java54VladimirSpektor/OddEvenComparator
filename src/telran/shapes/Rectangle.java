package telran.shapes;

public class Rectangle extends Shape {
	int wigth;
	int height;
	public Rectangle(long id) {
		super(id);
		this.height=height;
		this.wigth=wigth;
	}
	@Override
	public int square() {
		
		return wigth*height;
	}

	@Override
	public int perimeter() {
		
		return 2*(wigth+height);
	}
	public int getWigth() {
		return wigth;
	}
	public void setWigth(int wigth) {
		this.wigth = wigth;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

}
