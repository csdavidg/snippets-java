package com.example.snippets.algorithms;

public class ArraySwitching {
    public int solution(int[] ints) {

        String sql = "with \n" +
                "groups as (\n" +
                "  select count(*) as payments_per_mont, sum(amount) as value from transactions \n" +
                "  where amount < 0\n" +
                "  group by to_char(date, 'MM')\n" +
                "), months_without_fee as (\n" +
                "select count(*) as total from groups where payments_per_mont >=3 and value <= -100 )\n" +
                "\n" +
                "--select (60 - (mwf.total * 5)) as balance from months_without_fee mwf\n" +
                "select (sum(t.amount) - (60 - (mwf.total * 5))) as balance \n" +
                "from transactions t, months_without_fee mwf group by mwf.total\n";

        if(ints.length <= 2){
            return ints.length;
        }

        int even = ints[0];
        int odd = ints[1];
        int cant = 2;
        int max = 2;

        int p = 2;
        for (int i = 3; p < ints.length; p+=2, i+=2) {
            int current = cant;

            if(ints[p] == even){
                cant ++;
            }else {
                even = ints[p];
            }

            if(i < ints.length){
                if(ints[i] == odd){
                    cant ++;
                }else{
                    odd = ints[i];
                }
            }

            if(current == cant){
                cant = 2;
            }

            max = Integer.max(max, cant);

        }

        return max;
    }

    



}
