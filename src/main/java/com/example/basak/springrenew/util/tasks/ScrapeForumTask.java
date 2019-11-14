package com.example.basak.springrenew.util.tasks;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

@Log4j2
public class ScrapeForumTask implements Runnable {

    private final String email;
    private final String userName;
    private final static String FORUM_URL = "https://forum.grodno.net/index.php?board=346.0;sort=first_post;desc";

    public ScrapeForumTask(String email, String userName) {
        this.email = email;
        this.userName = userName;
    }

    @Override
    public void run() {
        log.debug("ScrapeForumTask is running");
        try {
            System.out.println(FORUM_URL);

            //2. Fetch the HTML code
            Document document = Jsoup.connect(FORUM_URL).get();
            //3. Parse the HTML to extract links to other URLs
            Elements linksOnPage = document.select("a[href]");

            Elements trElements = document.select("form tr");

            //i = 3 because skipp first 3 elements
            for (int i = 3; i < trElements.size(); i++) {
                Elements tdElements = trElements.eq(i).select("td");
                if (StringUtil.isBlank(tdElements.eq(2).first().attr("class"))) {
                    continue;
                }
                String timeColumn = tdElements.select("i").text();

                if (!StringUtil.isBlank(timeColumn)) {

                } else {
                    continue;
                }

            }

//            document.select("form").first().select("tr").stream()
//                    .skip(3)
//                    .map(element -> {
//                        element.select("td")
//                    })

        } catch (IOException e) {
            log.error(String.format(
                    "Scraping failed for '%s' with exception: %s",
                    FORUM_URL,
                    e.getMessage()));
        }
    }
}
