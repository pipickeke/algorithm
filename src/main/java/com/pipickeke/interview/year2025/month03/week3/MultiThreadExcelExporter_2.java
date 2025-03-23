package com.pipickeke.interview.year2025.month03.week3;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 *
 * 问题：
 *      如何利用Java多线程导出百万行数据到Excel，不能OOM
 *
 */

public class MultiThreadExcelExporter_2 {


    public static final int ROWS_PER_SHEET = 100_000;
    public static final int THREAD_COUNT = 5;
    public static final int TOTAL_ROWS = 1_000_000;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        //1, 只保留1k行在内存，避免OOM
        SXSSFWorkbook workbook = new SXSSFWorkbook(1000);
        workbook.setCompressTempFiles(true); //启用临时文件压缩

        //2 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        ArrayList<Future<Void>> futures = new ArrayList<>();

        //3,
        int sheetCount = (TOTAL_ROWS+ROWS_PER_SHEET-1) / ROWS_PER_SHEET;
        for (int i = 0; i < sheetCount; i++) {
            final int sheetIndex = i;
            Future<Void> future = executor.submit(() -> {
                expertSheet(workbook, sheetIndex);
                return null;
            });
            futures.add(future);
        }

        //4，等待所有线程完成
        for (Future<Void> future : futures) {
            try {
                future.get();
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
            } catch (ExecutionException e) {
                //throw new RuntimeException(e);
            }
        }

        //5, 关闭
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        //6，保存文件
        try (FileOutputStream fos = new FileOutputStream("large_excel.xlsx")) {
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
        } catch (IOException e) {
            //throw new RuntimeException(e);
        }

        //7, 释放临时文件
        workbook.dispose();
        long end = System.currentTimeMillis();
        System.out.println("Excel 导出完成，耗时： " + (end-start) + " 毫秒");
    }


    private static void expertSheet(SXSSFWorkbook workbook, int sheetIndex){
        String sheetName = "Sheet" + (sheetIndex+1);
        SXSSFSheet sheet = workbook.createSheet(sheetName);
        System.out.println(Thread.currentThread().getName()+" 处理 "+sheetName);

        int startRow = sheetIndex * ROWS_PER_SHEET;
        int endRow = Math.min(startRow + ROWS_PER_SHEET, TOTAL_ROWS);

        for (int i = startRow; i < endRow; i++) {
            Row row = sheet.createRow(i - startRow);
            for (int j = 0; j < 5; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue("数据-"+ (i+1) +"-" + (j+1) );
            }
        }
    }
}
