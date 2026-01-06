package search;

import java.util.List;

public class SearchOffice {
    public static void main(String[] args) {
        Department techSupport = new Department("Tech Support", List.of(88), List.of(900, 950), List.of());
        Department tech = new Department("Tech", List.of(99), List.of(700, 750, 800), List.of(techSupport));
        Department marketing = new Department("Marketing", List.of(55, 12), List.of(601, 602, 603), List.of());
        Department headOffice = new Department(
                "Head Office",
                List.of(902, 14, 7),
                List.of(500),
                List.of(marketing, tech)
        );

        System.out.println("Has Employee : " + EmployeeSearch.hasEmployee(headOffice, 500));
    }
}
