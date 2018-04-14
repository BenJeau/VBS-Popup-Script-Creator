import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String location = System.getProperty("user.home") + "/Desktop/script.vbs";

		Scanner input = new Scanner(System.in);
		System.out.printf(
				"What kind of button do you want?\n\t0 - OK\n\t1 - OK and Cancel\n\t2 - Abort, Retry and Ignore\n\t3 - Yes, No and Cancel\n\t4 - Yes and No\n\t5 - Retry and Cancel\n");
		int buttonChoice = input.nextInt();
		System.out.printf(
				"What kind of icon do you want?\n\t0 - No Icon\n\t16 - Critical Icon (a.k.a. \"X\" icon)\n\t32 - Question Icon (a.k.a. \"?\" icon)\n\t48 - Warning Icon (a.k.a. \"!\" icon)\n\t64 - Info Icon (a.k.a. \"i\" icon)\n");
		int iconChoice = input.nextInt();
		System.out.println("What message would you like to have?");
		input.nextLine();
		String message = input.nextLine();
		System.out.println("What title would you like to have?");
		String title = input.nextLine();

		Write w = new Write(location);
		w.write("x=msgbox(\"" + message + "\", " + buttonChoice + "+" + iconChoice + ", \"" + title + "\")");

		executeProgram("cscript " + location);
	}

	public static void executeProgram(String com) {
		try {
			String command = "cmd /c call " + com;
			Process child = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
		}
	}

}
