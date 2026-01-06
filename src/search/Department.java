package search;

import java.util.List;

public class Department {
    private String name;
    private List<Integer> interns;
    private List<Integer> managers;
    private List<Department> subdepartments;

    public Department(String name, List<Integer> interns, List<Integer> managers, List<Department> subdepartments) {
        this.name = name;
        this.interns = interns;
        this.managers = managers;
        this.subdepartments = subdepartments;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getInterns() {
        return interns;
    }

    public List<Integer> getManagers() {
        return managers;
    }

    public List<Department> getSubdepartments() {
        return subdepartments;
    }
}
