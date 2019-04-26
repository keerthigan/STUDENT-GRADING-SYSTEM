package universityGradingsystem;

import java.util.ArrayList;
import java.util.Scanner;

/*university system class is created to create objects, to define data type,
 and to create methods to do calculations*/
public class UniversitySystem {
	// private scanner is used because this scanner is used only in this class.
	private static Scanner scanner = new Scanner(System.in);
	// private array list "students" is created to store student details and module
	// details.
	private static ArrayList<Student> students = new ArrayList<Student>();
	// Declaring variables and defining its data type.
	static int num = 0;
	static String grade;
	static double classTotal = 0;
	static double classAvg = 0;
	static int marks = 0;
	static int firstclass = 0;
	static int secondclass = 0;
	static int secondlowerclass = 0;
	static int normal = 0;
	static int fail = 0;

	// this is Main method, in java the execution starts at this point.
	public static void main(String[] args) {
		// creating an object studentGradingSystem in the class UniversitySystem to call
		// the mainMenu.
		UniversitySystem studentGradingSystem = new UniversitySystem();
		// calling the mainMenu method to Main method in java program execution.
		studentGradingSystem.mainMenu();

	}

	// creating a mainMenu method to repeat a menu.
	public void mainMenu() {
		// while (true) this loop is an infinity loop this loop is created to repeat the
		// menu till infinity.
		while (true) {
			// calling the getInput method here.
			getInput();
		}
	}

	// this is the getInput method where the menu is printed and selections are
	// performed.
	public void getInput() {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("Enter A For Add Student");
		System.out.println("Enter B For Class Average");
		System.out.println("Enter C For Print Below 30");
		System.out.println("Enter D For Retake Student");
		System.out.println("Enter E For Resit Student");
		System.out.println("Enter F For Below Average");
		System.out.println("Enter G For above Average");
		System.out.println("Enter H For Lowest Scorer");
		System.out.println("Enter I For Highest Scorer");
		System.out.println("Enter J For HorizontalHistogram");
		System.out.println("Enter K to Quit Program");
		System.out.println("Enter Your Selection : ");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		/*
		 * creating a variable selection and assigning to scanner.next().toLowerCase
		 * this is done to to convert uppercase inputs to lowercase
		 */
		String selection = scanner.next().toLowerCase();
		// calling the selections method.
		selections(selection);
	}

	// selections method is created to switch cases for users selection.
	private void selections(String selection) {
		/*
		 * switch case method is used to reduce complexibility of nested if statements
		 * where switch case does the same job as nested if statements.
		 */
		switch (selection) {
		case "a":
			getStudentDetails();
			break;
		case "b":
			getClassAverage();
			break;
		case "c":
			printBelow30();
			break;
		case "d":
			getListOfRetake();
			break;
		case "e":
			getListOfResit();
			break;
		case "f":
			belowAvg();
			break;
		case "g":
			aboveAvg();
			break;
		case "h":
			getLowestScorer();
			break;
		case "i":
			getHighScorer();
			break;
		case "j":
			HorizontalHistogram.star();
			break;
		case "k":
			System.exit(1);
			break;
		default:
			System.out.println("###Invalid Input Try Again !!!###");
			break;
		}
	}

	/*
	 * getStudentDetails method is used to get user input of student details and* to
	 * store them to the array list
	 */
	private static void getStudentDetails() {
		System.out.print("Enter First Name : ");
		String fName = scanner.next();
		System.out.print("Enter Last Name : ");
		String lName = scanner.next();
		System.out.print("Enter Registration No : ");
		String registrationNo = scanner.next();
		System.out.print("Enter Marks For ICT 01  : ");
		int fIctMarks = scanner.nextInt();
		validatemarks(fIctMarks);
		System.out.print("Enter Marks For ICT 02  : ");
		int sIctMarks = scanner.nextInt();
		// calling the validate marks method to validate marks.
		validatemarks(sIctMarks);
		System.out.print("Enter Marks For Group CWK 01 : ");
		int fCwMarks = scanner.nextInt();
		validatemarks(fCwMarks);
		System.out.print("Enter Marks For Group CWK 02 : ");
		int sCwMarks = scanner.nextInt();
		validatemarks(sCwMarks);
		/*
		 * student object is created for Student class and variables are declared to
		 * gain access beacause variables in Student class are declared as private
		 * variables
		 */
		Student student = new Student(fName, lName, registrationNo, fIctMarks, sIctMarks, fCwMarks, sCwMarks);
		student.setModuleMarks(fIctMarks, sIctMarks, fCwMarks, sCwMarks);
		// calling getgrade method for student object.
		getGrade(student);
		// adding students object to students array
		students.add(student);
		System.out.println(student);
		// num in ths case is used as student count to calculate averagae and to display
		// total students in the list
		num++;
		System.out.println(num);
	}

	// this method is created to validate marks where it displays a error message if
	// marks is more than 100 or less than 0.
	private static void validatemarks(int marks) {
		if (marks < 0 || marks > 100) {
			System.out.println("###Invalid Marks!###\n###Please enter marks within range 0-100###");
			getStudentDetails();
		}
	}

	// this method is used to calculate the grades for each student.
	public static void getGrade(Student s) {
		if (s.getModuleMarks() > 70) {
			s.setModuleGrade("First Class");
			firstclass++;
		} else if (s.getModuleMarks() > 60) {
			s.setModuleGrade("Second Upper Class");
			secondclass++;
		} else if (s.getModuleMarks() > 50) {
			s.setModuleGrade("Second Lower Class");
			secondlowerclass++;
			// getModuleMarks gets the modulemarks from Student class for grading.
		} else if (s.getModuleMarks() > 40) {
			s.setModuleGrade("General Pass");
			normal++;
		} else {
			// setModuleGrade sets module grade for ModuleGrade in Student class
			s.setModuleGrade("Fail");
			fail++;
		}
		// return grade;
	}

	// this method is created to calculate class average for students
	private static void getClassAverage() {
		// this condition returns error message if the students list is empty.
		if (students.size() < 1) {
			System.out.println("###No students added to the system!###");
		} else {
			/*
			 * student variable is created for Student class to obtain student details from
			 * students list This is a for-each loop. It sets student to the first element
			 * of students, then runs the loop body. Then it sets student to the second
			 * element of studets, then runs the loop body.
			 */
			for (Student student : students) {
				classTotal = classTotal + student.getModuleMarks();
			}
			classAvg = classTotal / num;
			System.out.println("Class Average is: " + classAvg);
		}
	}

	private void printBelow30() {
		if (students.size() < 1) {
			System.out.println("###No students added to the system!###");
		} else {
			int noOfFIct = 0;
			int noOfSIct = 0;
			int noOfFCw = 0;
			int noOfSCw = 0;
			// the for each loop is used to get the student details from students list and
			// to gothrough if conditions.
			for (Student student : students) {
				if (student.getfIctMarks() < 30) {
					noOfFIct++;
					System.out.println("Student Name : " + student.getfName() + " " + student.getlName()
							+ "    Component Name  : First ICT ");
				}

				if (student.getsIctMarks() < 30) {
					noOfSIct++;
					System.out.println("Student Name : " + student.getfName() + " " + student.getlName()
							+ "    Component Name  : Second ICT ");
				}

				if (student.getfCwMarks() < 30) {
					noOfFCw++;
					System.out.println("Student Name : " + student.getfName() + " " + student.getlName()
							+ "    Component Name  : First CW ");
				}

				if (student.getsCwMarks() < 30) {
					noOfSCw++;
					System.out.println("Student Name : " + student.getfName() + " " + student.getlName()
							+ "    Component Name  : Second CW ");
				}
			}

			System.out.println("First ICT : " + noOfFIct);
			System.out.println("Second ICT : " + noOfSIct);
			System.out.println("First CW : " + noOfFCw);
			System.out.println("Second CW : " + noOfSCw);

		}
	}

	private static void aboveAvg() {
		if (students.size() < 1) {
			System.out.println("###No students added to the system!###");
		} else {
			for (Student student : students) {
				if (student.getModuleMarks() > classAvg) {
					System.out.println("Student Name : " + student.getfName() + " " + student.getlName());
				}
			}
		}
	}

	private static void belowAvg() {
		if (students.size() < 1) {
			System.out.println("###No students added to the system!###");
		} else {
			// this for each loop gets Modulemarks for each student.
			for (Student student : students) {
				// this conition checks whether ModuleMarks is less than class average.
				if (student.getModuleMarks() < classAvg) {
					System.out.println("Student Name : " + student.getfName() + " " + student.getlName());
				}
			}
		}
	}

	// Retake method checks the condition and
	private void getListOfRetake() {
		if (students.size() < 1) {
			System.out.println("###No students added to the system!###");
		} else {
			for (Student student : students) {
				if (student.getModuleMarks() < 30) {
					System.out.println("Student Name : " + student.getfName() + " " + student.getlName()
							+ "Have to re-take this module");
				}
			}
		}
	}

	// this is the re-sit method this method checks conditions and return re-sit
	// student details
	private void getListOfResit() {
		if (students.size() < 1) {
			System.out.println("###No students added to the system!###");
		} else {
			for (Student student : students) {
				/*
				 * this condition checks whether the student has scored above 40 overall but
				 * failed to score component mark below 30 which results in re-sit
				 */
				if (student.getModuleMarks() >= 40 && student.getfIctMarks() < 30) {
					System.out.println("Student Name : " + student.getfName() + " " + student.getlName()
							+ "Component Name : First ICT ");
				}

				if (student.getModuleMarks() >= 40 && student.getsIctMarks() < 30) {
					System.out.println("Student Name : " + student.getfName() + " " + student.getlName()
							+ "    Component Name  : Second ICT ");
				}

				if (student.getModuleMarks() >= 40 && student.getfCwMarks() < 30) {
					System.out.println("Student Name : " + student.getfName() + " " + student.getlName()
							+ "    Component Name  : First CW ");
				}

				if (student.getModuleMarks() >= 40 && student.getsCwMarks() < 30) {
					System.out.println("Student Name : " + student.getfName() + " " + student.getlName()
							+ "    Component Name  : Second CW ");
				}
			}
		}
	}

	private static void getLowestScorer() {
		if (students.size() < 1) {
			System.out.println("###No students added to the system!###");
		} else {
			double low = 100;
			Student[] stu = new Student[1];
			for (Student student : students) {
				if (student.getModuleMarks() < low) {
					stu[0] = student;
					low = student.getModuleMarks(); // Edited
				}
			}
			System.out.println(stu[0].getfName() + " " + stu[0].getlName() + " " + stu[0].getRegistrationNo());
		}
	}

	// this method is created to return highest scorer.
	private void getHighScorer() {
		if (students.size() < 1) {
			System.out.println("###No students added to the system!###");
		} else {
			// this part of code checks for each students and compare it seperately and
			// returns the highest scorer for each component.
			Student highModule = students.get(0);
			Student highScorerInIct1 = students.get(0);
			Student highScorerInIct2 = students.get(0);
			Student highScorerInCW1 = students.get(0);
			Student highScorerInCW2 = students.get(0);
			// this for each loop checks for checks for each students module marks and
			// component marks to check for highest score.
			for (Student student : students) {
				if (student.getModuleMarks() > highModule.getModuleMarks()) {
					highModule = student;
				}

				if (student.getfIctMarks() > highScorerInIct1.getfIctMarks()) {
					highScorerInIct1 = student;
				}
				if (student.getsIctMarks() > highScorerInIct2.getsIctMarks()) {
					highScorerInIct2 = student;
				}
				if (student.getfCwMarks() > highScorerInCW1.getfCwMarks()) {
					highScorerInCW1 = student;
				}
				if (student.getsCwMarks() > highScorerInCW2.getsCwMarks()) {
					highScorerInCW2 = student;
				}
			}
			System.out.println("Highest Scorer For Module : " + highModule.getfName() + " " + highModule.getlName());
			System.out.println(
					"First ICT Highest Scorer : " + highScorerInIct1.getfName() + " " + highScorerInIct1.getlName());
			System.out.println(
					"second ICT Highest Scorer : " + highScorerInIct2.getfName() + " " + highScorerInIct2.getlName());
			System.out.println(
					"First CWK01 Highest Scorer : " + highScorerInCW1.getfName() + " " + highScorerInCW1.getlName());
			System.out.println(
					"second CWK02 Highest Scorer : " + highScorerInCW2.getfName() + " " + highScorerInCW2.getlName());
		}
	}
}
