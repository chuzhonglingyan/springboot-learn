package com.yuntian;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guangleilei.
 * @date Created in 9:28 2019/11/28
 * @description
 */
public class TestJava {


    public static void main(String[] args) {

        int a=1;
        double b=0.9;
        System.out.println(a-b);
        System.out.println(1-0.9);

        List<String> lineNoList = new ArrayList<>();

        List<String> items = new ArrayList<>();
        for (int i = 0; i <2000; i++) {
            lineNoList.add("" + i);
        }
        int size = lineNoList.size();
        int count=0;
        for (int i = 0; i < size; i = i + 995) {
            if (size >= i + 995) {
                items.addAll(lineNoList.subList(i, i + 995));
            } else {
                items.addAll(lineNoList.subList(i, size));
            }
            count++;
        }
        System.out.println("分割次数："+count);
        System.out.println(items.size());

        System.out.println(" and not exists (select 1 from WM_INV_LOT_LOC viq where CWL.loc_code = viq.loc_code"
                + " and CWL.project_id = viq.project_id and CWL.org_id = viq.org_id )");

    }

    public void  payOrder(){
        //1 查询 status
        if (getPayStatus()==0){
            System.out.println("还未支付了");
            pay();
        }else {
            System.out.println("已经支付了");
        }
    }

    public int  getPayStatus(){

        return  0;
    }

    public void   pay(){
        setPayStatus();
    }

    private void setPayStatus() {
       //生成一条支付流水号
    }


}
