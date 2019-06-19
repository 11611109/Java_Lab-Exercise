package ClassExercise3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class E19_17 {
	public static void main(String args[]) {
		BankAccount a=new BankAccount("Anna", 1000.98);
		BankAccount b=new BankAccount("Bob", 2345.89);
		BankAccount c=new BankAccount("Anna", 324.02);
		List<BankAccount> accounts=new ArrayList<>();
		accounts.add(a);
		accounts.add(b);
		accounts.add(c);
		
		System.out.println(totalBalance(accounts));
	}
	
	public static Map<String, Double> totalBalance(List<BankAccount> accounts){
		Map<String, List<BankAccount>> map=accounts.stream()
				.collect(Collectors.groupingBy(i -> i.getName()));
		Map<String, Double> newMap=new HashMap<>();
		for(String key:map.keySet()){
			List<BankAccount> accountList=map.get(key);
			double totalBalance=0;
			for (BankAccount cur:accountList){
				totalBalance+=cur.getBalance();
			}
			newMap.put(key, totalBalance);
		}
		return newMap;
	}
}
class BankAccount{
	String name;
	double balance;
	public BankAccount(String name,double balance){
		this.name=name;
		this.balance=balance;
	}
	public String getName() {
		return name;
	}
	public double getBalance() {
		return balance;
	}
}
