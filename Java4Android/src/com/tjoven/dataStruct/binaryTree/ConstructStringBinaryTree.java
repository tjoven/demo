package com.tjoven.dataStruct.binaryTree;

import java.util.Stack;

public class ConstructStringBinaryTree {

	public static void main(String[] args) {
		String restult = tree2str2(TreeNodeBuild.get());
		System.out.println(restult);
		
	}
	/**
	 * 自己构建stack实现
	 * @param t
	 * @return
	 */
	private static String tree2str2(TreeNode t){
		if(t==null){
			return "";
		}
		StringBuffer buffer = new StringBuffer();
		Stack<Object> stack = new Stack<Object>();
		stack.push(t);
		
		while(!stack.isEmpty()){
			Object object = stack.pop();
			if(object instanceof TreeNode){
				TreeNode node = (TreeNode)object;
				buffer.append(node.val+"");
				if(node.right==null && node.left == null){
					continue;
				}
				if(node.right!=null){
					stack.push(")");
					stack.push(node.right);
					stack.push("(");
				}
				if(node.left!=null){
					stack.push(")");
					stack.push(node.left);
					stack.push("(");
				}else if(node.left == null){
					stack.push(")");
					stack.push("(");
				}
			}else if(object instanceof String){
				buffer.append(object);
			}
			
		}
		return buffer.toString();
		
	}
	
	/**
	 * 递归实现
	 * @param t
	 * @return
	 */
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
