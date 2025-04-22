package flik;

public class HorribleSteve {
    public static void main(String [] args) throws Exception {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                if (i == j)
                {
                    System.out.println("i等于j，经过检验是正确的");
                }
                if (Flik.isSameNumber(i, j))
                {
                    System.out.println("i等于j,源式子应该是false");
                }
                throw new Exception(
                        String.format("i:%d not same as j:%d ??", i, j));
            }
        }
        System.out.println("i is " + i);
    }
}
