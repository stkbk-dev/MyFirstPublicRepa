package kataentrance;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InvalidInputException {
		System.out.println("Введите числа:");
		Scanner input = new Scanner(System.in);
		System.out.println(calc(input.nextLine()));

	}

	public static String calc(String input) throws InvalidInputException {
		try {
			Scanner scannerInput = new Scanner(input);
			ArithmeticMember firstMember = new ArithmeticMember(scannerInput.next());
			ArithmeticMember secondMember = new ArithmeticMember(scannerInput.next());
			ArithmeticMember thirdMember = new ArithmeticMember(scannerInput.next());
			if (scannerInput.hasNext()) {
				throw new InvalidInputException("формат математической операции не удовлетворяе"
						+ "т заданию - два операнда и один оператор (+, -, /, *)");
			}

			int resoult = 0;

			if (firstMember.description.equals(thirdMember.description) == false) {
				{
					throw new InvalidInputException(
							"Операции доступны только между римскими или " + "только между арабскими числами.");
				}

			} else {

				switch (firstMember.description) {
				case "roman":
					switch (secondMember.description) {
					case "addition":
						resoult = (firstMember.valueInt + thirdMember.valueInt);
						break;
					case "subtraction":
						resoult = (firstMember.valueInt - thirdMember.valueInt);
						break;
					case "multiplication":
						resoult = (firstMember.valueInt * thirdMember.valueInt);
						break;
					case "division":
						resoult = Math.round(firstMember.valueInt / thirdMember.valueInt);

						break;
					}
					if (resoult < 1) {
						throw new InvalidInputException("в римской системе нет отрицательных чисел");
					}
					return ArithmeticMember.toRomanNumeral(resoult);

				case "arab":
					switch (secondMember.description) {
					case "addition":
						resoult = (firstMember.valueInt + thirdMember.valueInt);
						break;
					case "subtraction":
						resoult = (firstMember.valueInt - thirdMember.valueInt);
						break;
					case "multiplication":
						resoult = (firstMember.valueInt * thirdMember.valueInt);
						break;
					case "division":
						resoult = Math.round(firstMember.valueInt / thirdMember.valueInt);
						break;
					}
					return String.valueOf(resoult);
				}

				return String.valueOf(resoult);
			}
		} catch (InvalidInputException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (NoSuchElementException e) {
			// Scanner не смог принять следующую String
			throw new InvalidInputException("ввод данных недостаточен для выполнения операции");
		}
		return input.concat(" тут чтото неправильно");
	}
}
