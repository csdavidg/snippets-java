package com.example.snippets.files;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilesClassifierTest {

    @Test
    public void firstTest(){

        FilesClassifier target = new FilesClassifier();

        List<File> files = new ArrayList<>();
        files.add(new File("file1.txt", 100, Group.COLLECTION_1));
        files.add(new File("file2.txt", 100, Group.COLLECTION_2));
        files.add(new File("file3.txt", 100, Group.COLLECTION_1));
        files.add(new File("file4.txt", 100, Group.NONE));

        Map<Long, List<String>> result = target.classifyFiles(files, 1);

        assertEquals(Map.of(400L, List.of("COLLECTION_1")), result);

        files = new ArrayList<>();
        files.add(new File("file1.txt", 100, Group.COLLECTION_1));
        files.add(new File("file33.txt", 300, Group.COLLECTION_2));
        files.add(new File("file2.txt", 100, Group.COLLECTION_2));
        files.add(new File("file3.txt", 100, Group.COLLECTION_1));
        files.add(new File("file4.txt", 100, Group.NONE));

        result = target.classifyFiles(files, 1);

        assertEquals(Map.of(700L, List.of("COLLECTION_2")), result);

    }

}
