package Collection.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student> {
	
	public static void main(String[] args) {

		List<Student> list = new ArrayList<Student>();
		
		list.add(new Student("S001", "홍길동", 90, 90, 90));
		list.add(new Student("S002", "유성룡", 74, 89, 75));
		list.add(new Student("S003", "일지매", 84, 78, 80));
		list.add(new Student("S004", "이순신", 82, 65, 68));
		list.add(new Student("S005", "을지문덕", 94, 80, 96));
		list.add(new Student("S006", "강감찬", 67, 77, 79));
		
		setRanked(list);

		// 셔플 후
		Collections.shuffle(list);
		System.out.println();
		System.out.println("=== 셔플 후 === ");
		for (Object stu : list) {
			System.out.println(stu);
		}

		// 학번 순으로 정렬 후 (내부 정렬)
		Collections.sort((List<Student>) list);
		System.out.println();
		System.out.println("=== 내부 정렬 후 === ");
		for (Object stu : list) {
			System.out.println(stu);
		}

		// 총점 내림차순 정렬 - 총점 같은 경우 학번 내림차순 정렬 (외부 정렬)
		Collections.sort(list, new totalDesc());
		System.out.println();
		System.out.println("=== 외부 정렬 후 === ");
		for (Object stu : list) {
			System.out.println(stu);
		}

	}
	
	// 필드
	private String id;
	private String name;
	private int korean;
	private int english;
	private int math;
	private int total;
	private int rank;

	public Student() {
	}

	public Student(String id, String name, int korean, int english, int math) {
		this.id = id;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.total = korean + english + math;
		this.rank = 1;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	public static void setRanked(List<Student> students) {
		for (Student t1 : students) {
			int ranking = t1.rank;
			for (Student t2 : students) {
				if (t1.getTotal() < t2.getTotal()) {
					ranking++;
				}
			}
			t1.setRank(ranking);
		}
	}
	
	@Override
	public int compareTo(Student id) {
		return this.getId().compareTo(id.getId());
	}

	@Override
	public String toString() {
		return "Student [학번 = " + id + ", 이름 = " + name + ", 국어 = " + korean + ", 영어 = " + english + ", 수학 = " + math
				+ ", 총점 = " + total + ", 등수 = " + rank + "]";
	}

}


	

class totalDesc implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		if (s1.getTotal() == s2.getTotal()) {
			return s1.getId().compareTo(s2.getId()) * -1;
		} else {
			return Integer.compare(s1.getTotal(), s2.getTotal()) * -1;
		}
	}
	
}