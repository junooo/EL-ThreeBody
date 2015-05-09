package util;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Sissel 可以生成几个元素相同的集合的元素间的随机的一一映射 辅助游戏开始时生成随机的角色和顺序
 */
public class RandomHelper {

	private final int size;
	private List<Object[]> columns;

	public RandomHelper(int size) {
		this.size = size;
		columns = new LinkedList<Object[]>();
	}

	public void addColumn(Object[] column) {
		columns.add(column);
	}

	public Object[][] generate() {
		Object[][] records = new Object[size][columns.size()];
		for (int i = 0; i < columns.size(); i++) {
			Object[] objects = columns.get(i);
			RandomSequence rs = new RandomSequence(size);
			for (Object object : objects) {
				records[rs.next()][i] = object;
			}
		}
		return records;
	}

	/**
	 * 
	 * @author Sissel
	 * 生成元素不重复的数字序列
	 * 原理：随机数random得到随机序号，返回next同时从列表中删除该元素
	 */
	private class RandomSequence {

		List<Integer> nums;
		Random random;

		public RandomSequence(int number) {
			nums = new LinkedList<Integer>();
			for (int i = 0; i < number; i++) {
				nums.add(i);
			}
			random = new Random();
		}

		public int next() {
			int randomIndex = random.nextInt(nums.size());
			int result = nums.get(randomIndex);
			nums.remove(randomIndex);
			return result;
		}

	}
}
