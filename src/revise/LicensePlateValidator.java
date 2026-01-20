package revise;

public class LicensePlateValidator {
    public static void main(String[] args) {
        validatePlate("AB_12BCD3");
    }

    public static void validatePlate(String plate) {
        if(plate == null || plate.isEmpty()) {
            System.out.println("Empty string");
            return;
        }

        if(plate.length() < 6) {
            System.out.println("Invalid length of characters");
            return;
        }

        if(!plate.matches("[A-Za-z0-9\\S-_]+$")) {
            System.out.println("Invalid characters");
            return;
        }

        String plateWithoutSeparators = plate.replaceAll("[\\s-_]", "");

        if(plateWithoutSeparators.length() < 6 || plateWithoutSeparators.length() > 8) {
            System.out.println("Invalid length of characters");
            return;
        }

        if(plateWithoutSeparators.length() == 6) {
            if(!isValidBody(plateWithoutSeparators)) {
                System.out.println("Invalid body");
                return;
            }
            System.out.println(formatMain(plateWithoutSeparators));
        }
        else if (plateWithoutSeparators.length() == 8) {
            String mainBody = plateWithoutSeparators.substring(2);
            String regionCode = plateWithoutSeparators.substring(0,2);
            if(!isValidRegionCode(regionCode) || !isValidBody(mainBody)) {
                System.out.println("Invalid characters");
                return;
            }
            String outputString = plateWithoutSeparators.substring(0,2) + "-" + formatMain(mainBody);
            System.out.println(outputString);
        }
    }

    public static String formatMain(String mainCode) {
        return mainCode.substring(0, 3) + "-" + mainCode.substring(3);
    }

    public static boolean isValidRegionCode(String regionCode) {
        return regionCode.matches("[A-Z]{2}");
    }

    public static boolean isValidBody(String body) {
        if(body.length() < 6) return false;

        int letterCount = 0;
        int numberCount = 0;
        for(char letter : body.toCharArray()) {
            if(Character.isAlphabetic(letter)) letterCount++;
            if(Character.isDigit(letter)) numberCount++;
        }
        return letterCount >= 2 && numberCount >= 2;
    }
}
