package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by williamz on 2014/7/16.
 */
public class TestStream {
    public static void main(String[] args) {

        RunSysout();
        RunSysout();
        RunSysout();
        RunSysout();

        long t0 = System.nanoTime();
//初始化一个范围100万整数流,求能被2整除的数字，toArray（）是终点方法
        int a[]= IntStream.range(0, 1_000_000).filter(p -> p % 2==0).toArray();
        long t1 = System.nanoTime();
//和上面功能一样，这里是用并行流来计算
        int b[]=IntStream.range(0, 1_000_000).parallel().filter(p -> p % 2==0).toArray();
        long t2 = System.nanoTime();
//我本机的结果是serial: 0.06s, parallel 0.02s，证明并行流确实比顺序流快

        System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);
    }

    private static void RunSysout() {
        Object[] objList = new Object[]{"1", "2", "3", "4", "110", "23", "55", "77"};
        List<Object> objects = Arrays.asList(objList);

        List<Integer> newList = objects.stream().map(Object::toString).map(Integer::valueOf).sorted().collect(Collectors.toList());
        newList.stream().forEach(i -> System.out.println("Val: " + i));
        int count = 0;
        List<String> strings = Arrays.asList("a", "b", "c");
        strings.forEach(s -> {
            int i = count + 1;
            System.out.println(i);
        });
    }
}