package AmadeusTest;

class ExistInArray {

    static boolean exists(int[] ints, int k) {
        boolean result = false;

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == k) {
                result = true;
                break;
            }
        }
        return result;
    }
}
