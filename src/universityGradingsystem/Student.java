package universityGradingsystem;

/*Student class is created to create objects, to define data type,
and to create methods to do calculations*/
public class Student {
	// declaration of variables are done here variables are private because these
	// variables are used in this class only.
	private String fName;
	private String lName;
	private String registrationNo;

	private int fIctMarks;
	private int sIctMarks;
	private int fCwMarks;
	private int sCwMarks;
	private double moduleMarks;
	private String moduleGrade;
 
	// this method makes the variables in student class public to assign getters and
	// setters.
	public Student(String fName, String lName, String registrationNo, int fIctMarks, int sIctMarks, int fCwMarks,
			int sCwMarks) {
		// this is an supertype public obect.
		super();
		// this part is the setters for these 7 variables setters are used to assign
		// values to the getters.
		this.fName = fName;
		this.lName = lName;
		this.registrationNo = registrationNo;
		this.fIctMarks = fIctMarks;
		this.sIctMarks = sIctMarks;
		this.fCwMarks = fCwMarks;
		this.sCwMarks = sCwMarks;
	}

	// getters start from here getters are used to get values from other classes.
	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public int getfIctMarks() {
		return fIctMarks;
	}

	public int getsIctMarks() {
		return sIctMarks;
	}

	public int getfCwMarks() {
		return fCwMarks;
	}

	public int getsCwMarks() {
		return sCwMarks;
	}

	public double getModuleMarks() {
		return moduleMarks;
	}

	public void setModuleMarks(int fIctMarks, int sIctMarks, int fCwMarks, int sCwMarks) {
		this.moduleMarks = ((fIctMarks * 0.2) + (sIctMarks * 0.2) + (fCwMarks * 0.3) + (sCwMarks * 0.3));
	}

	/*
	 * The method does override or implement a method declared in a supertype. The
	 * method has a signature that is override-equivalent to that of any public
	 * method declared in Object
	 */
	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", registrationNo=" + registrationNo + ", fIctMarks="
				+ fIctMarks + ", sIctMarks=" + sIctMarks + ", fCwMarks=" + fCwMarks + ", sCwMarks=" + sCwMarks
				+ ", moduleMarks=" + moduleMarks + ", moduleGrade=" + moduleGrade + "]";
	}

	public String getModuleGrade() {
		return moduleGrade;
	}

	public void setModuleGrade(String moduleGrade) {
		this.moduleGrade = moduleGrade;
	}
}
