package Trie;

public class Trie {

	//208
	class Node {

		Node children[];
		boolean isWordEnd;

		public Node() {
			children = new Node[26];
			isWordEnd = false;
		}

	}

	Node root;

	public Trie() {
		root = new Node();
	}

	public void insert(String word) {
		Node curr = root;
		int l = word.length();
		int x = 0;
		while (x < l) {
			if (curr.children[word.charAt(x) - 'a'] == null) {
				curr.children[word.charAt(x) - 'a'] = new Node();
			}

			curr = curr.children[word.charAt(x) - 'a'];
			x++;
		}
		curr.isWordEnd = true;
	}

	public boolean search(String word) {
		Node curr = root;
		int l = word.length();
		int x = 0;
		while (x < l) {
			if (curr.children[word.charAt(x) - 'a'] == null) {
				return false;
			}
			curr = curr.children[word.charAt(x) - 'a'];
			x++;
		}
		return curr.isWordEnd;
	}

	public boolean startsWith(String prefix) {
		Node curr = root;
		int l = prefix.length();
		int x = 0;
		while (x < l) {
			if (curr.children[prefix.charAt(x) - 'a'] == null) {
				return false;
			}
			curr = curr.children[prefix.charAt(x) - 'a'];
			x++;
		}
		return true;
	}
}
