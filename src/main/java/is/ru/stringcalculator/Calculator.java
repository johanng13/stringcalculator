package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.startsWith("//")){
			text = delimiters(text);
		}
		if(text.equals("")){
			return 0;
		}
		if(text.contains("\n")){
			text = text.replace("\n", ",");
		}
		if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else{
			return 1;
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}

	private static String delimiters(String text){
		String temp = text.substring(2,3);
			if(temp.charAt(0) == '['){
				if(text.contains("][")){
					int subStrLen1 = 0;
					for(int i = 0; i < text.length(); i++){
						if(text.charAt(i) == ']' && text.charAt(i+1) == '['){
							text = text.replace(text.substring(i-1,i), ",");
							subStrLen1 = i;
						}
					}
					text = text.replace(text.substring(subStrLen1+2,subStrLen1+3), ",");
					text = text.substring(subStrLen1+5);
				}

				else{
					String tempMany = "";
					int subStrLen2 = 0;
					for(int i = 3; i < text.length(); i++)
					{
						if(text.charAt(i) == ']'){
							tempMany = text.substring(3,i);
							subStrLen2 = i;
						}
					}
					text = text.replace(tempMany, ",");
					text = text.substring(subStrLen2);
				}
			}
			else{
				text = text.replace(temp, ",");
				text = text.substring(4);
			}
			return text;
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        	if(toInt(number) < 1001){
        		total += toInt(number);	
        	}
		}
		return total;
    }



}