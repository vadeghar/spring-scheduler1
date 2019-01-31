package com.batch.job.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.batch.job.scheduler.model.InvalidDataDTO;

@Component
public class ScheduledJobs {
	private static final Logger log = LoggerFactory.getLogger(ScheduledJobs.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Autowired
    SendEmail sendEmail;
    
    @Autowired
    MyDataRepostiry myDataRepostiry;
    
	//  "0 0 * * * *" = the top of every hour of every day.
	//	"*/10 * * * * *" = every ten seconds.
	//	"0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
	//	"0 0 8,10 * * *" = 8 and 10 o'clock of every day.
	//	"0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
	//	"0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
	//	"0 0 0 25 12 ?" = every Christmas Day at midnight

    @Scheduled(cron = "*/10 * * * * *")
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        StringBuilder mailContent = new StringBuilder();
        List<InvalidDataDTO> repoList = myDataRepostiry.getInvalidDataList();
        mailContent.append("<table style='border: 1px solid;'><thead><tr style='background: red;'><td>OutBound Messages</td><td>Affinium Program ID</td><td>Message ID</td><td>SMS Response (Example Text)</td><td>Count</td></tr></thead>");
        mailContent.append("<tbody>");
        for(InvalidDataDTO dto : repoList) {
        	log.info("Appending to list {}", dto.toString());
        	mailContent.append("<tr><td>"+dto.getOuboundMessage()+"</td><td>"+dto.getPrgramId()+"</td><td>"+dto.getMessageId()+"</td><td>"+dto.getSmsResponse()+"</td><td>"+dto.getSentCount()+"</td></tr>");
        	log.info("current html text {}", mailContent.toString());
        }
        mailContent.append("</tbody></table>");
        log.info("final html text {}", mailContent.toString());
        sendEmail.sendMessage(mailContent.toString());
    }
}
