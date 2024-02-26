import java.io.*;
import java.util.*;

public class examFilan{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		String filename;
		int ch;
		
		do{
			Menu();
			ch = sc.nextInt();
			
			switch(ch)
			{
				case 1: // creating file
				System.out.println("Enter file name :");
				filename = sc.next();
				try{
					CreateingFile(filename);					
				}catch(IOException e){
					System.out.println("Erorr creating file.");
				}
				break;
				
				case 2: // add Studentdata
				System.out.println("Enter file name");
				filename = sc.next();
				System.out.println("Enter  id");
				String id = sc.next();
				System.out.println("Enter  name");
				String name = sc.next();
				System.out.println("Enter ClassN name");
				String ClassN = sc.next();
				try{
					AddStudentdata(filename,id,name,ClassN);
				}catch(IOException e){
					System.out.println("Erorr in the file.");
				}
				break;
				
				case 3:  // displye data
				System.out.println("Enter file name");
				filename = sc.next();
				try{
					DisplyeFile(filename);
				}catch(IOException e){
					System.out.println("File erorr in file");
				}
				break;
				
				default:
				System.out.println("unvalid input");
				break;
			}
		}while(ch != 4);
		sc.close();
	}
	
	private static void Menu()
	  {
		  System.out.println("1.Crate file.");
		  System.out.println("2.Add data.");
		  System.out.println("3.Displye data.");
		  System.out.println("4.Exit.");
	  }
	  
	  // creatin file
	  private static void CreateingFile(String filename)throws IOException{
		  File file = new File(filename);
		  if(file.createNewFile())
		    {
				System.out.println("File Successfull creating.");
			}
			else if(file.exists())
			{
				System.out.println("File Allready exists.");
			}
			else{
				System.out.println("file not createing");
			}
	  }
	  // Add Student data
	  private static void AddStudentdata(String filename,String id,String name,String ClassN)throws IOException{
		  File file = new File(filename);
		  if(file.exists())
		      {
				  BufferedWriter w = new BufferedWriter(new FileWriter(file,true));
				  w.write(id+","+name+","+ClassN+"\n");
				  w.close();
			  }
			 // System.out.println("");
	  }
	  
	  // Displye data
	  private static void DisplyeFile(String filename)throws IOException{
		  File file = new File(filename);
		  if(file.exists())
		  {
			  BufferedReader r = new BufferedReader(new FileReader(file));
			  String line;
			  boolean found = false;
			  System.out.println("id\tname\tClassN");
			  while((line = r.readLine())!=null)
			  {
				  String[]p= line.split(",");
				  System.out.println(p[0]+"\t"+p[1]+"\t"+p[2]);
		//        System.out.println(p[0] + "\t" + p[1]);

			  }
			  r.close();
		  }
		  else{
			  System.out.println("File not exists.");
		  }
	  }
	  
}














