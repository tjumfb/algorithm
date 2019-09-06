package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
//  使用方法：
//  先输入路径
//        5
//        0 1
//        0 2
//        1 3
//        1 4
//  然后直接输入需要判断的a,b,c

public class LoveStory {
    private static int count = 0;
    private static ArrayList<LinkedList<Integer>> nodes;
    private static int[] inTime;
    private static int[] outTime;

//      读路径
    private static int[] readInt(String s){
        String[] nums = s.split(" ");
        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);
        return (a > b?new int[]{b,a}: new int[]{a,b});
    }
//    读ABC
    private static int[] readPath(String s){
        String[] nums = s.split(" ");
        return new int[]{Integer.parseInt(nums[0]),Integer.parseInt(nums[1]),Integer.parseInt(nums[2])};
    }
//    判断nums[2]是否为num[1]、nums[0]公共祖先
    private static boolean isParent(int[] nums){
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        // c是a,b的最近公共祖先
        return inTime[c] <= Math.min(inTime[b],inTime[a]) && outTime[c] >= Math.max(outTime[a],outTime[b]);
    }
//    判断abc是否呈现acb或bca
    private static boolean isSequence(int[] nums){
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        // c在a,b之间,f1为a - c - b形式，f2为b - c - a形式
        boolean f1 = (inTime[c] <= inTime[b]&&outTime[c]>=outTime[b])&&(inTime[a] <= inTime[c]&&outTime[a]>=outTime[c]);
        boolean f2 = (inTime[c] <= inTime[a]&&outTime[c]>=outTime[a])&&(inTime[b] <= inTime[c]&&outTime[b]>=outTime[c]);
        return f1||f2;
    }

    //  填出入栈时间
    private static void constructTime(int index,LinkedList<Integer> root){
        inTime[index] = count;
        count++;
        for(int i: root){
            constructTime(i,nodes.get(i));
        }
        outTime[index] = count;
        count++;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();

        //  临接链表
        nodes = new ArrayList<>();
        for(int i = 0; i < size; i++){
            nodes.add(new LinkedList<>());
        }
        //  存出出入栈时间
        inTime = new int[size];
        outTime = new int[size];

        // 构造树
        for(int i = 0; i < size-1; i++){
            int[] temp = readInt(scanner.nextLine());
            nodes.get(temp[0]).add(temp[1]);
        }
        constructTime(0,nodes.get(0));

//        c为a,b公共祖先，且c的子节点都不是a,b公共祖先
        String path;
        while (!(path = scanner.nextLine()).equals("0")){
            int[] numbs = readPath(path);
            if(isSequence(numbs)) System.out.println("Yes");
            else if(isParent(numbs)){
                boolean flag = true;
                for(int i:nodes.get(numbs[2])){
                    int[] temp = numbs.clone();
                    temp[2] = i;

                    if(isParent(temp)){
                        System.out.println("No");
                        flag = false;
                        break;
                    }
                }
                if(flag) System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }

    }
}
