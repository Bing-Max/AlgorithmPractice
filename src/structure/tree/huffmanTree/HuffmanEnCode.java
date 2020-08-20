package structure.tree.huffmanTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.corba.se.impl.orbutil.ObjectWriter;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;

public class HuffmanEnCode {

	public static void main(String[] args) {

//		String org = "i like like like java do you like a java hhh";
//		byte[] bytes = zip(org.getBytes());
//		System.out.println(new String(gzip(huffmanCodes, bytes)));
//		System.out.println(huffmanCodes);
		
		// 测试压缩文件
		String srcFile = "E://test.txt";
		String desFile = "E://dst.zip";
		String dstFile = "E://test-copy.txt";
		
		zipFile(srcFile, desFile);
		unzipFile(desFile, dstFile);
		System.out.println("文件解压成功");
	}

	/**
	 * 封装获取编码表的操作
	 * 
	 * @param root
	 * @return
	 */
	public static Map<Byte, String> getCodes(EncodeNode root) {
		if (root == null) {
			return null;
		}
		getCodes(root.left, sub, "1");
		getCodes(root.right, sub, "0");
		return huffmanCodes;
	}

	public static List<EncodeNode> getNodes(byte[] chars) {

		List<EncodeNode> list = new ArrayList<EncodeNode>();

		Map<Byte, Integer> map = new HashMap();

		for (byte c : chars) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				int count = map.get(c);
				map.put(c, count + 1);
			}
		}

		for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
			list.add(new EncodeNode(entry.getKey(), entry.getValue()));
		}

		return list;
	}

	private static EncodeNode createHuffmanTree(List<EncodeNode> list) {

		while (list.size() > 1) {
			Collections.sort(list);

			EncodeNode left = list.get(0);
			EncodeNode right = list.get(1);

			EncodeNode parent = new EncodeNode(null, (left.weight + right.weight));
			parent.left = left;
			parent.right = right;

			list.remove(left);
			list.remove(right);

			list.add(parent);
		}

		return list.get(0);
	}

	// 思路：
	// 赫夫曼编码表放在Map<Character, String>的形式
	// 生成赫夫曼编码表时，需要拼接路径，StringBuilder 存储叶子节点的路径
	static StringBuilder sub = new StringBuilder();
	static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();

	/**
	 * 
	 * @param node 开始的节点
	 * @param sub  用于拼接的stringbuilder
	 * @param code 向右 1 向左为0
	 */
	private static void getCodes(EncodeNode node, StringBuilder sub, String code) {

		if (node != null) {
			// 把上边积累的 code 继承下来，继续向下拼接
			StringBuilder sub2 = new StringBuilder(sub);
			// 非叶子节点
			sub2.append(code);

			if (node.data == null) {
				// 向左递归
				getCodes(node.left, sub2, "1");
				// 向右递归
				getCodes(node.right, sub2, "0");
			} else {

				// 否则说明到达了叶子节点
				huffmanCodes.put(node.data, sub2.toString());
			}
		}

	}

	private static byte[] zip(byte[] chars) {
		// 1. 计数
		// getNodes(chars);
		// 2. 创建赫夫曼树
		EncodeNode root = createHuffmanTree(getNodes(chars));
		// 3.创建编码表
		getCodes(root);
		return zip(chars, huffmanCodes);
	}

	/**
	 * 
	 * @param chars        源字符串的字符数组，
	 * @param huffmanCodes 哈夫曼编码表
	 * @return 返回编码结果
	 */
	private static byte[] zip(byte[] chars, Map<Byte, String> huffmanCodes) {
		StringBuilder sub = new StringBuilder();
		for (byte c : chars) {
			sub.append(huffmanCodes.get(c));
		}

		int len;
		if (sub.length() % 8 == 0) {
			len = sub.length() / 8 + 1;
		} else {
			len = sub.length() / 8 + 2;
		}

		byte[] huffmanCodeBytes = new byte[len];
		huffmanCodeBytes[0] = (byte) (sub.length() % 8);
		int index = 1;
		for (int i = 0; i < sub.length(); i += 8) {
			String strByte;

			if (i + 8 < sub.length()) {
				strByte = sub.substring(i, i + 8);

			} else {
				strByte = sub.substring(i);
			}

			huffmanCodeBytes[index++] = (byte) Integer.parseInt(strByte, 2);

		}

		return huffmanCodeBytes;
	}

	// 数据解压
	// 1. byte数组转为二进制字符串
	// 2. 将二进制字符串对照 map转成char[]
	// 3. 返回String

	private static byte[] gzip(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {

		//
		StringBuilder stringBuilder = new StringBuilder();
		// 获取最后一位的长度
		int last = huffmanBytes[0];
//		System.out.println(last);
		// 将byte数组转为二进制字符串
		for (int i = 1; i < huffmanBytes.length; i++) {
			byte b = huffmanBytes[i];

			boolean flag = (i == huffmanBytes.length - 1);
			String str = byteToString(b, !flag);
			if (i == huffmanBytes.length - 1 && str.length() < last) {
				while (str.length() < last) {
					stringBuilder.append("0");
					last--;
				}
			}
			stringBuilder.append(str);
		}
//		System.out.println("byte to String \n" + stringBuilder.toString());
//		System.out.println(stringBuilder.toString());
		Map<String, Byte> map = new HashMap<String, Byte>();
		for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}

		List<Byte> list = new ArrayList<Byte>();
		for (int i = 0; i < stringBuilder.length();) {
			int count = 1;
			boolean flag = true;
			byte b;
			while (flag) {
				String key = stringBuilder.substring(i, i + count);
				if (map.containsKey(key)) {
					b = map.get(key);

					list.add(b);
					i += count;
					flag = false;
				} else {
					count++;
					if ((i + count) > stringBuilder.length()) {
						i = stringBuilder.length();
						break;
					}
				}
			}

		}

		byte[] chars = new byte[list.size()];
		for (int i = 0; i < list.size(); i++) {
			chars[i] = list.get(i);
		}
		return chars;
	}

	/**
	 * 
	 * @param b    待转换的byte
	 * @param flag 是否需要补高位
	 * @return
	 */
	private static String byteToString(byte b, boolean flag) {
		int temp = b;

		if (flag) {
			temp |= 256; // 按位或
		}
		String str = Integer.toBinaryString(temp);

		if (flag) {
			return str.substring(str.length() - 8);
		} else {
			return str;
		}
	}

	public static void zipFile(String src, String des) {
		ObjectOutputStream oos = null;
//		ObjectWriter ow = null;
		OutputStream os = null;
		
//		InputStreamReader isr = null;
		InputStream is = null;
		try {
			is = new FileInputStream(new File(src));
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			
			byte[] huffmanBytes = zip(bytes);
			
			os = new FileOutputStream(new File(des));
			oos = new ObjectOutputStream(os);
			
			oos.writeObject(huffmanBytes);
			oos.writeObject(huffmanCodes);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
		
			try {
//				isr.close();
				is.close();
				oos.close();
				os.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
				
	}

	
	public static void unzipFile(String zipFile, String dstFile) {
		InputStream is = null;
		ObjectInputStream ois = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream(new File(zipFile));
			ois = new ObjectInputStream(is);
			
			//读取byte数组和编码表
			byte[] huffmanBytes = (byte[])ois.readObject();
			
			Map<Byte, String> huffmanCodes = (Map<Byte, String>)ois.readObject();
			
			byte[] bytes = gzip(huffmanCodes, huffmanBytes);
			
			os = new FileOutputStream(new File(dstFile));
			os.write(bytes);
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				os.close();
				ois.close();
				is.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}

class EncodeNode implements Comparable<EncodeNode> {
	Byte data;
	int weight;

	EncodeNode left;
	EncodeNode right;

	public EncodeNode() {
		// TODO Auto-generated constructor stub
	}

	public EncodeNode(Byte data, int weight) {
		super();
		this.data = data;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(EncodeNode o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}

	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}

		if (this.right != null) {
			this.right.preOrder();
		}
	}
}
