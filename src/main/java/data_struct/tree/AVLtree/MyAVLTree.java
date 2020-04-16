package data_struct.tree.AVLtree;

import java.util.LinkedList;
import java.util.Queue;
 /**
  * 平衡二叉查找树
  *
   * @author lyy
   */
public class MyAVLTree {

	private AVLNode root;
	private final int LEFT = 1;
	private final int RIGHT = -1;
	private final int MAX_LEFT = 2;
	private final int MAX_RIGHT = -2;
	
	/**
	 * 插入节点
	 * @param data
	 */
	public void put(int data) {
		putData(root, data);
	}
	
	private boolean putData(AVLNode node, int data) {
		if(node == null) {
			node  = new AVLNode(data);
			root = node;
			return true;
		}
		int t;
		AVLNode p;
		AVLNode temp = node;
		do {
			p = temp;
			t = temp.data - data;
			if(t < 0) {
				temp = temp.rightChild;
			}
			else if(t > 0) {
				temp = temp.leftChild;
			}
			else {
				return false;
			}
		} while(temp != null);
		
		if(t < 0) {
			p.rightChild = new AVLNode(p, data);
		}
		else if(t > 0) {
			p.leftChild = new AVLNode(p, data);
		}
		rebuild(p);
		return true;
		
	}
	
	/**
	 * 将二叉树平衡
	 * @param node
	 */
	public void rebuild(AVLNode node) {
		while(node != null) {
			if(calcNodeBalanceValue(node) == MAX_LEFT) {
				fixAfterInsertion(node, LEFT);
			}
			else if(calcNodeBalanceValue(node) == MAX_RIGHT) {
				fixAfterInsertion(node, RIGHT);
			}
			node = node.parent;
		}
	}
	
	
	/**
	 * 调整树的结构
	 * @param node
	 * @param type
	 */
	public void fixAfterInsertion(AVLNode node, int type) {
		if(type == LEFT) {
			AVLNode leftChild = node.leftChild;
			if(leftChild.leftChild != null) {  //右旋
				rightRotation(node);
			}
			else if(leftChild.rightChild != null) {   //左右旋
				leftRotation(leftChild);
				rightRotation(node);
			}
		}
		else if(type == RIGHT) {
			AVLNode rightChild = node.rightChild;
			if(rightChild.rightChild != null) {   //左旋
				leftRotation(node);
			}
			else if(rightChild.leftChild != null) {   //右左旋
				rightRotation(rightChild);
				leftRotation(node);
			}
		}
	}
	
	
	/**
	 * 右旋
	 * @param node
	 * @return
	 */
	public AVLNode rightRotation(AVLNode node) {
		if(node != null) {
			
			AVLNode leftChild = node.leftChild;
			node.leftChild = leftChild.rightChild;
			// 如果leftChild的右节点存在，则需将该右节点的父节点指给node节点
			if(leftChild.rightChild != null) {  
				leftChild.rightChild.parent = node;
			}
			leftChild.parent = node.parent;
			if(node.parent == null) {
				this.root = leftChild;
			}
			else if(node.parent.rightChild == node) {  // 即node节点在它原父节点的右子树中
				node.parent.rightChild = leftChild;
			}
			else if(node.parent.leftChild == node) {
				node.parent.leftChild = leftChild;
			}
			
			leftChild.rightChild = node;
			node.parent = leftChild;
			return leftChild;
		}
		
		return null;
	}
	
	/**
	 * 左旋
	 * @param node
	 * @return
	 */
	public AVLNode leftRotation(AVLNode node) {
		
		if(node != null) {
			AVLNode rightChild = node.rightChild;
			node.rightChild = rightChild.leftChild;
			if(rightChild.leftChild != null) {
				rightChild.leftChild.parent = node;
			}
			rightChild.parent = node.parent;
			if(node.parent == null) {
				this.root = rightChild;
			}
			else if(node.parent.rightChild == node) {
				node.parent.rightChild = rightChild;
			}
			else if(node.parent.leftChild == node) {
				node.parent.leftChild = rightChild;
			}
			rightChild.leftChild = node;
			node.parent = rightChild;
			return rightChild;
		}
		
		return null;
	}
	
	/**
	 * 计算node节点的BF值
	 * @param node
	 * @return
	 */
	public int calcNodeBalanceValue(AVLNode node) {
		if(node != null) {
			return getHeightByNode(node);
		}
		return 0;
	}
	
	private int getHeightByNode(AVLNode node) {
		if(node == null) {
			return 0;
		}
		return getChildDepth(node.leftChild) - getChildDepth(node.rightChild);
	}
	
	private int getChildDepth(AVLNode node) {
		if(node == null) {
			return 0;
		}
		return 1 + Math.max(getChildDepth(node.leftChild), getChildDepth(node.rightChild));
	}
	
	
	/**
	 * 中序遍历
	 */
	public void middOrderErgodic() {
		this.middOrderErgodic(this.root);
	}
	public void middOrderErgodic(AVLNode node) {
		if(node != null) {
			this.middOrderErgodic(node.leftChild);
			System.out.print(node.data + ", ");
			this.middOrderErgodic(node.rightChild);
		}
	}
	
	
	/**
	 * 删除指定val值的节点
	 * @param val
	 * @return
	 */
	public boolean delete(int val) {
		AVLNode node = getNode(val);
		if(node == null) {
			return false;
		}
		boolean flag = false;
		AVLNode p = null;
		AVLNode parent = node.parent;
		AVLNode leftChild = node.leftChild;
		AVLNode rightChild = node.rightChild;
		if(leftChild == null && rightChild == null) {
			if(parent != null) {
				if(parent.leftChild == node) {
					parent.leftChild = null;
				}
				else if(parent.rightChild == node) {
					parent.rightChild = null;
				}
			}
			else {
				this.root = null;
			}
			
			p = parent;
			node = null;
			flag = true;
		}
		else if(leftChild == null && rightChild != null) {
			if(parent != null && parent.data > val) {
				parent.leftChild = rightChild;
			}
			else if(parent != null && parent.data < val) {
				parent.rightChild = rightChild;
			}
			else {
				this.root = rightChild;
			}
			p = parent;
			node = null;
			flag = true;
		}
		else if(leftChild != null && rightChild == null) {
			if(parent != null &&  parent.data > val) {
				parent.leftChild = leftChild;
			}
			else if(parent != null && parent.data < val) {
				parent.rightChild = leftChild;
			}
			else {
				this.root = leftChild;
			}
			
			p = parent;
			node = null;
			flag = true;
		}
		else if(leftChild != null && rightChild != null) {
			AVLNode successor = getSuccessor(node);
			int tempData = successor.data;
			if(delete(tempData)) {
				node.data = tempData;
			}
			p = successor;
			successor = null;
			flag = true;
		}
		
		if(flag) {
			this.rebuild(p);
		}
		return flag;	
	}
	
	
	/**
	 * 获得指定节点
	 * @param key
	 * @return
	 */
	public AVLNode getNode(int key) {
	
		AVLNode node = root;
		int t;
		do {
			t = node.data - key;
			if(t > 0) {
				node = node.leftChild;
			}
			else if(t < 0) {
				node = node.rightChild;
			}
			else {
				return node;
			}
		} while(node != null);
		return null;
	}
	
	
	/***
	 * 获得指定节点的后继
	 * 找到node节点的后继节点
     * 1、先判断该节点有没有右子树，如果有，则从右节点的左子树中寻找后继节点，没有则进行下一步
     * 2、查找该节点的父节点，若该父节点的右节点等于该节点，则继续寻找父节点，
     *   直至父节点为Null或找到不等于该节点的右节点。
     * 理由，后继节点一定比该节点大，若存在右子树，则后继节点一定存在右子树中，这是第一步的理由
     *      若不存在右子树，则也可能存在该节点的某个祖父节点(即该节点的父节点，或更上层父节点)的右子树中，
     *      对其迭代查找，若有，则返回该节点，没有则返回null
	 * @param node
	 * @return
	 */
	public AVLNode getSuccessor(AVLNode node) {
		if(node.rightChild != null) {
			AVLNode rightChild=  node.rightChild;
			while(rightChild.leftChild != null) {
				rightChild = rightChild.leftChild;
			}
			return rightChild;
		}
		AVLNode parent = node.parent;
		while(parent != null && (node == parent.rightChild)) {
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	
	/**
	 * 层序遍历
	 */
	public void sequenceErgodic() {
		if(this.root == null) {
			return;
		}
		Queue<AVLNode> queue = new LinkedList<>();
		AVLNode temp = null;
		queue.add(this.root);
		while(!queue.isEmpty()) {
			temp = queue.poll();
			System.out.println("当前节点值：" + temp.data + ", BF：" + calcNodeBalanceValue(temp));
			if(temp.leftChild != null) {
				queue.add(temp.leftChild);
			}
			if(temp.rightChild != null) {
				queue.add(temp.rightChild);
			}
		}
	}
	
	public static void main(String[] args) {
		MyAVLTree bbt = new MyAVLTree();
        bbt.put(3);
        bbt.put(2);
        bbt.put(1);
        bbt.put(4);
        bbt.put(5);
        bbt.put(6);
        bbt.put(7);
        bbt.put(10);
        bbt.put(9);
        bbt.middOrderErgodic();
        System.out.println();
        System.out.println("-----各节点平衡状况-----");
        bbt.sequenceErgodic();
        System.out.println();
        bbt.delete(5);
        bbt.delete(2);
        bbt.middOrderErgodic();
        System.out.println();
        System.out.println("-----各节点平衡状况-----");
        bbt.sequenceErgodic();
        System.out.println();
        
	}
}