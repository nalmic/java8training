package codewars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class RockingRobin implements Iterator<Integer> {
	List<Integer> result = new ArrayList<Integer>();
	int position = -1;
    public RockingRobin(Collection<Iterator<Integer>> collections) {
    	boolean anyMore = true;
    	Iterator<Integer>[] all = collections.toArray(new Iterator[collections.size()]);
    	while (anyMore) {
    		anyMore = false;
    		for (int i=0; i<collections.size();i++) {
    			if(all[i].hasNext()) {
    				result.add(all[i].next());
    				anyMore = true;
    			}
    		}
    	}
    }

    @Override
    public boolean hasNext() {
        return result.size() > 0 && position < result.size()-1;
    }

    @Override
    public Integer next() {
    	if (hasNext() == false) throw new NoSuchElementException();
        return result.get(++position);
    }
}
