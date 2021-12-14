package GenericEnum.kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;


public class T06_WildCard {
/*
	와일드 카드에 대하여...
	
	와일드 카드(?)는 제너릭 타입을 이용한 타입 안전한 코드를 위해 사용되는 특별한 종류의
	인수(Argument)로서, 변수선언, 객체생성 및 메서드를 정의할 때 사용된다.
	
	<? extends T>  => 와일드카드의 상한 제한. T와 그 자손들만 가능
	<T super T>	   => 와일드카드의 하한 제한. T와 그 조상들만 가능
	<?>			   => 모든타입이 가능. <? extends Object> 와 동일
*/	
	
	public static void main(String[] args) {
		
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();  // 과일 상자
		FruitBox<Apple> appleBox = new FruitBox<>();  // 사과 상자
		FruitBox<? extends Fruit> grapeBox = new FruitBox<>();  // 포도 상자
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
//		grapeBox.add(new Grape());
//		grapeBox.add(new Grape());
		
		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox);
		Juicer.makeJuice(grapeBox);
	}
	
}

class Juicer {
//	static <T extends Fruit> void makeJuice(FruitBox<T> box) {
	static void makeJuice(FruitBox<? extends Fruit> box) {
		
		String fruitListStr = "";  // 과일목록
		
		int cnt = 0;
		for (Object f : box.getFruitList()) {
			if(cnt == 0) {
				fruitListStr += f;
			} else {
				fruitListStr += "," + f;
			}
		}
		System.out.println(fruitListStr + " => 쥬스 완성!!!");
	}
	
}


// 과일 
class Fruit {
	
	private String name;  //  과일이름

	public Fruit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일( " + name + " ) ";
	}
	
}

// 사과
class Apple extends Fruit {

	public Apple() {
		super("사과");
	}
}

// 포도
class Grape extends Fruit {
	
	public Grape() {
		super("포도");
	}
}

/*
 * 과일상자
 * @param <T>
 */
class FruitBox<T> {
	private List<T> fruitList;
	
	public FruitBox() {
		fruitList = new ArrayList<T>();
	}

	public List<T> getFruitList() {
		return fruitList;
	}
	
	public void add(T fruit) {
		fruitList.add(fruit);
	}
}

