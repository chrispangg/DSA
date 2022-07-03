class ReverseString {
    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        String s = "abcdefg";
        System.out.println(rs.reverseString(s));
    }
    //reverse a string using StringBuilder
    public String reverseString(String str){
        //check for null and empty string
        if(str == null || str.length() == 0){
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}