package practice01;

public class ProductTest {

	public static void main(String[] args) {
		/*100 노트북 1200000 2021 삼성
200 아이패드 500000 2022 애플
200 마우스 15000 2021 LG*/
		
		ProductDTO pdto1 = new ProductDTO(100, "노트북", 1200000, "2021", "삼성");
		ProductDTO pdto2 = new ProductDTO(200, "아이패드", 500000, "2022", "애플");
		ProductDTO pdto3 = new ProductDTO(200, "마우스", 15000, "2021", "LG");
		
		System.out.println("상품번호\t상품명\t가격\t제조년도\t제조사");
		System.out.println("====================================");
		System.out.println(pdto1);
		System.out.println(pdto2);
		System.out.println(pdto3);
		System.out.println("====================================");
	}

}
