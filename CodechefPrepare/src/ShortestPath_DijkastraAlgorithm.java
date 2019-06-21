import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestPath_DijkastraAlgorithm {
    static class node{
        int a,b;
        node(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    static Comparator<node> nodeComparator=new Comparator<node>() {
        @Override
        public int compare(node o1, node o2) {
            if (o1.a==o2.a){
                return o1.b-o2.b;
            }
            return o1.a-o2.a;
        }
    };
    static class pair{
        int key,value;

        pair(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int test=in.nextInt();
        while(test-- >0){
            int n=in.nextInt();
            HashMap<String ,Integer> cityIndex=new HashMap<>();
            HashMap<Integer,ArrayList<pair>> map=new HashMap<>();
            for (int i=1;i<=n;i++){
                cityIndex.put(in.next(),i);
                int m=in.nextInt();
                ArrayList<pair> connectedCities=new ArrayList<>();
                for (int j=0;j<m;j++){
                    connectedCities.add(new pair(in.nextInt(),in.nextInt()));
                }
                map.put(i,connectedCities);
            }
            int q=in.nextInt();
            StringBuilder builder=new StringBuilder();
            for (int i=0;i<q;i++){
                builder.append(query(map,cityIndex,in.next(),in.next())).append("\n");
            }
            System.out.println(builder);
        }
    }
    public static int query(HashMap<Integer, ArrayList<pair>> map, HashMap<String, Integer> cityIndex, String start, String end) {
        int[] distance=new int[cityIndex.size()+1];
        for (int i:cityIndex.values()){
            distance[i]=Integer.MAX_VALUE;
        }
        int srcCityIndex=cityIndex.get(start);
        distance[srcCityIndex]=0;

        PriorityQueue<node> pq=new PriorityQueue<>(nodeComparator);
        for (int i:cityIndex.values()){
            if (i==cityIndex.get(start)) continue;
            pq.add(new node(Integer.MAX_VALUE,i));
        }
        pq.add(new node(0,srcCityIndex));
        while (!pq.isEmpty()){
            // now try to relax all the Source city neighbours!
            node currentCity=pq.poll();
            if (cityIndex.get(end).equals(currentCity.b)){
                return currentCity.a;
            }
            for (pair k :map.get(currentCity.b)){
                if ((distance[k.key])>(distance[currentCity.b]+k.value)){
                    pq.remove(new node(distance[k.key],k.key));
                    distance[k.key]=(distance[currentCity.b]+k.value);
                    pq.add(new node(distance[k.key],k.key));
                }
            }
        }
        return distance[cityIndex.get(end)];
    }
}
