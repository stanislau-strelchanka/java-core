package chap11.threads.deadlocks;

import java.util.ArrayList;
import java.util.List;


public class TreeNode {

    TreeNode parent = null;
    List children = new ArrayList();

    public synchronized void addChild(TreeNode child){

        if(!this.children.contains(child)){
            this.children.add(child);
            System.out.println("setting parent");
            child.setParentOnly(this);
            System.out.println("setting parent - ok");
        }
    }

    private synchronized void addChildOnly(TreeNode child) {

        if(!this.children.contains(child)){
            this.children.add(child);
        }
    }

    public synchronized void setParent(TreeNode parent){
        this.parent = parent;
        System.out.println("adding child");
        parent.addChildOnly(this);
        System.out.println("adding child - ok");
    }

    private synchronized void setParentOnly(TreeNode parentOnly) {
        this.parent = parentOnly;
    }
}
