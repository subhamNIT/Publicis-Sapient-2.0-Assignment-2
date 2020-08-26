package com.assignment2.income;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AvgIncome {
	public static String x=",";

	public boolean calculate() throws IOException {
		Map<String, Float> hmap = new HashMap<String, Float>();
		
		
		try {
			BufferedReader inp= new BufferedReader(new FileReader("C:\\Users\\Subham Gupta\\Downloads\\AvgIncome.csv"));
			String content=inp.readLine();
					while(content!=null) {
						String[] line=content.split(",");
						String City=line[0];
						String Country=line[1];
						String Gender=line[2];
						String Currency=line[3];
						int Amount=Integer.parseInt(line[4]);
						float AverageIncome = (float)0.0;
						float Avg;
						AverageIncome=income(Currency,Amount, AverageIncome);
						if(Country==" ") {
							if(hmap.containsKey(City+" " + Gender))
							{
									Avg=hmap.get(City +" " +Gender );
									Avg=Avg+AverageIncome;	
									hmap.put(City+" "+Gender, Avg);
							}
							else {
									hmap.put(City+" "+Gender,AverageIncome);
							}
						}
						else {
							if(hmap.containsKey(Country+ " " + Gender)) {
									Avg=hmap.get(Country +" " +Gender );
									Avg=Avg+AverageIncome;	
									hmap.put(Country+" "+Gender, Avg);
							}
							else {
									hmap.put(Country +" " +Gender,AverageIncome);	
							}
						}	
					}	
		} 
		
		
		
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter out= new BufferedWriter(new FileWriter("C:\\Users\\Subham Gupta\\Downloads\\FinalAvgIncome.csv"));
		try {
		String message="Please find the new form of the input values";
		out.write(message);
		out.newLine();
		for(Map.Entry<String, Float> m:hmap.entrySet()) {
			writefile(out, m,x );
		}
		return true;
		
	} 
		catch (FileNotFoundException e) {			
		e.printStackTrace();
		return false;
	}finally{
		out.close();    
	}
	
		
}

	public void writefile(BufferedWriter out, Map.Entry<String, Float> m, String string2) throws IOException {
		String key=m.getKey();
		float value=m.getValue();
		String countryGen[]=key.split(",");
		String recard=countryGen[0]+" "+countryGen[1]+" "+value;
		
		if(string2.equals(x))
		{
			out.write(key+","+value);				
		}
		else{
			out.write(recard);
		}
		out.newLine();	
	}
	public static void main(String...s) {
		AvgIncome av= new AvgIncome();
		try {
			boolean v= av.calculate();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private float income(String Currency, int amount, float AverageIncome ) {
		
		if(Currency.equals("INR")) 
			 return AverageIncome=amount/66;
		else if(Currency.equals("GBP"))
			 return  AverageIncome=(float) (amount/0.67);
		else if(Currency.equals("SGD"))
			 return AverageIncome=(float)(amount/1.5);
		else if(Currency.equals("HKD"))
			 return AverageIncome=(float)(amount/8);
		else
			 return AverageIncome;
	}
}