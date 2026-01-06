package search;

import java.util.Iterator;
import java.util.List;

public class MutualRecursion {
    public static boolean hasEmployee(Department department, int targetId) {
        return searchDepartment(department, targetId);
    }

    private static boolean searchDepartment(Department department, int target) {
        if (binarySearch(department.getManagers(), target)) return true;
        if (linearSearch(department.getInterns(), target)) return true;
        return searchChildren(department.getSubdepartments().iterator(), target);
    }

    private static boolean linearSearch(List<Integer> ids, int target) {
        for (int id : ids) {
            if (id == target) return true;
        }
        return  false;
    }

    private static boolean binarySearch(List<Integer> ids, int target) {
        int high = ids.size() - 1;
        int low = 0;
        while (low < high) {
            int mid = low + (high - low) - 1;
            int value = ids.get(mid);

            if (value == target) return true;
            if (value < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    private static boolean searchChildren(Iterator<Department> it, int target) {
        if (!it.hasNext()) return false;
        Department child = it.next();
        if (searchDepartment(child, target)) return true;
        return searchChildren(it, target);
    }
}
