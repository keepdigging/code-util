package com.keepdigging.util;

import java.util.ArrayList;
import java.util.List;

/**
 * based-on trie, participle
 *
 * 选择链表而不是数组
 *
 * http://www.hankcs.com/program/java/tire-tree-participle.html
 *
 */
public class SimpleParticipleBasedTrie {

    public SimpleParticipleBasedTrie(List<String> wordList)
    {
        Node tmp;
        for (String word : wordList) {
            tmp = rootNode;
            for (char ch : word.toCharArray()) {
                if(tmp.children[ch] == null)
                {
                    Node node = new Node(ch);
                    tmp.children[ch] = node;
                }
                else
                {
                    tmp.children[ch].num++;
                }
                tmp = tmp.children[ch];
            }
            tmp.isLeaf = true;
        }
    }

    /**
     * TODO 没有完成
     * @param content
     * @return
     */
    public List<Word> participle(String content)
    {
        List<Word> participleList = new ArrayList<Word>();

        Node tmp = rootNode;
        int lastIndex = 0;
        for (int j = 0; j<content.toCharArray().length; j++)
        {
            char ch = content.toCharArray()[j];
            if(tmp.children[ch] == null)
            {
                return null;
            }
            if(tmp.children[ch].isLeaf)
            {
                Word word = new Word();
                char[] chars = new char[j-lastIndex];
                System.arraycopy(content.toCharArray(),lastIndex, chars, 0, j-lastIndex);
                word.setValue(chars);
                participleList.add(word);
            }
        }

        return participleList;
    }

    ///////////////////////////////////////////////
    private static final int MAX_SIZE = 65536;
    private Node rootNode = new Node();

    private static class Node
    {
        public char value;
        public int num;
        public boolean isLeaf;
        public Node[] children;

        Node(char value)
        {
            this.value = value;
            this.isLeaf = false;
            num = 1;
            children = new Node[MAX_SIZE];
        }

        Node()
        {
            children = new Node[MAX_SIZE];
        }
    }

    public static class Word
    {
        private char[] value;

        public String getValue() {
            return new String(value);
        }
        public void setValue(char[] value) {
            this.value = value;
        }
    }
}
