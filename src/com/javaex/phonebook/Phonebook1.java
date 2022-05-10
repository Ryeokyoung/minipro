package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phonebook1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		List<Person> PhoneList = new ArrayList<Person>();
		Reader fr = new FileReader("./PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		Scanner sc = new Scanner(System.in);
		
		while(true) { 
			Person p = new Person();
			String str = br.readLine();
			
			if(str==null) {
				break;
				
			}
			
			String[] phoneDB = str.split(",");
			
			String name = phoneDB[0];
			String hp = phoneDB[1];
			String company = phoneDB[2];
			PhoneList.add(p);
			} 
			Writer fw = new FileWriter("./PhoneDB.txt"); { 
			BufferedWriter bw = new BufferedWriter(fw);
				
			for(Person phone1 : PhoneList) {
					String saveStr = phone1.getName() + "," + phone1.getHp() + "," + phone1.getCompany();
					System.out.println(saveStr);
			
				
					bw.newLine();
					bw.write(saveStr);
			}
				
			
		System.out.println("*******************************");
		System.out.println("*      전화번호 관리 프로그램        *");
		System.out.println("*******************************");
		System.out.println();
		
		System.out.println("1.리스트  2.등록  3.삭제   4.검색  5.종료");
		System.out.println("------------------------------------");
		System.out.println(">메뉴번호:");
		int num = sc.nextInt();
		
		if(num == 5) { 
			System.out.println("**********");
			System.out.println("[감사합니다! ]");
			System.out.println("**********");
		
		}else if (num ==1){
		switch(num) { 
		case 1 : 
			System.out.println("<1.리스트>");
			for(int i=0; i<PhoneList.size(); i++) {
				System.out.println((i+1)+".\t"+PhoneList.get(i).name+"\t"
									+PhoneList.get(i).hp+"\t"+PhoneList.get(i).company);
			}
			break;
		case 2 : 
			System.out.println("<2.등록>");
			Person p01 = new Person();
			System.out.print(">이름: ");
			p01.name = sc.next();
			System.out.print(">휴대전화: ");
			p01.hp = sc.next();
			System.out.print(">회사전화: ");
			p01.company = sc.next();
			PhoneList.add(p01);
			System.out.println("등록되었습니다.");
			break;
		}
		}
			bw.close();
			br.close();
			
	}
			sc.close();
}
}
