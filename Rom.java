public class Rom {
    public static void main(String[] args) {
		String romNumber = "MMMCMXCIX";
		String charHierarchy = "IVXLCDM";
		char lastChar = 'I';
		int cache = 0;
		int sum = 0;
		int[] charCount = {0, 0, 0, 0, 0, 0, 0};
		boolean error = false;
		for(int x = romNumber.length() - 1; x >= 0; x--) {
			if(romNumber.charAt(x) == 'I') {
				cache = 1;
				charCount[0]++;
			} else if(romNumber.charAt(x) == 'V') {
				cache = 5;
				charCount[1]++;
			} else if(romNumber.charAt(x) == 'X') {
				cache = 10;
				charCount[2]++;
			} else if(romNumber.charAt(x) == 'L') {
				cache = 50;
				charCount[3]++;
			} else if(romNumber.charAt(x) == 'C') {
				cache = 100;
				charCount[4]++;
			} else if(romNumber.charAt(x) == 'D') {
				cache = 500;
				charCount[5]++;
			} else if(romNumber.charAt(x) == 'M') {
				cache = 1000;
				charCount[6]++;
			}
			int index = charHierarchy.indexOf(romNumber.charAt(x));
			if(charCount[index] < 1) {
				System.out.println("Error: you can't use " + romNumber.charAt(x) + " after using it for substraction");
				error = true;
				break;
			}
			for(int y = 0; y < 7; y++) {
				if(charCount[y] > 3) {
					System.out.println("Error: you can't repeat the same number more than 3 times in a row");
					error = true;
					break;
				} else if(charHierarchy.indexOf(romNumber.charAt(x)) % 2 == 1 && charCount[y] > 1) {
					System.out.println("Error: you can use the number " + romNumber.charAt(x) + " only one time");
					error = true;
					break;
				}
			}
			if(index >= charHierarchy.indexOf(lastChar)) {
				sum += cache;
			} else {
				charCount[charHierarchy.indexOf(lastChar)] -= 1;
				if(charCount[index] > 1) {
					System.out.println("Error: you can't substract with " + romNumber.charAt(x) + " after already adding it");
					error = true;
					break;
				}
				charCount[index] = -2;
				if(charHierarchy.indexOf(romNumber.charAt(x)) % 2 == 0 && 
						index >= charHierarchy.indexOf(lastChar) - 2) {
					sum -= cache;
				} else {
					System.out.println("Error: you can't substract " + romNumber.charAt(x) + " from " + lastChar);
					error = true;
					break;
				}
			}
			lastChar = romNumber.charAt(x);	
		}
	    if(error == false) {
			System.out.println(sum);
	    }
    }
}