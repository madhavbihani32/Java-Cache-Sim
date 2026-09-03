package cpu_cache_sim;

public class Main {
    public static void main(String[] args) {

        MainMemory memory = new MainMemory();

        memory.write(0, (byte)10);
        memory.write(1, (byte)20);
        memory.write(2, (byte)30);
        memory.write(3, (byte)40);

        memory.write(16, (byte)50);
        memory.write(17, (byte)60);
        memory.write(18, (byte)70);
        memory.write(19, (byte)80);

        Cache cache = new Cache();

//        System.out.println(cache.DataFetch(0, memory));
//        System.out.println(cache.DataFetch(1, memory));
//        System.out.println(cache.DataFetch(2, memory));
//        System.out.println(cache.DataFetch(3, memory));
//
//        System.out.println(cache.DataFetch(16, memory));
        
        System.out.println(cache.DataFetch(0, memory));
        System.out.println(cache.DataFetch(16, memory));
        System.out.println(cache.DataFetch(0, memory));
        System.out.println(cache.DataFetch(16, memory));

        System.out.println(cache.DataFetch(0, memory));
        System.out.println(cache.DataFetch(16, memory));
        System.out.println(cache.hits);
        System.out.println(cache.total);
    }

}
