package Collection.kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Set;

public class T07_Equals_HashCode {
/*
   해시 함수(Hash Function)는 임의의 길이의 데이터를 고정된 길이의 데이터로 
   매핑하는 함수이다. 해시함수에 의해 얻어지는 값은 
   해시값, 해시코드, 해시 체크섬 또는 간단하게 해시라고 한다.
  
   HashSet, HashMap, Hashtable 과 같은 객체들을 사용할 경우...
   객체가 서로 같은지를 비교하기 위해 equals() 메서드와 hashCode() 메서드를 호출한다.
   그래서 객체가 서로 같은지 여부를 결정하려면 두 메서드를 재정의 해야 한다.
   HashSet, HashMap, Hashtable 에서는 객체가 같은지 여부는 데이터를 추가할 때 검사한다.

	- equals() 메서드는 두 객체의 내용(값)이 같은지 비교하는 메서드이고,
	  hashCode() 메서드는 객체에 대한 해시코드값을 반환하는 메서드이다.
	  
	- equals() 메서드와 hashCode() 메서드에 관련된 규칙.
	 1. 두 객체가 같으면 반드시 같은 해시코드를 가져야한다.
	 2. 두 객체가 같으면 equals() 메서드를 호출했을때 true 를 반환해야 한다.
	     즉, 객체 a, b가 같으면 a.equals(b)와 b.equals(a) 둘다 true 이어야 한다.
	 3. 두 객체의 해시코드가 같다고 해서 두 객체가 반드시 같은 객체는 아니다.
	    하지만, 두 객체가 같다면 반드시 해시코드가 같아야 한다.
	 4. equals() 메서드를 override 하면 반드시 hashCode() 메서드도 override 해야 한다.
	 5. hashCode()는 기본적으로 Heap메모리에 있는 각 객체에 대한 메모리 주소 매핑 정보를
	    기반으로 한 정수값을 반환한다. 그러므로, 클래스에서 hashCode() 메서드를
	    override 하지 않으면 절대로 두 객체가 같은 것으로 간주될 수 없다.
	    
	- hashCode() 메서드에서 사용하는 '해싱알고리즘'에서 서로다른 객체에 대하여 같은
	  hashCode 값을 만들어 낼 수 있다. 그래서 객체가 같지 않더라도 hashCode가 같을 수 있다.
	  
	  인덱스가 아닌 해시함수를 통해 키값을 얻어 접근가능
	   -> 속도가 빠름.
*/
	public static void main(String[] args) {
		Person p1 = new Person(1, "홍길동");
		Person p2 = new Person(1, "홍길동");
		Person p3 = new Person(1, "이순신");
		
		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		System.out.println("p1 == p2 : " + (p1 == p2));
		System.out.println();
		Set<Person> set = new HashSet<Person>();
		
		set.add(p1);
		set.add(p2);
		
		System.out.println("p1, p2 등록 후 데이터");
		for (Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}
		System.out.println();
		System.out.println("add(p3) 성공여부 : " + set.add(p3));
		System.out.println("p3 등록 후 데이터");
		for (Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}
		System.out.println();
		System.out.println("remove(p2) 성공여부 : " + set.remove(p2));
		System.out.println("remove(p2) 후 데이터");
		for (Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}
		
	}
	
}	
	
	

class Person {
	private int id;
	private String name;
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
/*	 
	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return (this.getId() == p.getId() && this.getName().equals(p.getName()));
	}

	@Override
	public int hashCode() {
		
		return (name + id).hashCode();
	}
*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)			// 주소값이 같은 경우
			return true;
		if (obj == null)			// this 가 null 인 경우
			return false;
		if (getClass() != obj.getClass())  // 해당 객체가 생성된 클래스가 같은 지 ex) Person == Member
			return false;
		Person other = (Person) obj;
		if (id != other.id)		// this.id != 파라미터 id 가 다른 경우
			return false;
		if (name == null) {		
			if (other.name != null)		
				return false;
		} else if (!name.equals(other.name))   // 홍길동.equals(이순신) 틀리면 false
			return false;
		return true;
	}
	

}
