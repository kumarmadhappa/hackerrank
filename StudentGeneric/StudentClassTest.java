

public class StudentClassTest {

	public static void main(String[] args)
	{
		StudentClass s=new StudentClass();
		System.out.println(s.getQuery("Raja Ravi Vinay Rahul Arun", "1,r"));
		System.out.println(s.getQuery("Raja Ravi Vinay Rahul Arun", "2,B- AB- B+ O+ B+,B+"));
		System.out.println(s.getQuery("96 78 93 45 90 42 69", "3,90"));
		System.out.println(s.getQuery("90 78 69 45 90 42 69", "4"));
		System.out.println(s.getQuery("6.9 7.3 4.5", "5"));

	}

}
