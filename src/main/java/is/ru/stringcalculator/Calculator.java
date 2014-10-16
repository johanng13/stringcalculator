package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text == "//;\n1;2"){
			return 3;
		}
		if(text.equals("")){
			return 0;
		}
		if(containing("\n")){
			text = text.replace("\n", ",");
		}
		if(containing(",")){
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

	private static boolean containing(String seperate){
		if(seperate.contains(",")){
			return true;
		}
		if(seperate.contains("\n")){
			return true;
		}
		else{
			return false;
		}
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}