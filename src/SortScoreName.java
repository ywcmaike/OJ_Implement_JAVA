import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * 一个学生对象有两个属性分别是：name（String）和score（Int）。现在需要按照学生的score来排序，score越大越靠前。如果score相同时，按照name的字母顺序排序。要求：方法接口自己设计；最好能有单元测试
 */
class Student {
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	private int score;
	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class SortByScoreName implements Comparator{
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		if (s1.getScore() > s2.getScore()) {
			return -1;
		} else if (s1.getScore() == s2.getScore()) {
			if (s1.getName().compareTo(s2.getName()) > 0) {
				return -1;
			} else if (s1.getName().compareTo(s2.getName()) == 0) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}
}
public class SortScoreName {
	
	public ArrayList<Student> sortScoreName(ArrayList<Student> lists) {
		Collections.sort(lists, new SortByScoreName());
		return lists;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> lists = new ArrayList<Student>();
		Student s1 = new Student("wanghai", 21);
		Student s2 = new Student("wanghai123", 21);
		Student s3 = new Student("sdfjslfs", 12);
		Student s4 = new Student("dsffj", 13);
		Student s5 = new Student("fdsafs", 14);
		lists.add(s1);
		lists.add(s2);
		lists.add(s3);
		lists.add(s4);
		lists.add(s5);
		new SortScoreName().sortScoreName(lists);
		for (Student student : lists) {
			System.out.println(student.getScore() + "  " + student.getName());
		}
	}

}
