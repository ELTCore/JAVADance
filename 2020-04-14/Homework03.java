import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// -------------------------------------------------------------------------------------

// <html><head><title>Welcome to Wuhan Textile University's home page</title></head></html>
// <body><img src='1.jpg'/>
// <a href='1.htm'>Home Page</a>
// <a href='2.htm'>Teaching Affairs Department</a>
// <a href='3.htm'>Math And Computetr Technology Academy</a>
// <img src='2.jpg'/>
// <img src='3.jpg'/>
// </body></html>

// use the regular expression to extract information from the above string

// E.g:
// OUTPUT:
// Page's title:Welcome to Wuhan Textile University's home page
// The page has 3 image(s), name(s): 1.jpg, 2.jpg, 3.jpg
// The page has 3 hyperlink(s),hyperlink(s) imformation:

// Title                     Address
// Home Page                 1.htm

// -------------------------------------------------------------------------------------

public class Homework03 {

    static String title = "";
    static ArrayList<String> imgList = new ArrayList<String>();
    static ArrayList<Href> HrefList = new ArrayList<Href>();

    public static void main(String[] args) {
        System.out.println("date: 2020-04-23\n");

        String s = "<html><head><title>Welcome to Wuhan Textile University's home page</title></head></html> <body><img src='1.jpg'/> <a href='1.htm'>Home Page</a> <a href='2.htm'>Teaching Affairs Department</a> <a href='3.htm'>Math And Computetr Technology Academy</a> <img src='2.jpg'/> <img src='3.jpg'/> </body></html>";

        System.out.println(
                "text:\n <html><head><title>Welcome to Wuhan Textile University's home page</title></head></html>\n <body><img src='1.jpg'/>\n <a href='1.htm'>Home Page</a>\n <a href='2.htm'>Teaching Affairs Department</a>\n <a href='3.htm'>Math And Computetr Technology Academy</a>\n <img src='2.jpg'/>\n <img src='3.jpg'/>\n </body></html>");
        scan(s);

        // ------------------------------
        // OUTPUT
        // ------------------------------
        System.out.println("\n\nOUTPUT:");
        System.out.println("Page's title:" + title);
        System.out.print("\n\nThe page has " + imgList.size() + " image(s), name(s):");
        for (int i = 0; i < imgList.size(); ++i) {
            System.out.print(" " + imgList.get(i));
        }
        System.out.println("\n\nThe page has " + HrefList.size() + " hyperlink(s) imformation:");
        System.out.println("\nTitle\t\tAddress");
        for (int i = 0; i < HrefList.size(); ++i) {
            System.out.println(HrefList.get(i).getTitle() + "\t\t" + HrefList.get(i).getAdress());
        }
    }

    static void scan(String s) {
        // --------------------
        // titlePattern
        // --------------------
        Pattern titlePattern = Pattern.compile("<title>(.*?)</title>", Pattern.CASE_INSENSITIVE);
        Matcher titleMatcher = titlePattern.matcher(s);
        while (titleMatcher.find()) {
            title = titleMatcher.group(1);
        }

        // --------------------
        // imgPattern
        // --------------------
        Pattern imgPattern = Pattern.compile("(img)(.*?)(>|></img>|/>)", Pattern.CASE_INSENSITIVE);
        Matcher imgMatcher = imgPattern.matcher(s);
        boolean hasImg = imgMatcher.find();
        if (hasImg) {
            while (hasImg) {
                String group = imgMatcher.group(2);
                Pattern srcText = Pattern.compile("(src)=(\"|\')(.*?)(\"|\')", Pattern.CASE_INSENSITIVE);
                Matcher matcher = srcText.matcher(group);
                if (matcher.find()) {
                    imgList.add(matcher.group(3));
                }
                hasImg = imgMatcher.find();
            }
        }
        // --------------------
        // hyperlinkPattern
        // --------------------
        Pattern hyperlinkPattern = Pattern.compile("<a href=\'(.*?)\'>(.*?)</a>", Pattern.CASE_INSENSITIVE);
        Matcher hyperlinkMatcher = hyperlinkPattern.matcher(s);
        boolean hasHyperlink = hyperlinkMatcher.find();
        if (hasHyperlink) {
            while (hasHyperlink) {
                HrefList.add(new Href());
                HrefList.get(HrefList.size() - 1).setTitle(hyperlinkMatcher.group(1));
                HrefList.get(HrefList.size() - 1).setAdress(hyperlinkMatcher.group(2));
                hasHyperlink = hyperlinkMatcher.find();
            }
        }

    }
}

class Href {
    private String title = "";
    private String adress = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}