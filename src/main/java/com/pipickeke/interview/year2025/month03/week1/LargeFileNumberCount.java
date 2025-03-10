package com.pipickeke.interview.year2025.month03.week1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 问题：
 *      如何在内存受限的情况下读取大文本，并且统计文件中每个数字的重复次数
 *      -Xmx10m
 */

public class LargeFileNumberCount {

    public static final String INPUT_DIR = "large_num.txt";
    public static final String TMP_DIR = "tmp_chunks/";
    public static final int MEMO_LIMIT = 10 * 1024 * 1024; //内存限制，10MB
    public static final int CHUNCK_LIMIT = 500000; //每批处理的数字量（可调整）

    public static void main(String[] args) throws FileNotFoundException {
        File tmpDir = new File(TMP_DIR);
        if (!tmpDir.exists()) tmpDir.mkdirs(); //创建临时目录

        List<String> tempFiles = splitAndCount(INPUT_DIR);


    }

    /**
     * 步骤1：逐行统计文件，分块统计并写入临时文件
     * @param filePath
     * @return
     */
    private static List<String> splitAndCount(String filePath) throws FileNotFoundException {

        ArrayList<String> tmpFiles = new ArrayList<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        int currentSize = 0;
        int fileIndex = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;

            while ( (line = reader.readLine()) != null ){
                countMap.put(line, countMap.getOrDefault(line,0)+1);
                currentSize += line.length()+8; //估算 hashmap 占用内存

                //当hashmap 超过内存限制，写入临时文件
                if (currentSize >= MEMO_LIMIT){

                    String tmpfile = TMP_DIR + "chunk_" + (fileIndex++) + ".txt";
                    writeTempFile(tmpfile, countMap);
                    tmpFiles.add(tmpfile);
                    countMap.clear();
                    currentSize = 0;
                }
            }

            //写入剩余数字
            if (!countMap.isEmpty()){
                String tmpfile = TMP_DIR + "chunk_" + (fileIndex++) + ".txt";
                writeTempFile(tmpfile, countMap);
                tmpFiles.add(tmpfile);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tmpFiles;
    }


    /**
     * 步骤2： 合并所有临时文件，并统计结果
     * @param tempFiles
     */
    private static void mergeResult(List<String> tempFiles) throws IOException {
        HashMap<String, Integer> finalCount = new HashMap<>();

        for (String item : tempFiles) {

            try (BufferedReader reader = new BufferedReader(new FileReader(item))){
                String line;

                while ( (line = reader.readLine()) != null ){

                    String[] parts = line.split("\t");
                    String num = parts[0];
                    int count = Integer.parseInt(parts[1]);
                    finalCount.put(num, finalCount.getOrDefault(num,0)+count);
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("final_res.txt"))){
            for (Map.Entry<String, Integer> entry : finalCount.entrySet()) {
                writer.write(entry.getKey()+"\t"+entry.getValue());
                writer.newLine();
            }
        }

        System.out.println("统计完成，结果已经保存到 final_res.txt 文件中");

    }


    /**
     * 将 hashmap 写入临时文件
     * @param filePath
     * @param countMap
     */
    private static void writeTempFile(String filePath, Map<String,Integer> countMap) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){

            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                writer.write(entry.getKey()+"\t"+entry.getValue());
                writer.newLine();
            }
        }
        System.out.println("生成临时文件：" + filePath);
    }
}
