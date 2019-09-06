package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Edge{
    double val;
    String name;
    Edge(String name, double val){
        this.val = val;
        this.name = name;
    }
    @Override
    public boolean equals(Object o){
        if(o.getClass() == this.getClass()){
            Edge e = (Edge)o;
            return e.name.equals(this.name);
        }
        return false;
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }
}
public class le399 {
    HashMap<String,HashSet<Edge>> table = new HashMap<>();
    HashMap<String,Boolean> visited = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[equations.size()];
        for (int i = 0; i < equations.size(); i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            visited.put(a,false);
            visited.put(b,false);
            table.computeIfAbsent(a, k -> new HashSet<>()).add(new Edge(b,values[i]));
            table.computeIfAbsent(b, k -> new HashSet<>()).add(new Edge(a,1/values[i]));
        }

        for(int i = 0; i < queries.size(); i++){
            res[i] = DFS(queries.get(i).get(0),queries.get(i).get(1),1);
            for(String s:visited.keySet()){
                visited.put(s,false);
            }
            System.out.println(res[i]);
        }

        return null;
    }
    public double DFS(String cur,String want, double mul){
        if(cur.equals(want)) return 1;
        if(table.get(want)==null) return -1;
        if(!visited.get(cur)){
            double res = -1;
            visited.put(cur,true);
            for(Edge e:table.get(cur)){
                if(e.name.equals(want)){
                    return mul*e.val;
                }else{
                    res = Math.max(DFS(e.name,want,mul*e.val),res);
                }
            }
            return res;
        }
        else return -1;
    }

    public static void main(String[] args) {
       List<List<String>> equations = new ArrayList<>();
       ArrayList<String> s = new ArrayList<>();
       s.add("a"); s.add("b");
       equations.add(s);
       ArrayList<String> s1 = new ArrayList<>();
       s1.add("b"); s1.add("c");
       equations.add(s1);

        List<List<String>> queris = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        s2.add("a");s2.add("c");
        queris.add(s2);
       new le399().calcEquation(equations,new double[]{2.0,3.0},queris);
    }

}
