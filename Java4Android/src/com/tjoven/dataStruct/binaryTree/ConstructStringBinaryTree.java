package com.tjoven.dataStruct.binaryTree;

public class ConstructStringBinaryTree {

	public static void main(String[] args) {
		String restult = tree2str(null);
		System.out.println(restult);
	}
    public static String tree2str(TreeNode t) {
        if(t==null){
            return "";
        }
        StringBuffer b = new StringBuffer(t.val+"");
        String l = tree2str(t.left);
        String r = tree2str(t.right);
      
        if(!l.equals("") || !r.equals("")){
            b.append("("+l+")");
            
            if(r!=""){
                b.append("("+r+")");
            }
            
        }
        return b.toString();
        
    }
}
