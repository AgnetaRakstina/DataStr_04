package datastr;

public class MyBST<Ttype> { //my binary search tree
	
	private MyNode<Ttype> rootNode = null;
	private int howManyElements = 0;
	
	public int getHowManyElements() {
		return howManyElements;
	}
	
	//bezargumenta konstruktors bus no object klases
	
	public boolean isEmpty() {
		return (howManyElements == 0);
	}
	
	public boolean isFull() {
		try {
			new MyNode<Character>('A');
			return false;
			
		} catch (OutOfMemoryError error) {
			return true;
		}
	}
	
	public void add(Ttype element) throws Exception {
		if (isFull()) {
			throw new Exception ("Koks ir pilens un nevar vairs pievienot jauus elementus");
		}
		
		if (isEmpty()) {
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			rootNode = newNode;
		} else {
			addHelper(rootNode, element);
		}
		
		howManyElements--;
	}
	
	private void addHelper(MyNode<Ttype> nodeTemp, Ttype element) {
		if (nodeTemp != null) {
			
			if (((Comparable)element).compareTo(nodeTemp.getElement()) >0) {
				addHelper(nodeTemp.getRightChNode(), element);
				
				if (nodeTemp.getRightChNode() == null) {
					MyNode<Ttype> newNode = new MyNode<Ttype>(element);
					newNode.setParentNode(nodeTemp);
					nodeTemp.setRightChNode(newNode);
				}
				
				
			} else {
				
				if(nodeTemp.getLeftChNode() == null) {
					MyNode<Ttype> newNode = new MyNode<Ttype>(element);
					newNode.setParentNode(nodeTemp);
					nodeTemp.setLeftChNode(newNode);
				} else {
					
					addHelper(nodeTemp.getLeftChNode(), element);
					
				}
				
				addHelper(nodeTemp.getLeftChNode(), element);
			}
			//TODO pabeigt funkciju
		}
	}
	
}
