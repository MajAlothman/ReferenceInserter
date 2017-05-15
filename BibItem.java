
public class BibItem {
    private String  type    = "";
    private String  key     = "";
    private String  title   = "No title specified";
    private String  author  = "No author specified";
    private int     year    = 0;
    private String otherInfo = "" ;
    
    public BibItem(String key , String title,String author,int year){
        this.key = key;
        this.title  = title;
        this.author = author;
        this.year   = year;
    }
    public BibItem(String key){
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public String getKey() {
        return key;
    }
    
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void addOtherInfo(String otherInfo) {
        this.otherInfo += " " + otherInfo;
    }

    public String toString() {
        return key ;
    }
    
}
