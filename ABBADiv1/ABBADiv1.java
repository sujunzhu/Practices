public class ABBADiv1{
    public boolean helper(StringBuilder sb, String obj){
        if(sb.length() == obj.length()){
         	return sb.toString().equals(obj);   
        }
        sb.append('A');
        String sr = sb.reverse().toString();
        if(((obj.indexOf(sb.reverse().toString())!=-1) || obj.indexOf(sr)!=-1) && helper(sb, obj)){
        	sb.deleteCharAt(sb.length() - 1);
         	return true;   
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append('B');
        String s = sb.toString();
        sr = sb.reverse().toString();
        if(((obj.indexOf(s)!=-1) || (obj.indexOf(sr)!=-1)) && helper(sb, obj)){
            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);
			return true;
        }
        sb.reverse();
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }
    
    public String canObtain(String initial, String target){
        StringBuilder sb = new StringBuilder(initial);
        return helper(sb, target) ? "Possible" : "Impossible";
    }
}