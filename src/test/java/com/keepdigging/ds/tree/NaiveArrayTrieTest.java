package com.keepdigging.ds.tree;

import com.keepdigging.ds.BaseTest;
import com.keepdigging.ds.tree.trie.NaiveArrayTrie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class NaiveArrayTrieTest extends BaseTest {

    private NaiveArrayTrie trie = null;

    @Before
    public void init()
    {
        trie = new NaiveArrayTrie();
        trie.create(
                Arrays.asList(
                        "his",
                        "him",
                        "her",
                        "she",
                        "hers")
        );
    }

    @Test
    public void testWordsExist()
    {
        Assert.assertTrue(trie.exist("his"));
        Assert.assertFalse(trie.exist("hiss"));
        System.out.println(trie.prefixMatch("h"));
    }

}
