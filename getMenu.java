package get_menu;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class getMenu {
	public static void main(String[] args) throws IOException {
		
		// date
		Calendar today = Calendar.getInstance();		
		//Date todayDate = Calendar.getInstance().getTime();
		today.add(Calendar.DATE,-4);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String thisDate = formatter.format(today.getTime());	
		
		// get restaurant names
		/*System.out.println("<식당이름들>");
		for (int i=0; i<6; i++) {
			Element content = doc1.select(".left_text14").get(i);
			System.out.println(content.text()); // text()대신 toString 쓰면 태그도 출력			
		} */ 
		
		int j=0;
		do {
			// parsing document from URL
			// 직영식당: doc1
			System.out.println(thisDate);
			
			Document doc1 = Jsoup.connect("http://www.snuco.com/html/restaurant/restaurant_menu1.asp?date="+thisDate).get();
			
			// menu table 접근
			Element menuTable = doc1.select("table").get(7);
			Element tableBody = menuTable.select("tbody").get(0); 
			Elements rows = tableBody.select("tr");				
			
			// get each menu of restaurants	
			System.out.println("<식당 순서 맞춰서 아침점심저녁>");
			String[][] foodTable = new String[6][3];
			for (int i=1; i<=6; i++) {
				Element restaurant = rows.get(i); // 학생회관
				String breakfastRaw = restaurant.select("td").get(2).text();	
			
				String break1 = breakfastRaw.replace("ⓐ","");				
				String break2 = break1.replace("ⓑ","");
				String break3 = break2.replace("ⓒ","");											
				String break4 = break3.replace("ⓓ","");										
				String break5 = break4.replace("ⓔ","");										
				String break6 = break5.replace("ⓕ","");										
				String breakfast = break6.replace("ⓖ","");		
				
				
								
				foodTable[i-1][0] = breakfast;
				
				String lunchRaw = restaurant.select("td").get(4).text();
				
				String lunch1 = lunchRaw.replace("ⓐ","");				
				String lunch2 = lunch1.replace("ⓑ","");
				String lunch3 = lunch2.replace("ⓒ","");											
				String lunch4 = lunch3.replace("ⓓ","");										
				String lunch5 = lunch4.replace("ⓔ","");										
				String lunch6 = lunch5.replace("ⓕ","");										
				String lunch = lunch6.replace("ⓖ","");				
				
				foodTable[i-1][1] = lunch;
				
				String dinnerRaw = restaurant.select("td").get(6).text();
				
				String dinner1 = dinnerRaw.replace("ⓐ","");				
				String dinner2 = dinner1.replace("ⓑ","");
				String dinner3 = dinner2.replace("ⓒ","");											
				String dinner4 = dinner3.replace("ⓓ","");										
				String dinner5 = dinner4.replace("ⓔ","");										
				String dinner6 = dinner5.replace("ⓕ","");										
				String dinner = dinner6.replace("ⓖ","");
				
				foodTable[i-1][2] = dinner;
			}
					
			System.out.println(Arrays.deepToString(foodTable));
			
			
			// 위탁식당: doc2
			Document doc2 = Jsoup.connect("http://www.snuco.com/html/restaurant/restaurant_menu2.asp?date="+thisDate).get();
			
			// menu table 접근
			Element menuTable2 = doc2.select("table").get(7);
			Element tableBody2 = menuTable2.select("tbody").get(0); 
			Elements rows2 = tableBody2.select("tr");				
			
			// get each menu of restaurants	
			System.out.println("<식당 순서 맞춰서 아침점심저녁>");
			String[][] foodTable2 = new String[10][3];
			for (int i=1; i<=10; i++) {
				Element restaurant2 = rows2.get(i); // 학생회관
				String breakfast2Raw = restaurant2.select("td").get(2).text();
				
				String break2d = breakfast2Raw.replace("ⓓ","");										
				String break2e = break2d.replace("ⓔ","");										
				String break2f = break2e.replace("ⓕ","");										
				String break2g = break2f.replace("ⓖ","");
				String break2h = break2g.replace("ⓗ","");
				String break2j = break2h.replace("ⓙ","");
				String breakfast2 = break2j.replace("ⓚ","");
				
				foodTable2[i-1][0] = breakfast2;
				
				String lunch2Raw = restaurant2.select("td").get(4).text();
				
				String lunch2d = lunch2Raw.replace("ⓓ","");										
				String lunch2e = lunch2d.replace("ⓔ","");										
				String lunch2f = lunch2e.replace("ⓕ","");										
				String lunch2g = lunch2f.replace("ⓖ","");
				String lunch2h = lunch2g.replace("ⓗ","");
				String lunch2j = lunch2h.replace("ⓙ","");
				String lunch2 = lunch2j.replace("ⓚ","");
				
				foodTable2[i-1][1] = lunch2;
				
				String dinner2Raw = restaurant2.select("td").get(6).text();
				
				String dinner2d = dinner2Raw.replace("ⓓ","");										
				String dinner2e = dinner2d.replace("ⓔ","");										
				String dinner2f = dinner2e.replace("ⓕ","");										
				String dinner2g = dinner2f.replace("ⓖ","");
				String dinner2h = dinner2g.replace("ⓗ","");
				String dinner2j = dinner2h.replace("ⓙ","");
				String dinner2 = dinner2j.replace("ⓚ","");				
				
				foodTable2[i-1][2] = dinner2;
			}
					
			System.out.println(Arrays.deepToString(foodTable2));
			
			today.add(Calendar.DATE,1);
			thisDate = formatter.format(today.getTime());
			j++;
			
		} while (j<7);	//일주일치 반복
		
		
		
	}
}