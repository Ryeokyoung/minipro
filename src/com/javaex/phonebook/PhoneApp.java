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


public class PhoneApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		List<Phone> PhoneList = new ArrayList<Phone>();
		
		System.out.println("*******************************");
		System.out.println("*      전화번호 관리 프로그램        *");
		System.out.println("*******************************");
		System.out.println();
		
		System.out.println("1.리스트  2.등록  3.삭제   4.검색  5.종료");
		System.out.println("------------------------------------");
		System.out.println(">메뉴번호:");
		
		Reader fr = new FileReader("C:\\javaStudy\\file\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
	
		while(true) { 
			
			String str = br.readLine();
			
			if(str==null) {
				break;
				
			}
			
			String[] personInfo = str.split(",");
			
			String name = personInfo[0];
			String hp = personInfo[1];
			String company = personInfo[2];
			
			Phone phone = new Phone(name, hp, company);
			
			PhoneList.add(phone);
			
			}
			
			for(Phone phone1 :PhoneList) {
				System.out.println("이름:" + phone1.getName() );
				System.out.println("핸드폰: "+ phone1.getHp());
				System.out.println("회사: " + phone1.getCompany());
				System.out.println("");
			}
			
			Writer fw = new FileWriter("./PhoneDB.txt"); { 
			BufferedWriter bw = new BufferedWriter(fw);
				
			for(Phone phone1 : PhoneList) {
					String saveStr = phone1.getName() + "," + phone1.getHp() + "," + phone1.getCompany();
					System.out.println(saveStr);
			
				
					bw.newLine();
					bw.write(saveStr);
			}
	
			bw.close();
			br.close();
			
		
			fr.close();
			
			System.out.println("*******************************");
			System.out.println("*      전화번호 관리 프로그램 종료    *");
			System.out.println("*******************************");
			System.out.println();
	}
		}
	}


	
