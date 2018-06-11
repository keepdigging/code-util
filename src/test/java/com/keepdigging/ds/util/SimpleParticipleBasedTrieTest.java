package com.keepdigging.ds.util;

import com.keepdigging.util.SimpleParticipleBasedTrie;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SimpleParticipleBasedTrieTest {

    private SimpleParticipleBasedTrie participle;

    @Before
    public void init()
    {
        participle = new SimpleParticipleBasedTrie(Arrays.asList(
            "商品", "和服", "服务"
        ));
    }

    @Test
    public void test1()
    {
        List<SimpleParticipleBasedTrie.Word> wordList = participle.participle("商品和服务");
        for (SimpleParticipleBasedTrie.Word word: wordList)
        {
            System.out.println(word.getValue());
        }
    }

}
