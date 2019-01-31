package com.batch.job.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.batch.job.scheduler.model.InvalidDataDTO;

@Service
public class MyDataRepostiry {
	
	public List<InvalidDataDTO> getInvalidDataList() {
		
		List<InvalidDataDTO> list = new ArrayList<InvalidDataDTO>();
			list.add(new InvalidDataDTO("PCSK9TextShipmentReminder","PRG2403","0001KaAXFA9706CD"," ACCREDO: Your Rx refill is ready for shipment and your credit card will be charged. If you need to make changes please call us at 855.315.6123 within 72 hrs. Reply R to reschedule order, HELP for help, or STOP to cancel text messaging. Message and data rates may apply",2));
			list.add(new InvalidDataDTO("PCSK9ShipmentShippedNotification","PRG2404","0001KaAXFA9706CK"," ACCREDO: Your prescription has shipped. Check its status at UPS Tracking 1Z3024EF1300378970 Reply HELP for help, STOP to cancel. Msg&data rates may apply.",0));
			list.add(new InvalidDataDTO("TextRefillReminderRR","PRG2408","0001KaAXFA9706C4"," ACCREDO: Your medicine is due to be filled. Call us at 8008706419 to place your order. Reply HELP for help, STOP to cancel. Msg&data rates may apply",2));
			list.add(new InvalidDataDTO("TextNewRenewals","PRG2408OS","0001KaAXFA9706C4"," ACCREDO: Your medicine is due to be filled. Call us at 8006896592 to place your order. Reply HELP for help, STOP to cancel. Msg&data rates may apply",0));
		
		return list;
	}
}
