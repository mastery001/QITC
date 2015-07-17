package datastructure.tree;

/**
 * @Description 树的抽象数据类型
 * @author mastery
 * @Date 2015年7月16日下午8:28:13
 * @param <T>
 */
public interface Tree<T> {

	/**
	 * 获得根节点的值
	 * @return
	 */
	T getRoot();
	
	/**
	 * 返回树的深度
	 * @return
	 */
	int deep();

	/**
	 * 返回结点个数
	 * @return
	 */
	int size();
	
	/**
	 * 是否是空树
	 */
	boolean isNullTree();
	
	/**
	 * 显示出树的结构
	 */
	void display();
	

}
