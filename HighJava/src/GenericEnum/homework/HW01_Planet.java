package GenericEnum.homework;

public class HW01_Planet {
	
	static enum Planet {
		수성(2439), 
		금성(6052), 
		지구(6371), 
		성(3390), 
		목성(69911), 
		토성(58232), 
		천왕성(25362), 
		해왕성(24622);
	
		
		private int str;
		
		Planet(int radius) {
			this.str = radius;
		}
		
		public int getStr() {
			return str;
		}

		public double getArea (double radius) {
			return 4 * Math.PI * radius * radius;
		}
	}
	
	public static void main(String[] args) {
		Planet[] planet = Planet.values();
		
		for (Planet pl : planet) {
			System.out.println(pl.name() + " 의 면적 => " + pl.getArea(pl.getStr()) + " km²");
		}
	}
	
}


