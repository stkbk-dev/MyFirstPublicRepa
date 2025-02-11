package kataentrance;

public class ArithmeticMember {
	String value = null;
	int valueInt = 0;
	String description = null;

	private final static String[] ROMAN_NUMERALS = { "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	private final static int[] DECIMAL_VALUES = { 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    //regex for founding single or double decimals. ex. '1' or "22"
	private static String regexForArabicNumbers = "\\d||\\d\\d";
	// string.match([+-*/]);
	// regex for founding roman leter 
//	private static String regexForRomanNumbers = "X||IX||V||IV||I";
	private static String regexForRomanNumbers = "[IXV]||[IXV][IXV]||[IXV][IXV][IXV]||[IXV][IXV][IXV][IXV]";
	//regex not digit and not letter
	private static String regexForArithmeticOperators = "\\W";

	public ArithmeticMember(String value) throws InvalidInputException {
		this.value = value;
		if (value.matches(regexForArithmeticOperators)) {
			if (value.contains("+")) {
				description = "addition";
			}
			if (value.contains("-")) {
				description = "subtraction";
			}
			if (value.contains("*")) {
				description = "multiplication";
			}
			if (value.contains("/")) {
				description = "division";
			}
		}


		if (value.matches(regexForArabicNumbers)) {
			if (Integer.valueOf(value)<1|| Integer.valueOf(value )> 10) {
				throw new InvalidInputException("Арабскими числами могут быть 1 - 10 включительно");
			}
			this.valueInt = Integer.valueOf(value) ;
			description = "arab";
		}

		if (value.matches(regexForRomanNumbers)) {
					description = "roman";
					this.valueInt = fromRomanNumeralToArabic(value);
					if (Integer.valueOf(valueInt)<1|| Integer.valueOf(valueInt )> 10) {
						throw new InvalidInputException("Римскими числами могут быть I - X включительно");
					}
		}

		if (description == null) {
			throw new InvalidInputException("ввод данных недостаточен для выполнения операции");
		}

	}

	/**
	 * Метод переводит число из арабского в римское В этом цикле мы отнимаем
	 * наибольшее соостветсвующее римскому числу арабское число из предоставленного
	 * арабкого числа и пошагово прибавляем эти числа к ответу
	 * 
	 * @param number для арабского числа, которое нужно перевести в римское число
	 * @return строка, содержащая римское число
	 */
	public static String toRomanNumeral(int number) {
		StringBuilder result = new StringBuilder();
		int remaining = number;
		for (int i = 0; i < ROMAN_NUMERALS.length; i++) {
			int decimalValue = DECIMAL_VALUES[i];
			String romanNumeral = ROMAN_NUMERALS[i];
			while (remaining >= decimalValue) {
				result.append(romanNumeral);
				remaining -= decimalValue;
			}
		}
		return result.toString();
	}

	/**
	 * Метод переводи число из римского в арабское Тут мы проходимся по массиву
	 * строк Если наибольшая римская цифра из массива соответсвует взятой подстроке
	 * из предоставленного числа, то мы прибавляем к выводимому римскому числу
	 * соответсвущую ему арабский эквивалент при этом предоставляемое римское число
	 * укараичвается на размер найденной подстроки.
	 * 
	 * @param romanNumeral String для римского числа, которое нужно перевести в
	 *                     арабское
	 * @return арабское число, соответсвующее введенному римскому
	 */
	public static int fromRomanNumeralToArabic(String romanNumeral) {
		int result = 0;
		String input = romanNumeral.toUpperCase();
		for (int i = 0; i < ROMAN_NUMERALS.length; i++) {
			String romanNumeralToCheck = ROMAN_NUMERALS[i];
			int decimalValue = DECIMAL_VALUES[i];
			while (input.startsWith(romanNumeralToCheck)) {
				result += decimalValue;
				input = input.substring(romanNumeralToCheck.length());
			}
		}
		return result;
	}

}
