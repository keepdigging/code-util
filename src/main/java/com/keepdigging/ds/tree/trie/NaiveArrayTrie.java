package com.keepdigging.ds.tree.trie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class NaiveArrayTrie {

    ////////////////////API接口//////////////////////
    public void create(List<String> wordList)
    {
        if(wordList == null || wordList.isEmpty())
        {
            throw new IllegalArgumentException("illegal argument.");
        }
        Node tmp;
        for (String word : wordList)
        {
            tmp = root;
            for (int j = 0; j<word.length(); j++)
            {

                int idx = word.charAt(j) - 'a';
                if(tmp.children[idx] == null)
                {
                    tmp.children[idx] = new Node(word.charAt(j));
                }
                else
                {
                    tmp.children[idx].num++;
                    tmp.children[idx].isLeaf = false;
                }
                tmp = tmp.children[idx];
            }
            tmp.isLeaf = true;
        }
    }

    /**
     * 匹配前缀
     * @param prefix
     * @return
     */
    public Set<String> prefixMatch(String prefix)
    {
        checkValidate(prefix);

        Node tmp;

        tmp = root;
        for (int j = 0; j<prefix.length(); j++)
        {
            int idx = prefix.charAt(j) - 'a';
            if(tmp.children[idx] == null)
            {
                return null;
            }
            tmp = tmp.children[idx];
        }
        if(tmp == null || tmp.isLeaf)
        {
            return null;
        }

        traverse(tmp, prefix);

        return prefixSet;
    }

    private void traverse(Node node, String prefix)
    {
        if(node == null)
        {
            return;
        }
        if(node.isLeaf)
        {
            prefixSet.add(prefix + node.value);
        }
        else
        {
            for (int j = 0; j<node.children.length; j++)
            {
                traverse(node.children[j], prefix + node.value);
            }
        }
    }

    /**
     * 检查一个单词是否在字典里面
     * @return
     */
    public boolean exist(String word)
    {
        checkValidate(word);

        Node tmp = root;
        for (int j = 0; j<word.length(); j++)
        {
            int idx = word.charAt(j) - 'a';
            if(tmp.children[idx] == null)
            {
                return false;
            }
            tmp = tmp.children[idx];
        }
        return tmp.isLeaf;//最后找到的节点是叶子节点即找到了
    }

    private void checkValidate(String word)
    {
        if(word == null || word.length() == 0)
        {
            throw new IllegalArgumentException("illegal argument.");
        }
    }

    ////////////////////////内部实现/////////////////////////////

    private static final int MAX_SIZE = 26;
    private Node root = new Node();
    private Set<String> prefixSet = new HashSet<String>();

    private static class Node
    {
        private char value;
        private int num;
        private boolean isLeaf;
        private Node[] children = new Node[MAX_SIZE];

        Node(char value)
        {
            this.value = value;
            this.num = 1;
            this.isLeaf = false;
        }

        Node() {}
    }
}
