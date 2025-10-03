class TextEditor {
    StringBuilder str;
    int curr = 0;
    public TextEditor() {
        str = new StringBuilder("");
    }
    
    public void addText(String text) {
        str.insert(curr,text);
        curr = curr + text.length();
    }
    
    public int deleteText(int k) {
        int sdelete = curr - k;
        int len = str.length();
        if(sdelete>=0){
            str.replace(sdelete,curr,"");   
            curr = curr - k;
        }else{
            str.replace(0,curr,"");
            k = curr;
            curr = 0;
        }
        return k;
    }
    
    public String cursorLeft(int k) {
        curr = curr - k;
        if(curr>=0){
            int min = Math.min(10,str.substring(0,curr).length());
            return str.substring(curr-min,curr);
        }else{
            curr = 0;
        }  
        return "";
    }
    
    public String cursorRight(int k) {
        curr = curr + k;
       // System.out.println("Ewe"+curr+" "+str);
        String ans = "";
        int len  = str.length();
        if(curr<=str.length()-1){
            int min = Math.min(10,str.substring(0,curr).length());
            ans = str.substring(curr-min,curr);
        }else{
            curr = len;
            if(str.length()>=10){
                ans = str.substring(str.length()-10,str.length());
            }else{
                ans = str.substring(0,str.length());
            }
        }   
        return ans;
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */