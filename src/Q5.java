
import java.io.*;


public class Q5 {
	
	public static void addStudent(int id, String name, String program, String address){
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("studentDB.txt", true));
	        out.write(id + ", " + name + ", " + program + ", " + address + "\n");
	        out.close();
	    }
	    catch (IOException e)
	    {
	        System.out.println("An error occurred :(");

	    }
	}
	
	public static void addCourse(int id, String name, int credits){
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("classDB.txt", true));
	        out.write(id + ", " + name + ", " + credits + "\n");
	        out.close();
	    }
	    catch (IOException e)
	    {
	        System.out.println("An error occurred :(");

	    }
	}
	
	public static void addRegistered(int studentID, int courseID, char grade){
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("registeredDB.txt", true));
	        out.write(studentID + ", " + courseID + ", " + grade + "\n");
	        out.close();
	    }
	    catch (IOException e)
	    {
	        System.out.println("An error occurred :(");

	    }
	}

	public static void main(String[] args) throws IOException {
			
		// populating database
		
		addStudent(26767893, "Mylene Haurie", "CompSci", "123 Sunny ave");
		addStudent(26677266, "LS Carle", "CompSci", "75 Sunset blvd");
		addStudent(28158274, "John Smith", "Engineering", "829 Melrose");
		addStudent(21057289, "Samuel Freedman", "Engineering", "511 3rd ave");
		
		addCourse(353, "Databases", 4);
		addCourse(354, "Intro to Software Engineering", 4);
		addCourse(346, "Operating Systems", 4);
		
		addRegistered(26767893, 353, 'B');
		addRegistered(26677266, 353, 'A');
		addRegistered(21057289, 353, 'D');
		addRegistered(21057289, 354, 'A');
		addRegistered(28158274, 354, 'C');
		addRegistered(26767893, 346, 'C');
		addRegistered(26677266, 346, 'F');
		
		// find the name and grade of every student who took the course Databases
		
		try {	// first find ID of students who took databases
			FileInputStream fstream = new FileInputStream("registeredDB.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			FileInputStream fstream2 = new FileInputStream("studentDB.txt");
			DataInputStream in2 = new DataInputStream(fstream2);
			BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
			String strLine2;
			
			while ((strLine = br.readLine()) != null){
				br2.mark(10000000);
				String[] ar = strLine.split(","); 		// assumming keys are separated from values by a comma
				String studentID = ar[0];
				String courseID = ar[1];
				String grade = ar[2];
				int course = Integer.parseInt(courseID.trim());
			
				
			if (course == 353){
				
				
					while ((strLine2 = br2.readLine()) != null){
						
						int student = Integer.parseInt(studentID.trim());
						String[] ar2 = strLine2.split(",");
						String studentID2 = ar2[0];
						int student2 = Integer.parseInt(studentID2.trim());
						
						if (student == student2){
							System.out.println(ar2[1] + "\t" + grade);
							
					}
						
					}
					
					
			}
			br2.reset();
				
			}
			br.close();
			br2.close();
		}
		catch (Exception e){
			System.err.println("An error occured :(");
		}
	
		
		
	}

}
