public class StudentClass {
    
    
    
    public String getQuery(String studentData,String query){
        String output = "";
        String[] queryData = query.split(",");
        
        switch(queryData[0]) {
        	case "1":
        		StudentList<String> s = new StudentList<>();
        	    s.populateStringData(studentData);
        	    output=s.beginsWith(query);
        	    break;
        	case "2":
        		StudentList<String> s2 = new StudentList<>();
        	    s2.populateStringData(studentData);
        	    output=s2.bloodGroupOf(query);
        	    break;
        	case "3":
        		StudentList<String> s3 = new StudentList<>();
        	    s3.populateStringData(studentData);
        	    output=s3.thresholdScore(query);
        	    break;
        	case "4":
        		ScoreList<Integer> s4 = new ScoreList<>();
        	    s4.populateIntegerData(studentData);
        	    output=s4.averageValues(queryData[0]);
        	    break;
        	case "5":
        		ScoreList<Double> s5 = new ScoreList<>();
        	    s5.populateDoubleData(studentData);
        	    output=s5.averageValues(queryData[0]);
        	    break;
        		
        }
    	
		return output;
		
    }
    
}