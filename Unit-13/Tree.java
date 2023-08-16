import java.util.*;
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Tree{
    static TreeNode buildTree(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data:");
        int data=sc.nextInt();
    
        if(data == -1){
            return null;
        }
    
        TreeNode root = new TreeNode(data);
        System.out.println("Enter data for left part of " + data + "Node"); 
        root.left=buildTree();
        System.out.println("Enter data for right part of " + data + "Node"); 
        root.right=buildTree();
    
        return root;
    }
    
    static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);
        q.add(null); //for next line logic

        while(!q.isEmpty()){
            TreeNode temp=q.peek();
            q.poll();

            //for new line after each level logic 
            if(temp==null){
                System.out.println();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            else{
                System.out.print(temp.data+" ");
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
            }
            }
        }
    }
    
    static void inOrderTraversal(TreeNode root){
        //base case:
        if(root == null){
            return;
        }

        //Left -> Node -> Right
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }

    static void preOrderTraversal(TreeNode root){
        //base case:
        if(root == null){
            return;
        }

        //Node -> Left -> Right
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

     static void postOrderTraversal(TreeNode root){
        //base case:
        if(root == null){
            return;
        }

        //Left -> Right -> Node
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    static int heightOfTree(TreeNode root){ //max nodes in one line
        if(root == null){
            return 0;
        }

        int leftheight=heightOfTree(root.left);
        int rightheight=heightOfTree(root.right);
        int ans=max(leftheight,rightheight) + 1;

        return ans;
    }

    static int diameterOfTree(TreeNode root){ //max no. of edge between any 2 nodes of tree not necessary that root will be included
        if(root == null){
            return 0;
        }

        int op1=diameterOfTree(root.left);
        int op2=diameterOfTree(root.right);
        int op3=heightOfTree(root.left)+heightOfTree(root.right);
        int ans=max(op1,max(op2,op3));
        return ans;
    }

    //check if two tress are equal or not
    // static boolean isEqual(TreeNode root1, TreeNode root2){}
    
    // check if two tress are mirror of each other

    public static void main(String[] args){
        TreeNode root=null;
        root=buildTree();
        levelOrderTraversal(root);
    }
}
//different ways to create a tree
//1 using level order traversal i.e insert at lvl 0 then 1 and so on from left to right
//2 using recursion.create a root node than root.left and root.right will be created using recursion 