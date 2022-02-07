package Trees;
import java.util.*;

public class NaryTreeNode {

    public int val;
    List<NaryTreeNode> children;

    public NaryTreeNode(){
        children = new ArrayList<>();
    }

    public NaryTreeNode(int val){
        this.val = val;
        children = new ArrayList<>();
    }

}
