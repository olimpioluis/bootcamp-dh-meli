import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] cities = { "Londres", "Madrid", "Nueva York", "Buenos Aires", "Assuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio" };
        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int lowestTemperatureIndex = 0;
        int highestTemperatureIndex = 0;

        System.out.println(Arrays.deepToString(temperatures));

        for(int i = 1; i < cities.length; i++) {
            if (temperatures[i][0] < temperatures[lowestTemperatureIndex][0]) {
                lowestTemperatureIndex = i;
            }

            if (temperatures[i][1] > temperatures[highestTemperatureIndex][1]) {
                highestTemperatureIndex = i;
            }
        }

        System.out.println("A temperatura mais alta foi em " + cities[highestTemperatureIndex] + ", com " + temperatures[highestTemperatureIndex][1]);
        System.out.println("A temperatura mais baixa foi em " + cities[lowestTemperatureIndex] + ", com " + temperatures[lowestTemperatureIndex][0]);
    }
}
