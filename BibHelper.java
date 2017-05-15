
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

public class BibHelper {
    
    
    public static ArrayList<BibItem> parseBibFileToBibItemArray(String directory){
        FileInputStream file=null;
        try{
            file = new FileInputStream(directory);
        }catch (FileNotFoundException e){
            System.out.println("Error:- The file is not found");
        }
        Scanner reader = new Scanner(file);
        ArrayList<BibItem> library = new ArrayList();
        Stack <Integer> bibItemStartEndIdentifier = new Stack<>();
        String temp = "";
        int i = 1;
        while(reader.hasNext()){
            temp = reader.nextLine();
            if(temp == "" || temp == null || temp == "\n" || temp.startsWith("@comment")){
                
            }
            else if(temp.startsWith("@")){
                BibItem item = new BibItem(temp.substring(temp.indexOf('{')+1,temp.indexOf(',')));
                item.setType(temp.substring(0,temp.indexOf('{')));
                bibItemStartEndIdentifier = stackPusher(temp,bibItemStartEndIdentifier);
                while(!bibItemStartEndIdentifier.isEmpty()){
                    temp = reader.nextLine();
                    if(temp.contains("  author =")){
                        while(numOfOpenBrackets(temp) != numOfClosedBrackets(temp)){
                            temp += reader.nextLine();
                        }
                        temp = temp.substring(temp.indexOf('{'),temp.lastIndexOf('}'));
                        item.setAuthor(bracketsRemover(temp));
                    }
                    else if(temp.contains("  title =")){
                        while(numOfOpenBrackets(temp) != numOfClosedBrackets(temp)){
                            temp += reader.nextLine();
                        }
                        temp = temp.substring(temp.indexOf('{'),temp.lastIndexOf('}'));
                        item.setTitle(bracketsRemover(temp));
                    }
                    else if(temp.contains("  year =")){
                        while(numOfOpenBrackets(temp) != numOfClosedBrackets(temp)){
                            temp += reader.nextLine();
                        }
                        temp = temp.substring(temp.indexOf('{'),temp.lastIndexOf('}'));
                        item.setYear(Integer.parseInt(bracketsRemover(temp)));
                    }
                    else{
                        item.addOtherInfo(temp);
                        bibItemStartEndIdentifier = stackPusher(temp,bibItemStartEndIdentifier);
                    }
                }
                
                library.add(item);
            }
        }
        reader.close();
        return library;// return the ArrayList of bibItems containg the  
    }
    
    public static ArrayList<BibItem> searchBibArray(ArrayList<BibItem> library,String word){
        ArrayList<BibItem> result = new ArrayList();
        ListIterator i = library.listIterator();
        while(i.hasNext()){
            try{
                BibItem comparator = (BibItem)i.next();
                if(comparator.getKey().toLowerCase().contains(word.toLowerCase()) ||
                   comparator.getTitle().toLowerCase().contains(word.toLowerCase()) ||
                   comparator.getAuthor().toLowerCase().contains(word.toLowerCase()) ||
                   comparator.getOtherInfo().toLowerCase().contains(word.toLowerCase()) ||
                   comparator.getYear()== Integer.parseInt(word))
                {
                    result.add(comparator);
                }
            }
            catch(NumberFormatException e){
            }
        }
        return result;//return the result array that contains bibitems matches the specified word
    }
    
    private static Stack<Integer> stackPusher(String statment,Stack bibItemStartEndIdentifier){
        int numOfOpenBrackets = numOfOpenBrackets(statment);
        int numOfClosedBrackets = numOfClosedBrackets(statment);
        for(int i = 0; i < numOfOpenBrackets ; i++){
            bibItemStartEndIdentifier.push(1);
        }
        for(int i = 0; i < numOfClosedBrackets ; i++){
            bibItemStartEndIdentifier.pop();
        }
        return bibItemStartEndIdentifier;
    }
    
    private static int numOfOpenBrackets(String statment){
        return statment.length() - statment.replace("{","").length();
    }
    
    private static int numOfClosedBrackets(String statment){
        return statment.length() - statment.replace("}","").length();
    }
    
    public static String bracketsRemover(String statment){
        return statment.replace("{","").replace("}","");
    }
    
    public static void main(String[] a){
        
        System.out.println(searchBibArray(parseBibFileToBibItemArray("D:\\Downloads\\library.bib"),"open"));
        //System.out.println("adasdasd".replace("a","A"));
    }
}
