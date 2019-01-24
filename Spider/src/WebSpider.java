import com.sun.jdi.event.StepEvent;

import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.net.URL;

/**
 * this class contains everything that the webspider needs to scrape urls and emails from a specific number of websites
 */
public class WebSpider {
    private String url;
    private HashMap<String, Boolean> websiteURLS = new HashMap<String,Boolean>();
    private Set<String> emails = new HashSet<String>();
    private StringBuilder contents;
    //private final String URLPattern = "<a\s+(?:[^>]*?\s+)?href=(["'])(.*?)\1";
    private final String URLPattern = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
    //private final String URLPattern = "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";

    private final String emailPattern = "\\b[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.-]+\\b";

    /**
     * this constructs a spider with a given url as a starting point
     * @param URL is a url of type String that gives a starting website
     */
    WebSpider(String URL){
        try {
            this.url = URL;
            getContent();
        }
        catch(Exception e){
            System.out.println("Could not create object");
        }
    }

    /**
     * this sets the starting url
     * @param url of type String
     */
    public void setURL(String url){
        this.url = url;
    }


    /**
     * this reads in all of the data from the website and appends it to contents
     */
    public void getContent(){
        try{
            URL url = new URL(this.url);
            BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));
            contents = new StringBuilder();
            String line = "";
            while ((line = rdr.readLine()) != null) {
               // System.out.printf("%s\n", line);
                contents.append(line);
            }
        }
        catch (Exception ex) {
            System.out.printf("Oops: %s", ex.getMessage());
        }
    }

    /**
     * uses regex to find emails and adds them the the emails set
     */
    public void scrapeEmails(){
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(contents);
        while(matcher.find()){
            emails.add(matcher.group());
        }
    }

    /**
     * uses regex to find urls and adds them to the urls map
     */
    public void scrapeURLS(){
        Pattern pattern = Pattern.compile(URLPattern);
        Matcher matcher = pattern.matcher(contents);
        while(matcher.find()){
            // doesn't add link if the map already contains the url
            if (!websiteURLS.containsKey(matcher.group())) {
                websiteURLS.put(matcher.group(), false);
            }
        }
    }

    /**
     * outputs all emails
     */
    public void displayEmails(){
        if (emails.size() > 0){
            for (String email: emails){
                System.out.println(email);
            }
        }
        else {
            System.out.println("No emails were found");
        }
    }

    /**
     * outputs all urls
     */
    public void displayURLS(){
        if (websiteURLS.size()>0){
            System.out.println(websiteURLS);
        }
        else{
            System.out.println("No URLs were found");
        }
    }

    /**
     * finds the next url in the map and sets it as the next url to navigate to
     * @return url of type String
     */
    public String getNextLink(){
        Iterator URLIterator = websiteURLS.entrySet().iterator();
        Map.Entry mapElement = (Map.Entry)URLIterator.next();
        if (URLIterator.hasNext() && (boolean)mapElement.getValue() == false) {
            websiteURLS.put((String)mapElement.getKey(), true);
            return (String)mapElement.getValue();
        }
        return "";
    }

    // main test function
   public static void main(String[] args){
        WebSpider spider = new WebSpider("https://www.westada.org/Domain/1488");
        spider.beginSpidering(100);
        System.out.println("\nEmails harvested:");
        spider.displayEmails();
        //spider.displayURLS();
    }

    /**
     * this is the main action loop where urls and emails are scraped from different webpages
     * @param numberLinksTraversed of type int, amount of links spider will look at
     */
    public void beginSpidering(int numberLinksTraversed){
        for (int i =0; i < numberLinksTraversed; i++){
            scrapeURLS();
            scrapeEmails();
            try {
                setURL(getNextLink());
            }
            catch (Exception e){
                System.out.println("No more links to traverse");
                break;
            }
        }
    }

}
