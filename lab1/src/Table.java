package lab1;


import java.io.*;
import java.util.StringTokenizer;
import java.lang.Object;
import java.util.*;
public class Table {
	List<Integer> objects;
	List<Integer> neighbours;
	int h,f,g;
	int up, down, left, right;
	

	public Table(List<Integer> theobjects) {
		objects = new ArrayList<Integer>();
		for(int i = 0; i < theobjects.size(); i++) {
			objects.add(theobjects.get(i));
		}
	}
	
	public int getF() {
		return (g + h);
	}
	public void setDirections(int pos) {
		
		switch(pos) {
		case 0:
			up = -1;
			left = -1;
			down = pos + 3;
			right = pos + 1;
			break;
		case 1:
			up = -1;
			left = pos - 1;
			down = pos + 3;
			right = pos + 1;
			break;
		case 2:
			up = -1;
			left = pos - 1;
			down = pos + 3;
			right = -1;
			break;
		case 3:
			up = pos - 3;
			left = -1;
			down = pos + 3;
			right = pos + 1;
			break;
		case 4:
			up = pos - 3;
			left = pos - 1;
			down = pos + 3;
			right = pos + 1;
			break;
		case 5:
			up = pos - 3;
			left = pos - 1;
			down = pos + 3;
			right = -1;
			break;
		case 6:
			up = pos - 3;
			left = -1;
			down = -1;
			right = pos + 1;
			break;
		case 7:
			up = pos - 3;
			left = pos -1;
			down = -1;
			right = pos + 1;
			break;
		case 8:
			up = pos - 3;
			left = pos - 1;
			down = -1;
			right = -1;
			break;
			
	
		}
	}
	public int getvalue(int value) {
		for(int i = 0; i < objects.size(); ++i) {
			
			if(objects.get(i) == value) {
				return objects.get(i);
			}
		}
		return -1;
	}
	public int getIndex(int value) {
		for( int i = 0; i < objects.size(); ++i) {
			if (objects.get(i) == value){
				return i;
			}
		}
		return -1;
	}
	
	public List<Integer>getneighbours(int value){
		
		List<Integer> neighbours = new ArrayList<Integer>();
		int pos = getIndex(value);
		setDirections(pos);
		for (int i = 0; i < objects.size(); i++) {
			if(i == left || i == right || i == up || i == down) {
				neighbours.add(objects.get(i));
			}
			//neighbours.add(e)
		}
		return neighbours;
		
	}
	public void print()
	{
		for (int i = 0; i < objects.size(); i++)
		{
		   System.out.print(objects.get(i) + " ");
		    if (i == 2   || i == 5 || i == 8)
		        System.out.println("");
		}
		System.out.println("");
	}
	@Override
	  public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;

	    Table table = (Table) o;
	    return Arrays.equals(objects.toArray(new Integer[objects.size()]), table.objects.toArray(new Integer[table.objects.size()]));
	  }
	  
	  @Override
	  public int hashCode() {
	    return Arrays.hashCode(objects.toArray(new Integer[objects.size()]));
	  }


}
