package com.xy.vmes.common.util;

import org.apache.commons.lang.StringUtils;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Scanner;

/**
 * Created by 46368 on 2018/12/19.
 */
public class MacUtils {

    public static void  getMac2(){
        try {

            Process process = Runtime.getRuntime().exec("ipconfig /all");

            InputStreamReader ir = new InputStreamReader(process.getInputStream(),"GBK");

            LineNumberReader input = new LineNumberReader(ir);

            String line;

            while ((line = input.readLine()) != null)
//            System.out.println(line);
            if(!StringUtils.isEmpty(line)){
                if (line.indexOf("物理地址") >= 0||line.indexOf("Physical Address") >= 0) {
//                    System.out.println(line);
                    String MACAddr = line.substring(line.indexOf("-") - 2);

                    System.out.println("MAC address = [" + MACAddr + "]");

                }
            }


        } catch (java.io.IOException e) {

            System.err.println("IOException " + e.getMessage());

        }
    }

//    private static String getMac2() throws SigarException {
//        Sigar sigar = new Sigar();
//        String[] ifaces = sigar.getNetInterfaceList();
//        for (String iface : ifaces) {
//            NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(iface);
//            if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress())
//                    || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
//                    || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
//                continue;
//            }
//            String mac = cfg.getHwaddr();
//            return mac;
//        }
//        return null;
//
//    }


    public static String getMac() {
        try {
            Enumeration<NetworkInterface> el = NetworkInterface
                    .getNetworkInterfaces();
            while (el.hasMoreElements()) {
                byte[] mac = el.nextElement().getHardwareAddress();
                if (mac == null)
                    continue;

                String hexstr = bytesToHexString(mac);
                String MACAddr = getSplitString(hexstr, "-", 2).toUpperCase();
                System.out.println("MAC address2 = [" + MACAddr + "]");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }


    public static String getSplitString(String str, String split, int length) {
        int len = str.length();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i % length == 0 && i > 0) {
                temp.append(split);
            }
            temp.append(str.charAt(i));
        }
        String[] attrs = temp.toString().split(split);
        StringBuilder finalMachineCode = new StringBuilder();
        for (String attr : attrs) {
            if (attr.length() == length) {
                finalMachineCode.append(attr).append(split);
            }
        }
        String result = finalMachineCode.toString().substring(0,
                finalMachineCode.toString().length() - 1);
        return result;
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }


//    public static void main(String[] args) {
//
//        //****************获取MAC地址*****************//
////        System.out.println("***MAC地址***");
////        getMac2();
////        String mac = getMac();
////        System.out.println(mac);
////        "I am an 20-years out--standing @ * -stu- dent";
//        Scanner in = new Scanner(System.in);
//
//        while(in.hasNextLine()){
//            String input = in.nextLine();
//            String s = new String(input);
//            input = input.replaceAll("--"," ");
//            input = input.replaceAll(" -"," ");
//            input = input.replaceAll("- "," ");
//
//            s = s.replaceAll("[a-z]","");
//            s = s.replaceAll("[A-Z]","");
//            s = s.replaceAll("[0-9]","");
//            s = s.replaceAll("-","");
//            s = s.replaceAll(" ","");
//
//
//            char[] cs = s.toCharArray();
//            if(cs!=null&&cs.length>0){
//                for(int i=0;i<cs.length;i++){
//                    input = input.replaceAll("["+cs[i]+"]","");
//                }
//            }
//            String[] ss = input.split(" ");
//            StringBuffer output = new StringBuffer();
//            if(ss!=null&&ss.length>0){
//                for(int i=ss.length-1;i>=0;i--){
//                    if(!ss[i].isEmpty()){
//                        if(output.length()==0){
//                            output.append(ss[i]);
//                        }else{
//                            output.append(" ").append(ss[i]);
//                        }
//
//                    }
//                }
//            }
//            System.out.println(output);
//        }
//    }



//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        int money = 300;
//        while(in.hasNextLine()){
//            String input = in.nextLine();
//            String[] ss = input.split(",");
//            if(ss!=null&&ss.length>0){
//                int price = ss[0]!=null?Integer.parseInt(ss[0]):-1;
//                int preDay = ss[1]!=null?Integer.parseInt(ss[1]):-1;
//                int actDay = ss[2]!=null?Integer.parseInt(ss[2]):-1;
//                int outPut = 0;
//
//                int dayPrice = 0;
//                if(price>=100){
//                    if(preDay>=15){
//                        dayPrice = 5;
//
//                    }else{
//                        dayPrice = 3;
//                    }
//
//
//                }else if(price<100&&price>=50){
//                    if(preDay>=15){
//                        dayPrice = 3;
//
//                    }else{
//                        dayPrice = 2;
//                    }
//
//                }else{
//                    dayPrice = 1;
//                }
//                if(actDay>preDay){
//                    outPut = money - dayPrice*actDay-actDay-preDay;
//                }else{
//                    outPut = money - dayPrice*actDay;
//                }
//
//                System.out.println(outPut+"");
//            }
//
//
//        }
//    }

}
