package labSerialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListVsSetDemo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1322038405592713464L;
	private final List<ColoredSquare> list;
    private final Set<ColoredSquare> set;

    public ListVsSetDemo(ColoredSquare... elements) {
        list = new ArrayList<>(Arrays.asList(elements));
        set = new HashSet<>(Arrays.asList(elements));
    }

    public String getListElements() {
        StringBuilder sb = new StringBuilder();
        for (ColoredSquare el : list) {
            sb.append(el).append("\n");
        }
        return sb.toString();
    }

    public String getSetElements() {
        StringBuilder sb = new StringBuilder();
        for (ColoredSquare el : set) {
            sb.append(el).append("\n");
        }
        return sb.toString();
    }

    public void addElement(ColoredSquare el) {
        list.add(el);
        set.add(el);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((set == null) ? 0 : set.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ListVsSetDemo))
			return false;
		ListVsSetDemo other = (ListVsSetDemo) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (set == null) {
			if (other.set != null)
				return false;
		} else if (!set.equals(other.set))
			return false;
		return true;
	}
}
