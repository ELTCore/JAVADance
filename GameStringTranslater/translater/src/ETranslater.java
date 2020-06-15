import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class ETranslater {

    public static void main(String[] args) throws IOException {
        int t = JOptionPane.showConfirmDialog(null,
                "说明:\n请确认该程序所在目录下存在oldEn.txt、oldCn.txt、newEn.txt三份文件后再继续\n启动后程序将在后台自动合并文本并在完成后通知你\n合并后的文本文件TranslaterOutput.txt会放在程序当前目录\n点击\"是\"后程序开始运行",
                "SC2Translater", 0);

        if (t == JOptionPane.YES_OPTION) {
            driver();
        } else {
            System.exit(0);
        }

    }

    static void driver() throws IOException {
        List<OneString> oldEn = new ArrayList<OneString>();
        List<OneString> oldCn = new ArrayList<OneString>();
        List<OneString> newEn = new ArrayList<OneString>();
        List<OneString> output = new ArrayList<OneString>();

        FileTools.load("oldEn.txt", oldEn);
        FileTools.load("oldCn.txt", oldCn);
        FileTools.load("newEn.txt", newEn);

        StringTools.cmpString(oldEn, oldCn, newEn, output);

        // test
        // for (OneString one : output) {
        // System.out.println("Sign = \"" + one.getSign() + "\"\t" + "Text = \"" +
        // one.getText() + "\"");
        // }

        FileTools.write(output);

        JOptionPane.showMessageDialog(null, "合并已完成", "SC2Translater", 1);

    }
}

class StringTools {
    public static void scan(String s, List<OneString> list) {

        Pattern linePattern = Pattern.compile("(.*?)=(.*?)$");

        Matcher lineMatcher = linePattern.matcher(s);

        boolean match = lineMatcher.find();

        if (!match) {
            return;
        }

        String sign = lineMatcher.group(1);
        String text = lineMatcher.group(2);

        list.add(new OneString(sign, text));

    }

    static void cmpString(List<OneString> oldEn, List<OneString> oldCn, List<OneString> newEn, List<OneString> output) {
        boolean isNewAdd;
        boolean isNewEn;

        for (OneString strOfNewEn : newEn) {
            // 默认这是一个新的词条
            isNewAdd = true;
            isNewEn = true;

            // 读取新词条的 sign 和文本
            String sign = strOfNewEn.getSign();
            String text = strOfNewEn.getText();

            for (OneString strOfOldEn : oldEn) {
                if (strOfOldEn.getSign().equals(sign)) {
                    // 如果在旧的英文String中找到了相同的sign,则将NewAdd标识改为false
                    isNewAdd = false;

                    if (strOfOldEn.getText().equals(text)) {
                        // 如果在旧英文String中这个sign的文本内容和新英文String中的文本内容也相同, 则将NewEn标识改为false
                        isNewEn = false;
                    }
                }
            }

            if (isNewAdd == true) {
                // 新词条
                text += "//NewAdd";
                output.add(new OneString(sign, text));

                // 直接进入下一个词条的检测
                continue;

            } else {
                boolean find = false;

                for (OneString strOfOldCn : oldCn) {
                    // 遍历旧中文String
                    if (strOfOldCn.getSign().equals(sign)) {

                        if ((isNewEn == true) && (isNewAdd == false)) {
                            // 英文文本发生了变化的词条
                            text = strOfOldCn.getText() + "//NewEN:" + text;
                        }

                        else {
                            // 与原来没有变化的词条
                            text = strOfOldCn.getText();
                        }
                        output.add(new OneString(sign, text));
                        find = true;
                        break;
                    }
                }

                if (find == false) {
                    // 发生了错误, 可能是旧英文文本中出现的词条在旧中文文本中不存在
                    System.out.println("ERORR: 001");
                    text += "//NewAdd";

                    output.add(new OneString(sign, text));
                }
            }
        }

    }
}

class FileTools {
    public static void load(String path, List<OneString> list) throws IOException {
        // 读取文件
        File file = new File(".\\" + path);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "当前目录下缺少文件:" + path, "SC2Translater", 0);
            System.exit(0);
        }

        // ↓因为SC2地图的String文件是带DOM的UTF-8格式,所以不能使用这个..
        // FileReader fr = new FileReader(file);
        // BufferedReader br = new BufferedReader(fr);

        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String str = br.readLine();

        while (str != null) {
            // System.out.println(str);
            StringTools.scan(str, list);

            str = br.readLine();
        }

        br.close();
        // fr.close();
    }

    public static void write(List<OneString> list) throws IOException {
        // 输出合并后的文件

        StringBuilder sb = new StringBuilder();

        for (OneString s : list) {
            sb.append(s.getSign() + "=" + s.getText() + "\r\n");
        }

        File file = new File(".\\TranslaterOutput.txt");

        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(".\\TranslaterOutput.txt", Charset.forName("utf-8"));
        // FileWriter fw = new FileWriter(".\\output.txt");

        PrintWriter pw = new PrintWriter(fw);

        pw.print(sb);
        fw.close();
    }
}

class OneString {
    private String sign = "";
    private String text = "";

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public OneString(String sign, String text) {
        this.sign = sign;
        this.text = text;
    }
}