import java.util.HashMap;
import java.util.Map;

public class Optimal_PageReplacement {
    public static void main(String[] args) {
        int[] pages = {8, 4, 2, 5, 4, 7, 4, 1, 8, 5, 2, 1, 4};
        int frames = 3;
        int pageFaults = 0;
        Map<Integer, Integer> memory = new HashMap<>();

        for (int i = 0; i < pages.length; i++) {
            if (!memory.containsKey(pages[i])) {
                if (memory.size() == frames) {
                    int farthest = -1, pageToRemove = -1;
                    for (int page : memory.keySet()) {
                        int nextUse = Integer.MAX_VALUE;
                        for (int j = i + 1; j < pages.length; j++) {
                            if (pages[j] == page) {
                                nextUse = j;
                                break;
                            }
                        }
                        if (nextUse > farthest) {
                            farthest = nextUse;
                            pageToRemove = page;
                        }
                    }
                    memory.remove(pageToRemove);
}
memory.put(pages[i],i);
pageFaults++;
}
}
System.out.println("Total Page Faults:"+pageFaults);
}
}
