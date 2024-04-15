package telran.shapes;

import java.util.Iterator;
import java.util.NoSuchElementException;

import telran.util.Arrays;

public class Canvas extends Shape implements Iterable<Shape> {
	private Shape[]shapes=new Shape[0];
	public Canvas(long id) {
		super(id);
		
	}
	public void addShape(Shape shape){
		
		shapes=Arrays.add(shapes, shape);
	}
	public Shape removeShape(long id) {
		Shape newShape=null;
		shapes=Arrays.removeIf(shapes,s->s.getId()==id);
		return newShape;
	}
	@Override
	public int square() {
		int square=0;
		for(Shape shape:shapes) {
			square+=shape.square();
		}
		return square;
	}

	@Override
	public int perimeter() {
		int	perimeter=0;
		for(Shape shape:shapes) {
			perimeter+=shape.perimeter();
		}
		return 0;
	}
	@Override
	public Iterator<Shape> iterator() {
	
		return new CanIterator();
	}
	private class CanIterator implements Iterator<Shape>{
		int index=1;
		@Override
		public boolean hasNext() {
			return index<shapes.length;
		}
		@Override
		public Shape next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return shapes[index++];
		}
	}
}
