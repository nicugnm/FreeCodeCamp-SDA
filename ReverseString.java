public class ReverseString {
    private static void reversedString(String str) {
        var list = str.toCharArray();
        for (int i = list.length - 1; i >= 0; i--) {
            System.out.print(list[i] + " ");
        }
    }

    public static void main(String[] args) {
        reversedString("Salutare");
        reversedString("");
    }
}
