package service;

import datastr.MyBST;
import model.Patient;

public class MainService {
	
	public static void main(String[] args) {
		
		System.out.println("----------DARBĪBAS AR INT------------");
		MyBST<Integer> bstForIntegers = new MyBST<Integer>();

		try {
			bstForIntegers.add(10);//P: 10
			bstForIntegers.add(6);//P: 10 (LC:6)
			bstForIntegers.add(23);//P: 10 (LC:6, RC:23)
			bstForIntegers.add(8);//P: 10 (LC:6, RC:23); P:6 (RC:8)
			bstForIntegers.add(7);//P: 10 (LC:6, RC:23); P:6 (RC:8); P: (LC:7)
			bstForIntegers.print();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("----------DARBĪBAS AR PATIENTS------------");
		MyBST<Patient> bstPatients = new MyBST<Patient>();
		
		try {
			
			bstPatients.add(new Patient("Janis", "Berzins", 1)); // P: Janis
			bstPatients.add(new Patient("Liga", "Jauka", 3)); // P: Liga (LC: Janis)
			bstPatients.add(new Patient("Baiba", "Kalnina", 2)); // P: Liga (LC: Janis, RC: Baiba)
			bstPatients.add(new Patient("Juris", "Nejaukais", 5)); // P: Juris (LC: Liga, RC: Baiba) P: Janis
			bstPatients.print();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	
	
}
