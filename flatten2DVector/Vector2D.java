package flatten2DVector;

import java.util.Iterator;
import java.util.List;

public class Vector2D {
	private List<List<Integer>> vector;
	private Iterator<List<Integer>> firstLevelIterator;
	private List<Integer> currentList;
	private Iterator<Integer> secondLevelIterator;

	public Vector2D(List<List<Integer>> vec2d) {
		if (vec2d != null) {
			vector = vec2d;
			firstLevelIterator = vector.iterator();
			if (firstLevelIterator.hasNext()) {
				currentList = this.firstLevelIterator.next();
				this.secondLevelIterator = this.currentList.iterator();
			}
		}
	}

	public int next() {
		if (this.secondLevelIterator != null
				&& this.secondLevelIterator.hasNext()) {
			return this.secondLevelIterator.next();
		}
		if (this.firstLevelIterator != null
				&& this.firstLevelIterator.hasNext()) {
			this.currentList = this.firstLevelIterator.next();
			this.secondLevelIterator = this.currentList.iterator();
			return this.next();
		}
		return -1;
	}

	public boolean hasNext() {
		if (this.secondLevelIterator != null
				&& this.secondLevelIterator.hasNext()) {
			return true;
		}
		if (this.firstLevelIterator != null
				&& this.firstLevelIterator.hasNext()) {
			this.currentList = this.firstLevelIterator.next();
			this.secondLevelIterator = this.currentList.iterator();
			return this.hasNext();
		}
		return false;
	}
}